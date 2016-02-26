package assignment4;


import sun.security.provider.certpath.AdjacencyList;

public class AdjacencyMatrix {

    int index; //fixme should be zero??
    boolean[][] array;

    AdjacencyMatrix(int first) {
        index = first;
        array = new boolean[index][index];
    }


    /*todo method headers*/
    void addEdge(int i, int j) {
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
