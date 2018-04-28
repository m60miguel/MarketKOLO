/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.resources;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Esta clase registra la informacion de las clases que van a ser utilizadas como servicios REST
 * @author DarkFACS
 */
@ApplicationPath("/api")
public class ApplicationConfig extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        addRestResourceClasses(resources);
        return resources;
    } 
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(co.edu.konrad.marketplace.resources.CiudadResource.class);
        resources.add(co.edu.konrad.marketplace.resources.ClienteResource.class);
        resources.add(co.edu.konrad.marketplace.resources.ComunicacionResource.class);
        resources.add(co.edu.konrad.marketplace.resources.DatosFinancierosResource.class);
        resources.add(co.edu.konrad.marketplace.resources.DatosPagoResource.class);
        resources.add(co.edu.konrad.marketplace.resources.EnvioResource.class);
        resources.add(co.edu.konrad.marketplace.resources.EvaluacionResource.class);
        resources.add(co.edu.konrad.marketplace.resources.FacturaResource.class);
        resources.add(co.edu.konrad.marketplace.resources.PaisResource.class);
        resources.add(co.edu.konrad.marketplace.resources.ProductoResource.class);
        resources.add(co.edu.konrad.marketplace.resources.ProveedorProductoResource.class);
        resources.add(co.edu.konrad.marketplace.resources.ProveedorResource.class);
        resources.add(co.edu.konrad.marketplace.resources.TipoPagoResource.class);
        resources.add(co.edu.konrad.marketplace.resources.TipoProductoResource.class);
    }
}
