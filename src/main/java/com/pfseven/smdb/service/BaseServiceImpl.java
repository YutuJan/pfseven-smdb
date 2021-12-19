package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.BaseModel;
import com.pfseven.smdb.repository.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T, Long> {

    abstract BaseRepository<T, Long> getRepository();

    @Override
    public T create(T clazz) {
        return getRepository().create(clazz);
    }

    @Override
    public List<T> createAll(List<T> clazzes) {
        List<T> createdEntities = new ArrayList<>();
        for (T clazz : clazzes) {
            createdEntities.add(create(clazz));
        }
        return createdEntities;
    }

    @Override
    public void update(T clazz) {
        getRepository().update(clazz);
    }

    @Override
    public void delete(T clazz) {
        getRepository().delete(clazz);
    }

    @Override
    public void deleteById(Long id) {
        getRepository().deleteById(id);
    }

    @Override
    public boolean exists(T clazz) {
        return getRepository().exists(clazz);
    }

    @Override
    public List<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public T find(Long id) {
        return getRepository().find(id);
    }

    @Override
    public T get(Long id) {
        return getRepository().get(id);
    }
}
