package assignment4;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import sun.security.provider.certpath.AdjacencyList;

public class DepthFirstSearch {




    private boolean[] visited;
    private int count;

    int V = 0 ;


    //s is source vertex
    public DepthFirstSearch(AdjacencyMatrix graph, int s){
        visited = new boolean[graph.getNumVertices(graph)];
        dfs(graph, s);
    }

    private void dfs(AdjacencyMatrix graph, int v){
        count++;
        visited[v] = true;
        //todo print the node
        for(int j = 0; j < graph.getNumVertices(graph); j++){
            dfs(graph, j);
        }

    }

}
