package com.vmware.CapstoneSearch;

import java.util.List;

public class Match {
    private String query;
    private List<String> fields;

    public Match() {
    }

    public Match(String query, List<String> fields) {
        this.query = query;
        this.fields = fields;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    @Override
    public String toString() {
        return "Match{" +
                "query='" + query + '\'' +
                ", fields=" + fields +
                '}';
    }
}
