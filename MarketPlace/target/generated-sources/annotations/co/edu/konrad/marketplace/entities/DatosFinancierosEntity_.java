package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.ProveedorEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(DatosFinancierosEntity.class)
public class DatosFinancierosEntity_ { 

    public static volatile SingularAttribute<DatosFinancierosEntity, String> nivelreputacion;
    public static volatile SingularAttribute<DatosFinancierosEntity, Long> idProveedor;
    public static volatile SingularAttribute<DatosFinancierosEntity, ProveedorEntity> proveedor;
    public static volatile SingularAttribute<DatosFinancierosEntity, String> mercadoObjetivo;
    public static volatile SingularAttribute<DatosFinancierosEntity, Integer> ventasAnuales;

}