/*
    Adjacency Matrix Class for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */
package assignment4;

import java.util.*;

public class AdjacencyMatrix {

    private final int numberOfNodes;    //number of words in the dictionary
    private boolean[][] adjMatrix;      //the matrix holding every word's adjacency to every word
    private boolean[] visited;          //array for which nodes were visited

    /*
    METHOD:     Adjacency Matrix Constructor
    PURPOSE:    constructor for the Adjacency Matrix
    PARAMS:     @param dictionary
    RETURNS:    NONE but it does construct an Adjacency Matrix
    */
    AdjacencyMatrix(Set<String> dictionary) {
        numberOfNodes = dictionary.size();
        adjMatrix = createEdges(dictionary);
        visited = new boolean[numberOfNodes];
    }

    /*
    METHOD:     createEdges
    PURPOSE:    creates the graph using adjacencies
    PARAMS:     @param dictionary Set
    RETURNS:    boolean matrix of adjacencies
    */
    private boolean[][] createEdges(Set<String> dictionary) {
        int row = 0;
        int column = 0;
        adjMatrix = new boolean[numberOfNodes][numberOfNodes];
        for (String rowWord : dictionary) {
            for (String columnWord : dictionary) {
                adjMatrix[row][column] = isOneAway(rowWord, columnWord);
                column++;
            }
            column = 0; //reset to start at beginning of next row
            row++;
        }
        return adjMatrix;
    }

    /*
    METHOD:     isOneAway
    PURPOSE:    tells whether or not two strings differ by one letter
    PARAMS:     @param String first
                @param String second to be tested against
    RETURNS:    whether or not they are one letter apart
    */
    private boolean isOneAway(String first, String second) {
        int counter = 0;
        for (int j = 0; j < 5; j++) {
            if (first.charAt(j) == second.charAt(j)) {
                counter++;
            }
        }
        return counter == 4;
    }

    /*
    METHOD:     bfs (breadth first search)
    PURPOSE:    finds a path (ladder) between our starting word and ending word
    PARAMS:     @param String starting string
                @param String ending string
    RETURNS:    the path from one to the other in a List
    */
    public List<Integer> bfs(int startWordIndex, int endWordIndex) {
        List<Integer> ladder = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] adjList;
        int[] parents = new int[numberOfNodes];
        Arrays.fill(parents, -1);
        q.add(startWordIndex);
        visited[startWordIndex] = true;
        while (!q.isEmpty()) {
            int current = q.remove();

            int k = 0;
            adjList = adjacencyListForIndex(current);
            for (boolean adjacent : adjList
                    ) {
                if (!visited[k] && adjacent) {
                    q.add(k);
                    visited[k] = true;
                    parents[k] = current;
                }
                k++;
            }

        }
        int g = endWordIndex;
        ladder.add(g);
        while (parents[g] != -1) {
            ladder.add(parents[g]);
            g = parents[g];
        }
        q.clear();
        Arrays.fill(visited, false);
        return ladder;
    }

    /*
    METHOD:     adjacencyListForIndex
    PURPOSE:    gets the adjacency matrix (a one column matrix is a list) for a word
    PARAMS:     @param integer index for which word to return the adjacency list for
    RETURNS:    the adjacency list
    */
    private boolean[] adjacencyListForIndex(int index) {
        return adjMatrix[index];
    }

    /* THIS METHOD IS NEVER CALLED BUT WAS AN EARLIER ATTEMPT AT A SOLUTION.*/
    public List<Integer> dfs(int startWordIndex, int endWordIndex) {

        boolean[] adjacencyList = adjMatrix[startWordIndex];
        visited[startWordIndex] = true;

        if (startWordIndex == endWordIndex) {
            List<Integer> ladder = new LinkedList<>();
            visited = new boolean[numberOfNodes];
            return ladder;
        }
        for (int i = 0; i < adjacencyList.length; i++) {
            if (adjacencyList[i] && !visited[i]) {
                List<Integer> ladder = dfs(i, endWordIndex);
                if (ladder != null) {
                    ladder.add(i);
                    return ladder;
                }
            }
        }
        return null;
    }

    /*GETTERS*/
    int getNumVertices() {
        return adjMatrix.length;
    }

    public int getVertices() {
        return numberOfNodes;
    }

    /*SETTERS*/
    void setEdge(int i, int j) {
        adjMatrix[i][j] = true;
    }
}
