package graphs;

import java.util.ArrayList;

public class DFS {
    public static void dfs(int node, boolean[]vis, ArrayList<ArrayList<Integer>>adj,ArrayList<Integer>ls){
        vis[node]=true;
        ls.add(node);
        for(Integer it:adj.get(node)){
            if(!vis[it]){
                dfs(it,vis,adj,ls);
            }
        }
    }
    public static ArrayList<Integer>dfsOfGraph(int V,ArrayList<ArrayList<Integer>>adj){
        boolean[] vis=new boolean[V];
        ArrayList<Integer>ls=new ArrayList<>();
        dfs(0,vis,adj,ls);
        return ls;
    }

    static void main(String[] args) {
        int V=5;
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(2).add(4);
        adj.get(4).add(2);
        ArrayList<Integer>result=dfsOfGraph(V,adj);
        System.out.println("DFS Traversal:");
        for(int node:result){
            System.out.println(node+" ");
        }
    }

}
