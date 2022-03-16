package algorithm.minje.week6.pro.수식최대화;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SolutionTest {

    @org.junit.jupiter.api.Test
    void solution() {
        String expression = "100-200*300-500+20";
        int exp = 60420;
        Solution solution = new Solution();
        long result = solution.solution(expression);

        assertEquals(exp,result);
    }

}