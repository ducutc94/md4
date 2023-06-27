package com.example.minitest.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "integer default 0")
    private Integer quantity ;
    @OneToMany(mappedBy = "classes" ,fetch = FetchType.LAZY)
    private List<Students> studentsList = new ArrayList<Students>();

    public Class() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
