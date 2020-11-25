package codes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        partitionLabels("ababcbacadefegdehijhklij");
    }
    public static List<Integer> partitionLabels(String s) {
        // Use int[] array to record index instead of HashMap
        HashMap<Character, Integer> hm = new HashMap<>();
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<s.length(); i++) hm.put(s.charAt(i), i);
        int first = 0;
        int last = 0;
        for(int i=0; i<s.length(); i++) {
            if(last >= i) {
                last = Math.max(last, hm.get(s.charAt(i)));
                if(i == s.length() - 1) {
                    l.add(last - first + 1);
                    return l;
                }
            } else {
                l.add(last - first + 1);
                first = i;
                last = Math.max(i, hm.get(s.charAt(i)));
                if(i == s.length() - 1) {
                    l.add(last - first + 1);
                    return l;
                }
            }
        }
        return l;
    }
}
