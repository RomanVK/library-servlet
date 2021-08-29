package ua.lib.model.dao;

import java.util.List;

public interface GenericDao<T> extends AutoCloseable{
    void create (T entity);
    T findById(String email);
    List<T> findAll();
    void update(T entity);
    void delete(int id);
    void close();
}
