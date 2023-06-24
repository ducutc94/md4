package com.example.minitest.repository;

import com.example.minitest.model.Class;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassRepository extends PagingAndSortingRepository<Class,Long> {

}
