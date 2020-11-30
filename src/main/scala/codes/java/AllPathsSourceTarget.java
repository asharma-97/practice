package codes.java;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSourceTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        helper(graph, 0, l, ll);
        return ll;
    }

    public void helper(int[][] graph, int current, List<Integer> l, List<List<Integer>> ll) {
        l.add(current);
        if (current == graph.length - 1) {
            ll.add(l);
            return;
        }
        for (int i = 0; i < graph[current].length; i++) {
            List<Integer> temp = new ArrayList <>(l);
            helper(graph, graph[current][i], temp, ll);
        }
    }
}
