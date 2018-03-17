package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.ClienteEntity;
import co.edu.konrad.marketplace.entities.ProductoEntity;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(FacturaEntity.class)
public class FacturaEntity_ { 

    public static volatile SingularAttribute<FacturaEntity, Integer> cantidadCompra;
    public static volatile SingularAttribute<FacturaEntity, Date> fechaCompra;
    public static volatile SingularAttribute<FacturaEntity, ClienteEntity> cliente;
    public static volatile SingularAttribute<FacturaEntity, Long> idFactura;
    public static volatile SingularAttribute<FacturaEntity, ProductoEntity> producto;

}