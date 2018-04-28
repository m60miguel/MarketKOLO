/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.konrad.marketplace.logic;

import co.edu.konrad.marketplace.entities.EnvioEntity;
import co.edu.konrad.marketplace.persistence.EnvioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author DarkFACS
 */
@Stateless
public class EnvioLogic {
    
    /**
     * Inyeccion del Persistence de Envio
     */
    @Inject
    private EnvioPersistence envioPersistence;

    /**
     * Obtener Listado de Envio. Inyeccion del persistence del envio
     *
     * @return
     */
    public List<EnvioEntity> obtenerEnvios() {
        List<EnvioEntity> envio = envioPersistence.findAll();
        return envio;
    }

    /**
     * Obtener un envio desde el Identificador (id)
     *
     * @param id
     * @return envio encontrado
     */
    public EnvioEntity obtenerEnvioPorId(Long id) {
        EnvioEntity envio = envioPersistence.find(id);
        if (envio == null) {
            throw new IllegalArgumentException("El envio solicitado no existe");
        }
        return envio;
    }

    /**
     * Metodo utilizado para crear una Nuevo Envio
     *
     * @param envio
     * @return envio creado
     */
    public EnvioEntity crearEnvio(EnvioEntity envio) {
        envioPersistence.create(envio);
        return envio;
    }

    /**
     * Actualizar un objeto Envio
     *
     * @param id
     * @param envio
     * @return envio actualizado
     */
    public EnvioEntity actualizarEnvio(Long id, EnvioEntity envio) {
        EnvioEntity envioEntity = envioPersistence.update(envio);
        return envioEntity;
    }

    /**
     * Borrar un envio desde el ID
     *
     * @param id
     */
    public void eliminarEnvio(Long id) {
        envioPersistence.delete(id);
    }
}
