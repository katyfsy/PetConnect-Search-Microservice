package com.vmware.CapstoneSearch.Models;

public class Body {
    private Query query;

    public Body() {
    }

    public Body(Query query) {
        this.query = query;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Body{" +
                "query=" + query +
                '}';
    }
}
