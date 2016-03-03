package assignment4;


import sun.security.provider.certpath.AdjacencyList;

import java.util.*;

public class AdjacencyMatrix {

    int index; //fixme public? private?
    private int numVertices;
    private int edges;
    private boolean[][] array;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int numberOfNodes = 5757;//number of words in the dictionary

    AdjacencyMatrix(Set<String> dictionary) {
        numVertices = dictionary.size();
        array = createEdges(dictionary);
    }

    private boolean[][] createEdges(Set<String> dictionary) {
        int row = 0;
        int column = 0;
        array = new boolean[numVertices][numVertices];
        for (String rowWord : dictionary) {
            for (String columnWord : dictionary) {
                array[row][column] = isOneAway(rowWord, columnWord);
                column++;
            }
            column = 0;
            row++;
        }
        return array;
    }

    /*todo method headers*/
    void setEdge(int i, int j) {
        array[i][j] = true;
    }

    public int getEdges() {
        return edges;
    }

    public int getVertices() {
        return numVertices;
    }

    /**/
    void removeEdge(int i, int j) {
        array[i][j] = false;
    }

    /**/
    boolean hasEdge(int i, int j) {
        return array[i][j];
    }

    int getNumVertices(AdjacencyMatrix adjmat) {
        return array.length;
    }

    public boolean isOneAway(String first, String second) {
        int counter = 0;
        for (int j = 0; j < 5; j++) {
            if (first.charAt(j) == second.charAt(j)) {
                counter++;
            }
        }
        return counter == 4;
    }


}
