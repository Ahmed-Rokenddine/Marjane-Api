package service;

import Entity.AdminEntity;

import java.util.List;

public interface AbstractService<T> {
    int save(T entity);

    T get(int id);

    List<T> list();

    void update(int id, T entity);

    void delete(int id);
}
