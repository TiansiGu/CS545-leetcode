import java.util.*;

/**
 * https://leetcode.com/problems/evaluate-division/description/
 */
public class LC399 {
    class Pair {
        String dest; //destination
        double val;  //the value of start -> destination
        Pair(String dest, double val) {this.dest = dest; this.val = val;}
    }

    /**
     * Graph - DFS
     * There are N pairs in equations, M queries
     * Time: O(M*N)
     * Space: O(N)
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create Graph
        Map<String, List<Pair>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String start = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double val = values[i];
            graph.putIfAbsent(start, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(start).add(new Pair(dest, val));
            graph.get(dest).add(new Pair(start, 1/val));
        }

        double[] result = new double[queries.size()];
        int idx = 0;
        Set<String> visited = new HashSet<>();

        // For each query, find a path from C to D and get the product
        for (List<String> query : queries) {
            visited.clear();
            String start = query.get(0),  goal = query.get(1);
            if (!graph.containsKey(start) || !graph.containsKey(goal)) {
                result[idx] = (double) (-1);
                idx++;
                continue;
            }
            if (start.equals(goal)) {
                result[idx] = (double) (1);
                idx++;
                continue;
            }
            visited.add(start);
            result[idx] = dfs(graph, visited, start, goal, 1);
            idx++;
        }
        return result;
    }

    private double dfs(Map<String, List<Pair>> graph, Set<String> visited,
                       String start, String goal, double product) {
        if (start.equals(goal)) return product;
        List<Pair> list = graph.get(start);
        for (Pair pair : list) {
            String next = pair.dest;
            if (visited.contains(next)) continue;
            visited.add(next);
            // recursively call dfs func until find the goal or no other nodes can be reached
            double p = dfs(graph, visited, next, goal, product*pair.val);
            if (p != -1) return p;
        }
        return (double) (-1);
    }
}
