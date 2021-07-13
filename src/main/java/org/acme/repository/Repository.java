package org.acme.repository;

import org.acme.dto.UpdateDTO;
import org.acme.dto.consulta.ConsultaDTO;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Map;

public abstract class Repository<E> {

    @Inject
    EntityManager entityManager;

    abstract Class<E> getEntity();

    public List get(ConsultaDTO consultaDTO) {
        //CREACIÓN DE OBJETOS PARA LA QUERY
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaQuery criteriaQuery = getCriteriaQuery(criteriaBuilder);
        Root<E> root = getRoot(criteriaQuery);
        Predicate predicate = criteriaBuilder.conjunction();

        //FILTRO DE ORDEN
        if (consultaDTO.getOrden().getEsAscendente()) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(consultaDTO.getOrden().getCampo())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(consultaDTO.getOrden().getCampo())));
        }

        //AGREGANDO PARAMETROS A LA QUERY PARA EL FILTRO
        for (Map.Entry<String, String> entry : consultaDTO.getParametros().entrySet()) {
            predicate.getExpressions()
                    .add(criteriaBuilder
                            .equal(root.get(entry.getKey()).as(String.class),
                                    entry.getValue()));
        }

        //FILTRO POR RANGO
        if (consultaDTO.getRango() != null) {
            predicate.getExpressions()
                    .add(criteriaBuilder.
                            between(root.get(consultaDTO.getRango().getCampo()).as(String.class),
                                    consultaDTO.getRango().getInicio(), consultaDTO.getRango().getFin()));
        }

        criteriaQuery.where(predicate);
        System.out.println(criteriaQuery);
        return entityManager.createQuery(criteriaQuery)
                .setMaxResults(consultaDTO.getPaginacion().getTamanio())
                .setFirstResult(consultaDTO.getPaginacion().getInicio())
                .getResultList();
    }

    public E save(E entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void update(UpdateDTO updateDTO) {
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaUpdate<E> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(getEntity());
        Root root = criteriaUpdate.from(getEntity());

        for (Map.Entry<String, String> entry : updateDTO.getParametros().entrySet()) {
            criteriaUpdate.set(entry.getKey(), entry.getValue());
        }
        criteriaUpdate.where(criteriaBuilder.equal(root.get(updateDTO.getIdCampo()), updateDTO.getIdValor()));

        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    public void bajaLogica(int value) {
        //Se forma el nombre del id de la Tabla
        String id = "id" + getEntity().getSimpleName();

        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaUpdate<E> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(getEntity());
        Root root = criteriaUpdate.from(getEntity());

        criteriaUpdate.set("esBajaLogica", true);

        criteriaUpdate.where(criteriaBuilder.equal(root.get(id), value));

        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    public void altaLogica(int value) {
        //Se forma el nombre del id de la Tabla
        String id = "id" + getEntity().getSimpleName();

        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaUpdate<E> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(getEntity());
        Root root = criteriaUpdate.from(getEntity());

        criteriaUpdate.set("esBajaLogica", false);

        criteriaUpdate.where(criteriaBuilder.equal(root.get(id), value));

        entityManager.createQuery(criteriaUpdate).executeUpdate();
    }

    public List getLike(ConsultaDTO consultaDTO) {
        //CREACIÓN DE OBJETOS PARA LA QUERY
        CriteriaBuilder criteriaBuilder = getCriteriaBuilder();
        CriteriaQuery criteriaQuery = getCriteriaQuery(criteriaBuilder);
        Root<E> root = getRoot(criteriaQuery);
        Predicate predicate = criteriaBuilder.conjunction();

        //FILTRO DE ORDEN
        if (consultaDTO.getOrden().getEsAscendente()) {
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(consultaDTO.getOrden().getCampo())));
        } else {
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(consultaDTO.getOrden().getCampo())));
        }

        //AGREGANDO PARAMETROS A LA QUERY PARA EL FILTRO
        for (Map.Entry<String, String> entry : consultaDTO.getParametros().entrySet()) {
            predicate.getExpressions()
                    .add(criteriaBuilder
                            .like(root.get(entry.getKey()).as(String.class),
                                    //Solo se trae lo objetos que empiecen con dicha letra
                                    entry.getValue()+"%"));
        }

        criteriaQuery.where(predicate);
        System.out.println(criteriaQuery);
        return entityManager.createQuery(criteriaQuery)
                .setMaxResults(consultaDTO.getPaginacion().getTamanio())
                .setFirstResult(consultaDTO.getPaginacion().getInicio())
                .getResultList();
    }

    private CriteriaBuilder getCriteriaBuilder(){
        return entityManager.getCriteriaBuilder();
    }

    private CriteriaQuery<E> getCriteriaQuery(CriteriaBuilder criteriaBuilder){
        return criteriaBuilder.createQuery(getEntity());
    }

    private Root<E> getRoot(CriteriaQuery<E> criteriaQuery){
        return criteriaQuery.from(getEntity());
    }

}
