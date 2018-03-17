package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.PaisEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(CiudadEntity.class)
public class CiudadEntity_ { 

    public static volatile SingularAttribute<CiudadEntity, String> nombreCiudad;
    public static volatile SingularAttribute<CiudadEntity, Integer> codigoCiudad;
    public static volatile SingularAttribute<CiudadEntity, Long> idCiudad;
    public static volatile SingularAttribute<CiudadEntity, PaisEntity> pais;

}