package com.example.minitest.service;

import com.example.minitest.model.Class;
import com.example.minitest.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassService implements IClassService{
    @Autowired
    private ClassRepository classRepository;
    @Override
    public List<Class> findAll() {
        return (List<Class>) classRepository.findAll();
    }

    @Override
    public Class findByID(Long id) {
        return classRepository.findById(id).get();
    }

    @Override
    public void save(Class aClass) {
        classRepository.save(aClass);

    }

    @Override
    public void remove(Long id) {
       Class classes = classRepository.findById(id).get();
       if(classes != null){
           classRepository.delete(classes);
       }
    }

}
