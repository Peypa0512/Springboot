package com.psr.models;

import jakarta.persistence.*
        ;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;


    public Category() {
        super();
    }

    public Category(String name) {
        super();
        this.name = name;
        Date now = new Date();
        this.lastUpdate = new Timestamp(now.getTime());
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Category [categoryId=" + categoryId + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
    }

}