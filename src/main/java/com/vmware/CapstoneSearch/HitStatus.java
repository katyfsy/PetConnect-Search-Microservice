package com.vmware.CapstoneSearch;

import java.util.List;

public class HitStatus {
    private Total total;
    private float max_score;
    private List<Hit> hits;

    public HitStatus(Total total, float max_score, List<Hit> hits) {
        this.total = total;
        this.max_score = max_score;
        this.hits = hits;
    }

    public HitStatus() {
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public float getMax_score() {
        return max_score;
    }

    public void setMax_score(float max_score) {
        this.max_score = max_score;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

    @Override
    public String toString() {
        return "HitStatus{" +
                "total=" + total +
                ", max_score=" + max_score +
                ", hits=" + hits +
                '}';
    }
}
