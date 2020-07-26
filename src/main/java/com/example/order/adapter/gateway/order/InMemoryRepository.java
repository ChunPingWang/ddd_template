package com.example.order.adapter.gateway.order;

import com.example.order.domain.model.AggregateRoot;
import com.example.order.domain.usecase.Repository;

import java.util.List;

public class InMemoryRepository<T extends AggregateRoot> implements Repository<T> {
    public List<T> findAll() {
        return null;
    }

    public T findById(String id) {
        return null;
    }

    public T findFirstByName(String name) {
        return null;
    }

    public T save(T arg) {
        return null;
    }

    public boolean remove(T arg) {
        return false;
    }
}
