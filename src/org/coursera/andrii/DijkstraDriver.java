package org.coursera.andrii;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by andrii on 19.11.16.
 */
public class DijkstraDriver {

    public static void main(String[] args) {

        Graph g = new Graph(initFromFile("DijkstraData.txt"));
        g.dijkstra("1");

        g.printDistance("7");
        System.out.print(",");

        g.printDistance("37");
        System.out.print(",");

        g.printDistance("59");
        System.out.print(",");

        g.printDistance("82");
        System.out.print(",");

        g.printDistance("99");
        System.out.print(",");

        g.printDistance("115");
        System.out.print(",");

        g.printDistance("133");
        System.out.print(",");

        g.printDistance("165");
        System.out.print(",");

        g.printDistance("188");
        System.out.print(",");

        g.printDistance("197");


        //7,37,59,82,99,115,133,165,188,197

    }

    //Read edges from text file
    public static ArrayList<Edge> initFromFile(String inputFile){

        ArrayList<Edge> edgesList = new ArrayList<>();

        try {
            File file = new File(inputFile);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String tokens[], adj[];
            String vStart;

            while ((line = bufferedReader.readLine()) != null) {

                tokens = line.split("\t");
                if(tokens.length > 1){
                    vStart = tokens[0];
                    for(int i = 1; i<tokens.length; i++){
                        adj = tokens[i].split(",");
                        if(adj.length == 2)
                            edgesList.add(new Edge(vStart,adj[0],Integer.parseInt(adj[1])));
                    }
                }

            }

            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return edgesList;
    }
}
