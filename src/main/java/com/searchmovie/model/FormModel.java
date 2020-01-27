package com.searchmovie.model;

import org.springframework.cache.annotation.Cacheable;

public class FormModel {
    private String ftype;
    private String fquery;

    public String getFtype() {

        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getFquery() {
        return fquery;
    }

    public void setFquery(String fquery) {
        this.fquery = fquery;
    }
}
