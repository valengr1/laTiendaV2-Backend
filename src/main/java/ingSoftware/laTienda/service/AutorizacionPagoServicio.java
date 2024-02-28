package ingSoftware.laTienda.service;

import com.google.gson.Gson;
import ingSoftware.laTienda.model.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@Service
public class AutorizacionPagoServicio {

    public String solicitarTokenPago(Tarjeta tarjeta, Double monto) throws URISyntaxException, IOException, InterruptedException {
        String idTransaccion = UUID.randomUUID().toString();
        System.out.println(idTransaccion);
        SolicitudPagoTarjeta solicitud = new SolicitudPagoTarjeta();
        solicitud.setCard_number(tarjeta.getNumeroTarjeta());
        solicitud.setCard_expiration_month(tarjeta.getMesVencimiento());
        solicitud.setCard_expiration_year(tarjeta.getAnioVencimiento());
        solicitud.setSecurity_code(tarjeta.getCodigoSeguridad());
        solicitud.setCard_holder_name(tarjeta.getNombreTitular());
        Card_holder_identification cardHolderIdentification = new Card_holder_identification();
        cardHolderIdentification.setType("dni");
        cardHolderIdentification.setNumber(tarjeta.getDniTitular());
        solicitud.setCard_holder_identification(cardHolderIdentification);
        Gson gson = new Gson();
        String jsonRequest =  gson.toJson(solicitud);
        //System.out.println(jsonRequest);
        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://developers.decidir.com/api/v2/tokens"))
                .header("apikey","b192e4cb99564b84bf5db5550112adea")
                .header("Cache-Control", "no-cache")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        //System.out.println(postResponse.body());

        SolicitudPagoTarjetaResponse solicitudPagoTarjetaResponse = gson.fromJson(postResponse.body(), SolicitudPagoTarjetaResponse.class);
        String id = solicitudPagoTarjetaResponse.getId();
        String bin = solicitudPagoTarjetaResponse.getBin();
        ConfirmarPagoRequest confirmarPagoRequest = new ConfirmarPagoRequest();
        confirmarPagoRequest.setSite_transaction_id(idTransaccion); // debe ir cambiando por cada transaccion
        confirmarPagoRequest.setPayment_method_id(1);
        confirmarPagoRequest.setToken(id); //obtener del metodo anterior
        confirmarPagoRequest.setBin(bin); //obtener del metodo anterior
        confirmarPagoRequest.setAmount(monto);
        confirmarPagoRequest.setCurrency("ARS");
        confirmarPagoRequest.setInstallments(1);
        confirmarPagoRequest.setPayment_type("single");
        confirmarPagoRequest.setEstablishment_name("single");
        Sub_payments subPayments = new Sub_payments();
        subPayments.setSite_id("");
        subPayments.setAmount(monto);
        subPayments.setInstallments(1);
        confirmarPagoRequest.setSub_payments(List.of(subPayments));

        String jsonRequest2 =  gson.toJson(confirmarPagoRequest);
        System.out.println(jsonRequest2);
        HttpRequest postRequest2 = HttpRequest.newBuilder()
                .uri(new URI("https://developers.decidir.com/api/v2/payments"))
                .header("apikey","566f2c897b5e4bfaa0ec2452f5d67f13")
                .header("Cache-Control", "no-cache")
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest2))
                .build();

        HttpResponse<String> postResponse2 = httpClient.send(postRequest2, HttpResponse.BodyHandlers.ofString());
        ConfirmarPagoResponse confirmarPagoResponse = gson.fromJson(postResponse2.body(), ConfirmarPagoResponse.class);

        if(confirmarPagoResponse.getError_type() == null && confirmarPagoResponse.getStatus().equals("approved")){
            return "Pago aprobado";
        } else{
            return confirmarPagoResponse.getError_type();
        }

    }
}
