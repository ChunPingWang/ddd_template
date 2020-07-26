package com.example.order.domain.model;

import clean.kanban.domain.model.common.DateProvider;

import java.util.Date;
import java.util.UUID;

public class AbstractDomainEvent implements clean.kanban.domain.model.DomainEvent {

    private final Date occurredOn;
    private final String sourceId;
    private final String sourceName;
    private final String id;

    private clean.kanban.domain.model.Entity entity;

    private static final long serialVersionUID = 1L;

    public AbstractDomainEvent(String sourceId, String sourceName) {
        super();
        this.id = UUID.randomUUID().toString();
        this.sourceId = sourceId;
        this.occurredOn = DateProvider.now();
        this.sourceName = sourceName;
    }

    public AbstractDomainEvent(clean.kanban.domain.model.Entity entity) {
        super();
        this.entity = entity;
        this.id = UUID.randomUUID().toString();
        this.occurredOn = DateProvider.now();

        sourceId = null;
        sourceName = null;
    }

    public clean.kanban.domain.model.Entity getEntity(){
        return entity;
    }


//        this.occurredOn = new Date();

    @Override
    public int eventVersion() {
        return EventVersion.NUMBER;
    }

    @Override
    public Date occurredOn() {
        return occurredOn;
    }

    @Override
    public String detail() {
        String formatDate = String.format("occurredOn='%1$tY-%1$tm-%1$td %1$tH:%1$tM']", occurredOn());
        String format = String.format(
                "%s[Name='%s', id='%s'] ",
                this.getClass().getSimpleName(),
                this.getSourceName(), this.getSourceId());
        return format + formatDate;
    }

    @Override
    public String getSourceId() {
        return sourceId;
    }

    @Override
    public String getSourceName() {
        return sourceName;
    }

    public String getId() {
        return id;
    }
}
