package org.acme.repository;

import org.acme.dto.consulta.ConsultaDTO;
import org.acme.entity.Telefono;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TelefonoRepository extends Repository<Telefono>{
    @Override
    public List get(Class<Telefono> entity, ConsultaDTO consultaDTO) {
        return super.get(entity, consultaDTO);
    }

    @Transactional
    @Override
    public Telefono save(Telefono entity) {
        return super.save(entity);
    }

    @Transactional
    @Override
    public Telefono update(Telefono entity) {
        return super.update(entity);
    }
}
