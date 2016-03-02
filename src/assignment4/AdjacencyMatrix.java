package assignment4;


import sun.security.provider.certpath.AdjacencyList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;

public class AdjacencyMatrix {

    int index; //fixme public? private?
    private int vertices;
    private int edges;
    private boolean[][] array;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int numberOfNodes = 5757;//number of words in the dictionary

    AdjacencyMatrix(int Vertices) {
        vertices = Vertices;
        edges = 0;
        array = new boolean[vertices][vertices];
    }



    AdjacencyMatrix(HashMap dictionary, String start, String end){
        vertices = dictionary.size();
        array = new boolean[vertices][vertices];

        array = createEdges(dictionary, start, end, 0);


    }

    private boolean[][] createEdges(HashMap dictionary, String startWord, String endWord, int n) {
        String checkword = startWord;
        Iterator it = dictionary.entrySet().iterator();
        while (it.hasNext()){
            
        }
        int k = 0;
        for (int j = n; j < 5; j++) {
            int p = (j + 1);
            for (int i = 0; i < alphabet.length(); i++) {
                checkword = startWord.substring(0, j) + alphabet.charAt(i) + startWord.substring(p, 5);
                if (dictionary.containsKey(checkword) && (!Objects.equals(checkword, startWord))) {
                array[k][i] = true; //todo hash code correct?
                }
                else array[k][i] = false;
            }
        }
return array;
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
