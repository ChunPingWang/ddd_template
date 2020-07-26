package com.example.order.domain.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AggregateRoot extends clean.kanban.domain.model.Entity {

    private static final long serialVersionUID = 1L;
    private final List<clean.kanban.domain.model.DomainEvent> domainEvents;

    public AggregateRoot(String name) {
        super(name);
        domainEvents = new CopyOnWriteArrayList<>();
    }
    public void addDomainEvent(clean.kanban.domain.model.DomainEvent event){
        domainEvents.add(event);
    }
    public List<clean.kanban.domain.model.DomainEvent> getDomainEvents(){
        return Collections.unmodifiableList(domainEvents);
    }
    public void clearDomainEvents(){
        domainEvents.clear();
    }
}


