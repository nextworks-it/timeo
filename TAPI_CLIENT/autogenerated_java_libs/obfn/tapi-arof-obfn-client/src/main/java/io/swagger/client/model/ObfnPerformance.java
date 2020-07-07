package io.swagger.client.model;

import java.util.List;

public class ObfnPerformance {
    private int ber;

    private List<Integer> snr;

    public ObfnPerformance() {
    }

    public ObfnPerformance(int ber, List<Integer> snr) {
        this.ber = ber;
        this.snr = snr;
    }

    public int getBer() {
        return ber;
    }

    public List<Integer> getSnr() {
        return snr;
    }
}
