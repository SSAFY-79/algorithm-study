package algorithm.yunsik.week6.prg.q67258;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Map<String, Integer> map = new HashMap<>();
        for (String gem : gems) {
            map.put(gem, 0);
        }
        int cnt = map.size();
        map.clear();

        int minLen = gems.length;
        int ansBegin = 1;
        int ansEnd = gems.length;
        for (int begin = 0, end = 0; begin < gems.length; ) {
            if (end < gems.length && map.size() < cnt) {
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            } else {
                if (map.size() == cnt && minLen > end - begin) {
                    minLen = end - begin;
                    ansBegin = begin + 1;
                    ansEnd = end;
                }
                map.put(gems[begin], map.get(gems[begin]) - 1);
                if (map.get(gems[begin]) == 0) map.remove(gems[begin]);
                begin++;
            }
        }
        return new int[]{ansBegin, ansEnd};
    }
}