package algorithm.kwangwoo.week6.programmers.키패드_누르기;

public class Main {
    public static void main(String[] args) {
        
    }
}

// C++로 구현

// #include <string>
// #include <vector>
// #include <string>
// #include <math.h>
// #include <iostream>

// using namespace std;

// char func(int n, string s, int& l, int& r){
    
//     if(n == 0){
//         n = 11;
//     }
    
//     // 같은 자리인 경우
//     if(n == l){
//         l = n;
//         return 'L';
//     }else if(n == r){
//         r = n;
//         return 'R';
//     }
    
//     /*
//     00 01 02
//     10 11 12
//     20 21 22
//     30 31 32
    
//     이렇게 x, y좌표를 구함.
//     x : ((n-1)/3)
//     y : ((n-1)%3)
    
//     타겟의 각 x, y 값과 왼손/오른손의 각 x, y 값의 차를 구하여 더하면 거리가 나옴.    
//     */
    
//     int target_xy[2];
//     target_xy[0] = ((n-1)/3);
//     target_xy[1] = ((n-1)%3);
    
//     int left_xy[2];
//     left_xy[0] = ((l-1)/3);
//     left_xy[1] = ((l-1)%3);
    
//     int right_xy[2];
//     right_xy[0] = ((r-1)/3);
//     right_xy[1] = ((r-1)%3);
    
//     int distance_left_to_target = abs(target_xy[0] - left_xy[0]) + abs(target_xy[1] - left_xy[1]);
//     int distance_right_to_target = abs(target_xy[0] - right_xy[0]) + abs(target_xy[1] - right_xy[1]);
    
//     if(distance_left_to_target == distance_right_to_target){
//         if(s == "left"){
//             l = n;
//             return 'L';
//         }else{
//             r = n;
//             return 'R';
//         }
//     }else{
//         distance_left_to_target < distance_right_to_target ? l = n : r = n;
//         return distance_left_to_target < distance_right_to_target ? 'L' : 'R';
//     }
        
        
// }

// string solution(vector<int> numbers, string hand) {
    
//     string answer = "";
//     int left_hand = 10;
//     int right_hand = 12;

//     for(auto e:numbers){
//         if((e == 1) || (e == 4) || (e == 7)){
//             if(e == 1) left_hand = 1;
//             if(e == 4) left_hand = 4;
//             if(e == 7) left_hand = 7;
            
//             answer += 'L';
//         }
//         else if((e == 3) || (e == 6) || (e == 9)){
//             if(e == 3) right_hand = 3;
//             if(e == 6) right_hand = 6;
//             if(e == 9) right_hand = 9;
            
//             answer += 'R';
//         }
//         else{
//             answer += func(e, hand, left_hand, right_hand);
//         }
//     }
    
//     cout << answer;
    
//     return answer;
// }