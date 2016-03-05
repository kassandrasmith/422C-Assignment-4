/*
    Adjacency Matrix Class for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */
package assignment4;

import java.util.*;

public class AdjacencyMatrix {

    private final int numVertices;
    private boolean[] visited;
    private int[] distTo;
    private boolean[][] adjMatrix;
    private int[] parents;

    private final int numberOfNodes;//number of words in the dictionary

    AdjacencyMatrix(Set<String> dictionary) {
        numVertices = dictionary.size();
        numberOfNodes = dictionary.size();
        adjMatrix = createEdges(dictionary);
        visited = new boolean[numberOfNodes];

    }

    private boolean[][] createEdges(Set<String> dictionary) {
        int row = 0;
        int column = 0;
        adjMatrix = new boolean[numVertices][numVertices];
        for (String rowWord : dictionary) {
            for (String columnWord : dictionary) {
                adjMatrix[row][column] = isOneAway(rowWord, columnWord);
                column++;
            }
            column = 0;
            row++;
        }
        return adjMatrix;
    }

    private boolean isOneAway(String first, String second) {
        int counter = 0;
        for (int j = 0; j < 5; j++) {
            if (first.charAt(j) == second.charAt(j)) {
                counter++;
            }
        }
        return counter == 4;
    }

    public List<Integer> bfs(int startWordIndex, int endWordIndex) {
        List<Integer> ladder = new LinkedList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean[] adjList;
        parents = new int[numberOfNodes];
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

        return ladder;
    }

    private boolean[] adjacencyListForIndex(int x) {
        return adjMatrix[x];
    }


    int getUnvisitedChildNode(int n) {
        int j;
        for (j = 0; j < numberOfNodes; j++) {
            if (adjMatrix[n][j]) {
                if (!visited[j])
                    return (j);
            }
        }
        return (-1);
    }

    void clearVisited() {
        int i;
        for (i = 0; i < visited.length; i++)
            visited[i] = false;
    }

//public List<Integer>dfs(int startWordIndex,int endWordIndex){
//
//        boolean[]adjacencyList=adjMatrix[startWordIndex];
//        visited[startWordIndex]=true;
//
//        if(startWordIndex==endWordIndex){
//        List<Integer>ladder=new LinkedList<>();
//        visited=new boolean[numberOfNodes];
//        return ladder;
//        }
//        for(int i=0;i<adjacencyList.length;i++){
//        if(adjacencyList[i]&&!visited[i]){
//        List<Integer>ladder=dfs(i,endWordIndex);
//        if(ladder!=null){
//        ladder.add(i);
//        return ladder;
//        }
//}
//}
//        return null;
//        }

    int getNumVertices() {
        return adjMatrix.length;
    }

    /*todo method headers*/
    void setEdge(int i, int j) {
        adjMatrix[i][j] = true;
    }

    public int getVertices() {
        return numVertices;
    }

    /**/
    void removeEdge(int i, int j) {
        adjMatrix[i][j] = false;
    }

    /**/
    boolean hasEdge(int i, int j) {
        return adjMatrix[i][j];
    }


}
