package graphs;

import java.util.HashSet;
import java.util.Set;

public class Rotten_Oranges_Problem {

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<>();
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                Dfs(i, isConnected, visited);
                provinces++;
            }
        }

        return provinces;
    }

    private void Dfs(int city, int[][] isConnected, Set<Integer> visited) {
        visited.add(city);

        for (int curr = 0; curr < isConnected[city].length; curr++) {
            if (isConnected[city][curr] == 1 && !visited.contains(curr)) {
                Dfs(curr, isConnected, visited);
            }
        }
    }

    public static void main(String[] args) {

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        Rotten_Oranges_Problem obj = new Rotten_Oranges_Problem();

        int provinces = obj.findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + provinces);
    }
}