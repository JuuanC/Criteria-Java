package org.acme.repository;

import org.acme.dto.consulta.ConsultaDTO;
import org.acme.entity.Telefono;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class TelefonoRepository extends Repository<Telefono> {

    @Override
    Class<Telefono> getEntity() {
        return Telefono.class;
    }

    @Override
    public List get(ConsultaDTO consultaDTO, boolean bajaLogica) {
        return super.get(consultaDTO, bajaLogica);
    }

    @Transactional
    @Override
    public Telefono save(Telefono entity) {
        return super.save(entity);
    }

    /*@Transactional
    @Override
    public Telefono update(Class<Telefono> entity, Telefono element) {
        return super.update(Telefono.class, element);
    }*/
}
