package org.acme.repository;

import org.acme.dto.consulta.ConsultaDTO;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Map;

public abstract class Repository<E> {

    @Inject
    EntityManager em;

    public List get(Class<E> entity, ConsultaDTO consultaDTO){
        //CREACIÓN DE OBJETOS PARA LA QUERY
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entity);
        Root<E> root = criteriaQuery.from(entity);
        Predicate predicate = criteriaBuilder.conjunction();

        //FILTRO DE ORDEN
        if(consultaDTO.getOrden().getEsAscendente()){
            criteriaQuery.orderBy(criteriaBuilder.asc(root.get(consultaDTO.getOrden().getCampo())));
        }else{
            criteriaQuery.orderBy(criteriaBuilder.desc(root.get(consultaDTO.getOrden().getCampo())));
        }

        //AGREGANDO PARAMETROS A LA QUERY PARA EL FILTRO
        for (Map.Entry<String, String> entry : consultaDTO.getParametros().entrySet()){
            predicate.getExpressions()
                    .add(criteriaBuilder
                            .equal(root.get(entry.getKey()).as(String.class),
                                    entry.getValue()));
        }

        //FILTRO POR RANGO
        if(consultaDTO.getRango() != null){
            predicate.getExpressions()
                    .add(criteriaBuilder.
                            between(root.get(consultaDTO.getRango().getCampo()).as(String.class),
                                    consultaDTO.getRango().getInicio(), consultaDTO.getRango().getFin()));
        }

        criteriaQuery.where(predicate);
        return em.createQuery(criteriaQuery)
                .setMaxResults(consultaDTO.getPaginacion().getTamanio())
                .setFirstResult(consultaDTO.getPaginacion().getInicio())
                .getResultList();
    }

    public E save(E entity){
        em.persist(entity);
        return entity;
    }

    public E update(E entity){
        em.merge(entity);
        return entity;
    }

}
