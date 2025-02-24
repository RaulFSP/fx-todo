package com.portfolio.fxtodo.entities;

import java.time.LocalDate;

public class TODO {
    private Long id;
    private LocalDate localDate;
    private String content;
    private Boolean accomplished;

    public TODO(LocalDate localDate, String content, Boolean accomplished) {
        this.localDate = localDate;
        this.content = content;
        this.accomplished = accomplished;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getAccomplished() {
        return accomplished;
    }

    public void setAccomplished(Boolean accomplished) {
        this.accomplished = accomplished;
    }

    @Override
    public String toString() {
        return localDate+" | "+content;
    }
}
