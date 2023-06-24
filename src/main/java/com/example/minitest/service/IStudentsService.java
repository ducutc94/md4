package com.example.minitest.service;

import com.example.minitest.model.Class;
import com.example.minitest.model.Students;
import com.example.minitest.repository.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IStudentsService extends IGeneralService<Students> {
    Page<Students> findAll(Pageable pageable);
    List<Students> search(String name);
    Page<Students> searchPage(String name,Pageable pageable);
    Page<Students> searchClass(Class classes, Pageable pageable);
    List<Students> sort();
    List<Students> sortByAge();
    List<Students> sortByClass(Long id);

}
