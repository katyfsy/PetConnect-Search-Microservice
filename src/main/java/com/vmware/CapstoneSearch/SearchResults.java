package com.vmware.CapstoneSearch;

import com.vmware.CapstoneSearch.Models.HitStatus;
import com.vmware.CapstoneSearch.Models.Shards;

public class SearchResults {
    private String took;
    private boolean timed_out;
    private Shards _shards;
    private HitStatus hits;

    public SearchResults(String took, boolean timed_out, Shards _shards, HitStatus hits) {
        this.took = took;
        this.timed_out = timed_out;
        this._shards = _shards;
        this.hits = hits;
    }

    public SearchResults() {
    }

    public String getTook() {
        return took;
    }

    public void setTook(String took) {
        this.took = took;
    }

    public boolean isTimed_out() {
        return timed_out;
    }

    public void setTimed_out(boolean timed_out) {
        this.timed_out = timed_out;
    }

    public Shards get_shards() {
        return _shards;
    }

    public void set_shards(Shards _shards) {
        this._shards = _shards;
    }

    public HitStatus getHits() {
        return hits;
    }

    public void setHits(HitStatus hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "SearchResults{" +
                "took='" + took + '\'' +
                ", timed_out=" + timed_out +
                ", _shards=" + _shards +
                ", hits=" + hits +
                '}';
    }
}
