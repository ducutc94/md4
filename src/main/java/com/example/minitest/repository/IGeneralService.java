package com.example.minitest.repository;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findByID(Long id);
    void save(T t);
    void saveClass(T t);
    int checkClass(T t);
    void  remove(Long id);
    void update(T t);
}
