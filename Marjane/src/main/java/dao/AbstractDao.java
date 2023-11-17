package dao;

import Entity.AdminEntity;
import org.hibernate.Session;

import java.util.List;


public interface AbstractDao <T> {

    int save(T entity);

    T get(int id);

    List<T> list();

    void update(int id, T entity);

    void delete(int id);


}