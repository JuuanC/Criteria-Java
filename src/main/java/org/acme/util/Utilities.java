package org.acme.util;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import java.util.Set;

public class Utilities<T> {

    @Inject
    EntityManager em;

    public static <T> String getMensajeError(Set<ConstraintViolation<T>> violations) {
        return violations.stream().findFirst().get().getMessage();
    }
}
