package algorithm.yunsik.week6.prg.q67257;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static final char[][] sequence = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'},
    };

    public long solution(String expression) {
        List<Long> numbers = Arrays.stream(expression.split("[-+*]"))
                .mapToLong(Long::parseLong)
                .boxed()
                .collect(Collectors.toList());
        List<Character> operators = expression.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> !Character.isDigit(c))
                .collect(Collectors.toList());

        long ans = 0L;
        for (int seq = 0; seq < sequence.length; seq++) {
            List<Long> numList = new ArrayList<>(numbers);
            List<Character> opList = new ArrayList<>(operators);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < opList.size(); j++) {
                    if (opList.get(j) != sequence[seq][i]) continue;
                    numList.set(j, calc(numList.get(j), numList.get(j + 1), opList.get(j)));
                    numList.remove(j + 1);
                    opList.remove(j);
                    j--;
                }
            }
            ans = Math.max(ans, Math.abs(numList.get(0)));
        }
        return ans;
    }

    private long calc(long val1, long val2, char operator) {
        if (operator == '+') return val1 + val2;
        else if (operator == '-') return val1 - val2;
        else return val1 * val2;
    }
}