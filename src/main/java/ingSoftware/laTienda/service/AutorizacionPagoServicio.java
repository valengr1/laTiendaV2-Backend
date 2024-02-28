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

@Service
public class AutorizacionPagoServicio {
    public String solicitarTokenPago() throws URISyntaxException, IOException, InterruptedException {
        SolicitudPagoTarjeta solicitud = new SolicitudPagoTarjeta();
        solicitud.setCard_number("4507990000004905");
        solicitud.setCard_expiration_month("08");
        solicitud.setCard_expiration_year("24");
        solicitud.setSecurity_code("123");
        solicitud.setCard_holder_name("John Doe");
        Card_holder_identification cardHolderIdentification = new Card_holder_identification();
        cardHolderIdentification.setType("dni");
        cardHolderIdentification.setNumber("25123456");
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
        ConfirmarPagoRequest confirmarPagoRequest = new ConfirmarPagoRequest();
        confirmarPagoRequest.setSite_transaction_id("1234");
        confirmarPagoRequest.setPayment_method_id(1);
        confirmarPagoRequest.setToken(id);
        confirmarPagoRequest.setBin("450799");
        confirmarPagoRequest.setAmount(100.0);
        confirmarPagoRequest.setCurrency("ARS");
        confirmarPagoRequest.setInstallments(1);
        confirmarPagoRequest.setPayment_type("single");
        confirmarPagoRequest.setEstablishment_name("single");
        Sub_payments subPayments = new Sub_payments();
        subPayments.setSite_id("");
        subPayments.setAmount(100.0);
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
        System.out.println(postResponse.body());
        return postResponse2.body();
    }
}
