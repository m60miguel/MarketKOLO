package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.ProveedorEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(ComunicacionEntity.class)
public class ComunicacionEntity_ { 

    public static volatile SingularAttribute<ComunicacionEntity, String> tipoComunicacion;
    public static volatile SingularAttribute<ComunicacionEntity, Long> idComunicacion;
    public static volatile SingularAttribute<ComunicacionEntity, String> descripcionComunicacion;
    public static volatile SingularAttribute<ComunicacionEntity, ProveedorEntity> proveedor;

}