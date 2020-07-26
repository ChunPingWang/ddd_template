package com.example.order.domain.model;

import com.google.common.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;


public class DomainEventBus extends EventBus {

    public DomainEventBus(){
            super();
        }

    public void postAll(clean.kanban.domain.model.AggregateRoot aggregateRoot){
        List<clean.kanban.domain.model.DomainEvent> events =
                new ArrayList(aggregateRoot.getDomainEvents());
        aggregateRoot.clearDomainEvents();

        for(clean.kanban.domain.model.DomainEvent each : events){
            post(each);
        }
        events.clear();
    }
}
