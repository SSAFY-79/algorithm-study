package algorithm.minje.week6.pro.보석쇼핑;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    static HashMap<String, Integer> map = new HashMap<String, Integer>();

    static void putEle(String key) {
        if (map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
            return;
        }
        map.put(key, 1);
    }

    static void removeEle(String key) {
        if (map.get(key) == 1) {
            map.remove(key);
            return;
        }
        map.put(key, map.get(key) - 1);
    }

    public static int[] solution(String[] gems) {
        int[] answer = {};
        int minDiff = Integer.MAX_VALUE;
        Set<String> set = new HashSet<String>(Arrays.asList(gems));


        int i = 0;
        int j = 0;


        while (true) {

            while (j<gems.length) {
                putEle(gems[j]);
                j++;
                if (map.size() == set.size()) break;
            }

            if(j>= gems.length && map.size() != set.size()) break;

            while (true) {
                removeEle(gems[i]);
                i++;
                if (map.size() != set.size()) break;
            }

            if(minDiff > j-i){
                minDiff=j-i;
                answer=new int[]{i,j};
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] result = solution(new String[]{"ZZZ", "YYY", "NNNN", "YYY", "BBB"});

        System.out.println(result[0] + "," + result[1]);
    }
}
