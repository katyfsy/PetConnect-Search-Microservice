package com.vmware.CapstoneSearch.Models;

public class Query {
    private Match multi_match;

    public Query() {
    }

    public Query(Match multi_match) {
        this.multi_match = multi_match;
    }

    public Match getMulti_match() {
        return multi_match;
    }

    public void setMulti_match(Match multi_match) {
        this.multi_match = multi_match;
    }

    @Override
    public String toString() {
        return "Query{" +
                "multi_match=" + multi_match +
                '}';
    }
}
