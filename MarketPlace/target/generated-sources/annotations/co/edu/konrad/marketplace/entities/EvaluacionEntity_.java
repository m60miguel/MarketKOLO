package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.ProductoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-04-22T22:34:03")
@StaticMetamodel(EvaluacionEntity.class)
public class EvaluacionEntity_ { 

    public static volatile SingularAttribute<EvaluacionEntity, Long> idEvaluacion;
    public static volatile SingularAttribute<EvaluacionEntity, ProductoEntity> producto;
    public static volatile SingularAttribute<EvaluacionEntity, String> comentarioEvaluacion;
    public static volatile SingularAttribute<EvaluacionEntity, Integer> calificacionEvaluacion;

}