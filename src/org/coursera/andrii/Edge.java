package org.coursera.andrii;

/**
 * Created by andrii on 18.11.16.
 */
public class Edge {

    private String vStart, vEnd;
    private int dist;

    public Edge(String vStart, String vEnd, int dist) {
        this.vStart = vStart;
        this.vEnd = vEnd;
        this.dist = dist;
    }

    public String getvStart() {
        return vStart;
    }

    public String getvEnd() {
        return vEnd;
    }

    public int getDist() {
        return dist;
    }
}
