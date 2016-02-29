package assignment4;

import com.sun.corba.se.impl.orbutil.graph.Graph;
import sun.security.provider.certpath.AdjacencyList;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class DepthFirstSearch {




    private boolean[] visited;
    private int count;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    int V = 0 ;

    public DepthFirstSearch(String startWord, String endWord, HashMap dictionary, List ladder){
        visited = new boolean[dictionary.size() * dictionary.size()];
        dfs(startWord,endWord, dictionary, ladder, 0);
    }



    //s is source vertex
    public DepthFirstSearch(AdjacencyMatrix graph, int s){
        visited = new boolean[graph.getNumVertices(graph)];
        dfs(graph, s);
    }

    private boolean dfs(String startWord, String endWord, HashMap dictionary, List ladder, int n){
        String checkword = startWord;
        if (checkword.equals(endWord)) {
            ladder.add(checkword);
            return true;

        }

        for (int j = n; j < 5; j++) {
            int p = (j + 1);
            for (int i = 0; i < alphabet.length(); i++) {
                checkword = startWord.substring(0, j) + alphabet.charAt(i) + startWord.substring(p, 5);
                if (dictionary.containsKey(checkword) && (!Objects.equals(checkword, startWord))) {
                    return dfs(checkword, endWord, dictionary, ladder, n + 1);
                }
            }
        }
        return false;
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
