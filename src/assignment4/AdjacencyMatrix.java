package assignment4;


import sun.security.provider.certpath.AdjacencyList;

import java.util.HashMap;

public class AdjacencyMatrix {

    int index;
    boolean[][] array;

    AdjacencyMatrix(int first) {
        index = first;
        array = new boolean[index][index];
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
