package com.example.minitest.repository;

import com.example.minitest.model.Class;
import com.example.minitest.model.Students;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface StudentsRepository extends PagingAndSortingRepository<Students,Long> {
    Page<Students> findAll(Pageable pageable);
    List<Students> findAllByName(String name);
    Page<Students> findAllByName(String name,Pageable pageable);
    Page<Students> findAllByClasses(Class classes, Pageable pageable);
    List<Students> findAllByOrderByPoint();
    List<Students> findAllByOrderByAge();
    List<Students> findAllByClasses_Id(Long id);

}
