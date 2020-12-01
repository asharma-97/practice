package codes.java;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathInZigZagTree {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new LinkedList<>();
        int node_count = 1;
        int level = 1;
        while (label >= node_count * 2) {
            node_count *= 2;
            level++;
        }

        while (label != 0) {
            list.add(label);
            int levelmax = ((int) Math.pow(2, level)) - 1;
            int levelmin = (int) Math.pow(2, level - 1);
            label = (levelmax + levelmin - label) / 2;
            level--;

        }
        Collections.reverse(list);
        return list;
    }

}
