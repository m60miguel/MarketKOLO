package co.edu.konrad.marketplace.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-02T10:01:39")
@StaticMetamodel(FacturaEntity.class)
public class FacturaEntity_ { 

    public static volatile SingularAttribute<FacturaEntity, Integer> cantidadCompra;
    public static volatile SingularAttribute<FacturaEntity, Date> fechaCompra;
    public static volatile SingularAttribute<FacturaEntity, Integer> clienteId;
    public static volatile SingularAttribute<FacturaEntity, Integer> productoId;
    public static volatile SingularAttribute<FacturaEntity, Long> idFactura;

}