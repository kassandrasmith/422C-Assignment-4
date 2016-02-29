package assignment4;


import sun.security.provider.certpath.AdjacencyList;

import java.util.HashMap;

public class AdjacencyMatrix {

    int index; //fixme public? private?
    private int vertices;
    private int edges;
    private boolean[][] array;
    private int numberOfNodes = 5757;//number of words in the dictionary

    AdjacencyMatrix(int Vertices) {
        vertices = Vertices;
        edges = 0;
        array = new boolean[vertices][vertices];
    }



    AdjacencyMatrix(HashMap dictionary, String start, String end){

    }

    public class Node {
        private Node[] adjacentNodes;
        public Node(Node[] nodes) { adjacentNodes = nodes; }
        public Node[] adjacentNodes() { return adjacentNodes; }
    }


    /*todo method headers*/
    void setEdge(int i, int j) {
        array[i][j] = true;
    }

    public int getEdges(){
        return edges;
    }

    public int getVertices(){
        return vertices;
    }

    /**/
    void removeEdge(int i, int j) {
        array[i][j] = false;
    }

    /**/
    boolean hasEdge(int i, int j) {
        return array[i][j];
    }

    int getNumVertices(AdjacencyMatrix adjmat){
        return array.length;
    }


}
