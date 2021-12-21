package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T, Long> {

    abstract JpaRepository<T, Long> getRepository();

    @Override
    public T create(T entity) {
        return getRepository().save(entity);
    }

    @Override
    public List<T> createAll(T... entities) {
        return createAll(Arrays.asList(entities));
    }

    public List<T> createAll(List<T> entities) {
        return getRepository().saveAll(entities);
    }

    @Override
    public void update(T entity) {
        getRepository().save(entity);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(T entity) {
        return getRepository().existsById(entity.getId());
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T find(Long id) {
        return getRepository().findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public T get(Long id) {
        return getRepository().getById(id);
    }
}
