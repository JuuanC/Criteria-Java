package org.acme.repository;

import org.acme.dto.consulta.ConsultaDTO;
import org.acme.entity.Proveedor;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProveedorRepository extends Repository<Proveedor> {

    @Override
    public List get(Class<Proveedor> entity, ConsultaDTO consultaDTO) {
        return super.get(Proveedor.class, consultaDTO);
    }

    @Transactional
    @Override
    public Proveedor save(Proveedor entity) {
        return super.save(entity);
    }

    @Transactional
    @Override
    public Proveedor update(Proveedor entity) {
        return super.update(entity);
    }
}
