package Clases;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Factura.class)
public abstract class Factura_ {

	public static volatile SingularAttribute<Factura, Integer> idInf;
	public static volatile SingularAttribute<Factura, Boolean> estado;
	public static volatile SingularAttribute<Factura, Integer> idCliente;
	public static volatile SingularAttribute<Factura, Integer> idTipoPago;
	public static volatile SingularAttribute<Factura, Integer> idEmpleado;
	public static volatile SingularAttribute<Factura, Integer> iDtipofactura;
	public static volatile SingularAttribute<Factura, String> fechaHora;
	public static volatile SingularAttribute<Factura, Integer> iDFactura;
	public static volatile SingularAttribute<Factura, Double> cantidadPago;
	public static volatile SingularAttribute<Factura, String> numFactura;
	public static volatile SingularAttribute<Factura, String> numeroTarjeta;
	public static volatile SingularAttribute<Factura, Integer> idRazonSocial;

}

