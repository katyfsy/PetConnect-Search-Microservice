package com.vmware.CapstoneSearch;

public class Shards {
    private int total;
    private int successful;
    private int skipped;
    private int failed;

    public Shards(int total, int successful, int skipped, int failed) {
        this.total = total;
        this.successful = successful;
        this.skipped = skipped;
        this.failed = failed;
    }

    public Shards() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuccessful() {
        return successful;
    }

    public void setSuccessful(int successful) {
        this.successful = successful;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }
}
