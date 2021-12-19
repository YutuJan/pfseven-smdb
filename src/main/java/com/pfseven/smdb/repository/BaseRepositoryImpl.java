package com.pfseven.smdb.repository;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T, Long> {
    private final List<T> fakeDatabase = new ArrayList<>();

    @Override
    public T create(T clazz) {
        fakeDatabase.add(clazz);
        return null;
    }

    @Override
    public List<T> createAll(List<T> clazzes) {
        fakeDatabase.addAll(clazzes);
        return null;
    }

    @Override
    public void update(T clazz) {

    }

    @Override
    public void delete(T clazz) {

    }

    @Override
    public void deleteById(Long aLong) {

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
    public T get(Long aLong) {
        return null;
    }
}
