package codes.java;

import org.scalatest.Entry;

import java.util.*;
import java.util.stream.Collectors;

public class ProcessLogs {
    public static void main(String[] args) {
        List<String> l = new ArrayList<String>();
        l.add("88 99 200");
        l.add("88 99 300");
        l.add("99 32 100");
        l.add("12 12 15");
        List<String> ll =  processLogs(l, 2);
        List<String> x = ll;
    }
    public static List<String> processLogs(List<String> logs, int threshold) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String log : logs) {
            String[] l = log.split(" ");
            if (!l[0].equals(l[1])) {
                hm.put(l[0], hm.getOrDefault(l[0], 0) + 1);
                hm.put(l[1], hm.getOrDefault(l[1], 0) + 1);
            } else {
                hm.put(l[0], hm.getOrDefault(l[0], 0) + 1);
            }
        }
        return new ArrayList<String>(hm.entrySet().stream().filter(a -> a.getValue() >= threshold)
                .sorted(Comparator.comparingInt(Map.Entry::getValue))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).keySet());
    }
}
