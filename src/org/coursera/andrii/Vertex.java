package org.coursera.andrii;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andrii on 18.11.16.
 */
public class Vertex implements Comparable<Vertex>{

    public final String name;
    public int dist = Integer.MAX_VALUE; // MAX_VALUE assumed to be infinity
    public Vertex previous = null;
    public final Map<Vertex, Integer> neighbours = new HashMap<>();

    public Vertex(String name) {
        this.name = name;
    }

    public void printPath() {

        if (this == this.previous){
            System.out.printf("%s", this.name);
        }
        else if (this.previous == null){
            System.out.printf("%s(unreached)", this.name);
        }
        else {
            this.previous.printPath();
            System.out.printf(" -> %s(%d)", this.name, this.dist);
        }

    }

    public void printDistance(){
        System.out.print(this.dist);
    }

    public int compareTo(Vertex other){
        if (dist == other.dist)
            return name.compareTo(other.name);

        return Integer.compare(dist, other.dist);
    }

    @Override public String toString() {
        return "(" + name + ", " + dist + ")";
    }
}
