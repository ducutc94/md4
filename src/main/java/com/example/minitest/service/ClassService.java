package com.example.minitest.service;

import com.example.minitest.model.Class;
import com.example.minitest.model.Students;
import com.example.minitest.repository.ClassRepository;
import com.example.minitest.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassService implements IClassService{
    @Autowired
    private ClassRepository classRepository;
    @Autowired
    private StudentsRepository studentsRepository;
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
        aClass.setQuantity(0);
        classRepository.save(aClass);

    }

    @Override
    public void saveClass(Class aClass) {
        classRepository.save(aClass);
    }

    @Override
    public int checkClass(Class aClass) {
        List<Class> classList =(List<Class>) classRepository.findAll();
        for (Class c:classList) {
            if(c.getName().equals(aClass.getName())){
                return -1;
            }
        }return 1;
    }

    @Override
    public void remove(Long id) {
      List<Students> studentsList = studentsRepository.findAllByClasses_Id(id);
       Class classes = classRepository.findById(id).get();
       if(classes != null){
              studentsRepository.deleteAll(studentsList);
           }
           classRepository.delete(classes);
       }

    @Override
    public void update(Class aClass) {
        classRepository.save(aClass);
    }

}
