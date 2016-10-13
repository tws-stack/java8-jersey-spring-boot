package com.thoughtworks.gaia.common.jpa;

import com.exmertec.yaz.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseDaoWrapper<T> extends BaseDao<T> {
    protected BaseDaoWrapper(Class<T> prototype) {
        super(prototype);
    }

    @PersistenceContext
    public void injectEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }
}
