select * from articulo;
insert into articulo (descripcion, costo, margen_ganancia, categoria_id, marca_id, tipo_talle_id) 
			values ('Remera mangas cortas', 30000, 0.7, 6, 1, 1);
--7: buzo, 2: zapatillas, 10: medias, 11: medias, 12: remera mangas cortas


select * from categoria; 
-- 5: calzados, 6: remeras, 7: pantalones, 8: indumentaria

select * from color;
-- Ids del 1 al 4

select * from talle;
update talle set tipo_talle_id = 2 where id >=9;
--Numeros son del 1 al 8, letras del 10 al 15

select * from stock;
insert into stock (cantidad, articulo_codigo, color_id, talle_id, sucursal_id) 
			values (10, 7, 4, 10, 1);
update stock set sucursal_id = 2 where id >=4;		

			
insert into condicion_tributaria (descripcion) values ('Consumidor Final');
select * from condicion_tributaria;
-- 1: RI, 2: M, 3: E, 4: NR, 5: CF

insert into tienda (cuit, direccion, nombre, telefono, condicion_tributaria_id) 
			values (20024393969, 'Los alamos 331', 'La Tienda', '381437612', 1);
select * from tienda;
-- CUIT: 20024393969

insert into sucursal (nombre, direccion, tienda_cuit) values ('Sucursal Norte', 'Juangorena 377', 20024393969);
select * from sucursal;
-- CENTRO: id = 1, NORTE: id = 2

insert into punto_venta (sucursal_id) values (2);
select * from punto_venta;
-- Puntos de venta de sucursal CENTRO: ids: 1,2,3. Puntos de venta de sucursal NORTE: ids: 4,5


