package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.ClienteEntity;
import co.edu.konrad.marketplace.entities.TipoPagoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(DatosPagoEntity.class)
public class DatosPagoEntity_ { 

    public static volatile SingularAttribute<DatosPagoEntity, String> nombreBanco;
    public static volatile SingularAttribute<DatosPagoEntity, Integer> codClave;
    public static volatile SingularAttribute<DatosPagoEntity, ClienteEntity> cliente;
    public static volatile SingularAttribute<DatosPagoEntity, String> franquiciaBanco;
    public static volatile SingularAttribute<DatosPagoEntity, Integer> nroCuenta;
    public static volatile SingularAttribute<DatosPagoEntity, Integer> nroTarjeta;
    public static volatile SingularAttribute<DatosPagoEntity, TipoPagoEntity> tipoPago;
    public static volatile SingularAttribute<DatosPagoEntity, Long> idDatosPago;

}