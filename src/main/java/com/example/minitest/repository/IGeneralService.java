package com.example.minitest.repository;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();
    T findByID(Long id);
    void save(T t);
    void  remove(Long id);
}
