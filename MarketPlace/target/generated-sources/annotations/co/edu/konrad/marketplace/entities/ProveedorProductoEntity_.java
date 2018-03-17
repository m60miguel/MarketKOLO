package co.edu.konrad.marketplace.entities;

import co.edu.konrad.marketplace.entities.ProductoEntity;
import co.edu.konrad.marketplace.entities.ProveedorEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-15T00:06:49")
@StaticMetamodel(ProveedorProductoEntity.class)
public class ProveedorProductoEntity_ { 

    public static volatile SingularAttribute<ProveedorProductoEntity, String> descripcionProveedorProducto;
    public static volatile SingularAttribute<ProveedorProductoEntity, String> tipoProveedorProducto;
    public static volatile SingularAttribute<ProveedorProductoEntity, Long> idProveedorProducto;
    public static volatile SingularAttribute<ProveedorProductoEntity, ProveedorEntity> proveedor;
    public static volatile SingularAttribute<ProveedorProductoEntity, ProductoEntity> producto;

}