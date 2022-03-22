package algorithm.jungin.week6.programmers.q67256_키패드누르기;

class Solution {
    static int l_x=3, l_y=0, r_x=3, r_y=2;
    static String answer = "";

    public String solution(int[] numbers, String hand) {

        for(int i=0; i<numbers.length; i++){
            if(numbers[i] == 0)
                numbers[i] = 11;
            switch(numbers[i]){
                case 1:
                case 4:
                case 7:
                    leftHand(numbers[i]/3, 0);
                    break;
                case 3:
                case 6:
                case 9:
                    rightHand(numbers[i]/3-1, 2);
                    break;
                case 2:
                case 5:
                case 8:
                case 11:
                    int x, y;
                    x=numbers[i]/3;
                    y=1;
                    if((Math.abs(l_x-x) + Math.abs(l_y-y)) > (Math.abs(r_x-x) + Math.abs(r_y-y))){
                        rightHand(x, y);
                    } else if((Math.abs(l_x-x) + Math.abs(l_y-y)) < (Math.abs(r_x-x) + Math.abs(r_y-y))){
                        leftHand(x, y);
                    } else{
                        if(hand.equals("right")){
                            rightHand(x, y);
                        }
                        else{
                            leftHand(x, y);
                        }
                    }
                    break;
            }
        }
        return answer;
    }
    public static void rightHand(int x, int y){
        answer += "R";
        r_x = x;
        r_y = y;
    }
    public static void leftHand(int x, int y){
        answer += "L";
        l_x = x;
        l_y = y;
    }
}