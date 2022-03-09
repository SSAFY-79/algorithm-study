package algorithm.yunsik.week6.prg.q67256;

class Solution {

    public String solution(int[] numbers, String hand) {
        StringBuilder ret = new StringBuilder();
        int[] leftLocation = new int[]{3, 0};
        int[] rightLocation = new int[]{3, 2};

        for (int number : numbers) {
            int ld = getDist(leftLocation, number, true);
            int rd = getDist(rightLocation, number, false);
            if ((ld == rd && hand.equals("left")) || (ld < rd)) {
                putNumber(leftLocation, number);
                ret.append("L");
            } else {
                putNumber(rightLocation, number);
                ret.append("R");
            }
        }
        return ret.toString();
    }

    private void putNumber(int[] handLocation, int number) {
        if (number == 0) {
            handLocation[0] = 3;
            handLocation[1] = 1;
        } else {
            handLocation[0] = (number - 1) / 3;
            handLocation[1] = (number - 1) % 3;
        }
    }

    private static int getDist(int[] handLocation, int number, boolean left) {
        if (number == 0) {
            return Math.abs(handLocation[0] - 3) + Math.abs(handLocation[1] - 1);
        }
        if (left && number % 3 == 1) return 0;
        if (!left && number % 3 == 0) return 0;
        return Math.abs(handLocation[0] - (number - 1) / 3) + Math.abs(handLocation[1] - (number - 1) % 3);
    }
}