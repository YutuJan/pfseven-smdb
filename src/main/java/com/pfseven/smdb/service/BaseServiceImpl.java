package com.pfseven.smdb.service;

import com.pfseven.smdb.domain.BaseModel;

import java.util.List;

public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T, Long> {

    @Override
    public T create(T clazz) {
        return null;
    }

    @Override
    public List<T> createAll(List<T> clazzes) {
        return null;
    }

    @Override
    public void update(T clazz) {

    }

    @Override
    public void delete(T clazz) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean exists(T clazz) {
        return false;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T find(Long id) {
        return null;
    }

    @Override
    public T get(Long id) {
        return null;
    }
}
