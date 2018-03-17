package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.TipoProductoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(ProductoEntity.class)
public class ProductoEntity_ { 

    public static volatile SingularAttribute<ProductoEntity, String> marcaProducto;
    public static volatile SingularAttribute<ProductoEntity, Integer> garantiaProducto;
    public static volatile SingularAttribute<ProductoEntity, Integer> valorProducto;
    public static volatile SingularAttribute<ProductoEntity, TipoProductoEntity> tipoProducto;
    public static volatile SingularAttribute<ProductoEntity, Long> idProducto;
    public static volatile SingularAttribute<ProductoEntity, String> nombreProducto;

}