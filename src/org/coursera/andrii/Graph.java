package org.coursera.andrii;

import java.util.*;

/**
 * Created by andrii on 18.11.16.
 */
public class Graph {

    private final Map<String, Vertex> graph;

    /** Builds a graph from a set of edges */
    public Graph(ArrayList<Edge> edges) {

        graph = new HashMap<>(edges.size());

        //one pass to find all vertices
        for (Edge e : edges) {
            if (!graph.containsKey(e.getvStart())) graph.put(e.getvStart(), new Vertex(e.getvStart()));
            if (!graph.containsKey(e.getvEnd())) graph.put(e.getvEnd(), new Vertex(e.getvEnd()));
        }

        //another pass to set neighbouring vertices
        for (Edge e : edges) {
            graph.get(e.getvStart()).neighbours.put(graph.get(e.getvEnd()), e.getDist());
            //graph.get(e.v2).neighbours.put(graph.get(e.v1), e.dist); // also do this for an undirected graph
        }
    }

    /** Runs dijkstra using a specified source vertex */
    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        // set-up vertices
        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    /** Implementation of dijkstra's algorithm using a binary heap. */
    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {

            u = q.pollFirst(); // vertex with shortest distance (first iteration will return source)
            if (u.dist == Integer.MAX_VALUE) break; // we can ignore u (and any other remaining vertices) since they are unreachable

            //look at distances to each neighbour
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //the neighbour in this iteration

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    /** Prints a path from the source to the specified vertex */
    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }

    /** Prints a path from the source to the specified vertex */
    public void printDistance(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printDistance();
    }
}
