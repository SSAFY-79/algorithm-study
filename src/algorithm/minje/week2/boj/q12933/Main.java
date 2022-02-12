package algorithm.minje.week2.boj.q12933;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static Map<Character, Character> DUCK_SOUND = new HashMap<Character, Character>() {{
        put('q', 'u');
        put('u', 'a');
        put('a', 'c');
        put('c', 'k');
        put('k', 'q');
    }};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().toCharArray();
        List<Character> duckList = new ArrayList<>();
        boolean flag = false;

        Loop: for (int i = 0; i < input.length; i++) {
            for (int listIdx = 0; listIdx < duckList.size(); listIdx++) {
                if (duckList.get(listIdx) == input[i]) {
                    duckList.set(listIdx, DUCK_SOUND.get(input[i]));
                    continue Loop;
                }
            }
            if (input[i] == 'q') duckList.add('u');
            else flag = true;
        }

        for (int i = 0; i < duckList.size(); i++) {
            if(duckList.get(i)!='q') flag=true;
        }

        if(flag){
            sb.append(-1);
        }
        else
            sb.append(duckList.size());
        bw.write(sb.toString());
        bw.flush();
    }
}
