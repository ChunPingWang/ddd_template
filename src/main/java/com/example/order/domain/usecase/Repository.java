package com.example.order.domain.usecase;

import com.example.order.domain.model.AggregateRoot;

import java.util.List;

public interface Repository<T extends AggregateRoot> {
    List<T> findAll();
    T findById(String id);
    T findFirstByName(String name);
    T save(T arg);
    boolean remove(T arg);
}
