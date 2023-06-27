package com.example.minitest.service;
import com.example.minitest.model.Class;
import com.example.minitest.model.Students;
import com.example.minitest.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class StudentsService implements IStudentsService{
    @Autowired
    private StudentsRepository studentsRepository;
    @Override
    public List<Students> findAll() {
        return (List<Students>) studentsRepository.findAll();
    }

    @Override
    public Students findByID(Long id) {
        return studentsRepository.findById(id).get();
    }

    @Override
    public void save(Students students) {
        studentsRepository.save(students);

    }

    @Override
    public void saveClass(Students students) {

    }

    @Override
    public int checkClass(Students students) {
        return 0;
    }

    @Override
    public void remove(Long id) {
        Students students = studentsRepository.findById(id).get();
        if(students != null){
            studentsRepository.delete(students);
        }
    }

    @Override
    public void update(Students students) {

    }

    @Override
    public List<Students> search(String name) {
        return (List<Students>) studentsRepository.findAllByName(name);
    }

    @Override
    public Page<Students> searchPage(String name, Pageable pageable) {
        return studentsRepository.findAllByName(name,pageable);
    }

    @Override
    public Page<Students> searchClass(Class classes, Pageable pageable) {
        return studentsRepository.findAllByClasses(classes,pageable);
    }

    @Override
    public List<Students> sort() {
        return studentsRepository.findAllByOrderByPoint();
    }

    @Override
    public Page<Students> sort( Pageable pageable) {
        return studentsRepository.findAllByOrderByPoint(pageable);
    }

    @Override
    public List<Students> sortByAge() {
        return studentsRepository.findAllByOrderByAge();
    }

    @Override
    public Page<Students> sortByAge( Pageable pageable) {
        return studentsRepository.findAllByOrderByAge(pageable);
    }

    @Override
    public List<Students> sortByClass(Long id) {
        return studentsRepository.findAllByClasses_Id(id);
    }

    @Override
    public Page<Students> findAll(Pageable pageable) {
        return studentsRepository.findAll(pageable);
    }


}
