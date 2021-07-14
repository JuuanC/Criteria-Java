package org.acme.repository;

import org.acme.dto.UpdateDTO;
import org.acme.dto.consulta.ConsultaDTO;
import org.acme.entity.Proveedor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProveedorRepository extends Repository<Proveedor> {

    @Override
    Class<Proveedor> getEntity() {
        return Proveedor.class;
    }

    @Override
    public List get(ConsultaDTO consultaDTO, boolean bajaLogica) {
        return super.get(consultaDTO, bajaLogica);
    }

    @Transactional
    @Override
    public Proveedor save(Proveedor entity) {
        return super.save(entity);
    }

    @Transactional
    @Override
    public void update(UpdateDTO element) {
        super.update(element);
    }

    @Transactional
    @Override
    public void bajaLogica(int value) {
        super.bajaLogica(value);
    }

    @Override
    public void altaLogica(int value) {
        super.altaLogica(value);
    }

    @Override
    public List getLike(ConsultaDTO consultaDTO, boolean bajaLogica) {
        return super.getLike(consultaDTO, bajaLogica);
    }

}
