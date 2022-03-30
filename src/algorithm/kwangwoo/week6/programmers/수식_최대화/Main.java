package algorithm.kwangwoo.week6.programmers.수식_최대화;

public class Main {

}

// C++로 구현

// #include <string>
// #include <vector>
// #include <algorithm>
// #include <iostream>

// using namespace std;

// bool condition(char a, char b){
//     return a < b;
// }

// long long solution(string expression) {
    
//     // 문자열을 잘라서 따로 저장하기(숫자/기호)
//     // -------------------------------------------------------
//     // 숫자와 기호를 각자 저장할 벡터
//     vector<long long> numbers;
//     vector<char> ops;
    
//     // 숫자 자리수 계산을 위한 벡터
//     vector<int> eachNums;
    
//     for(int i=0; i<expression.size(); i++){
//         // 숫자
//         if(expression[i] >= '0' && expression[i] <= '9'){
//             // 각 자리수를 저장
//             eachNums.push_back(expression[i]);
//         }
//         // 기호
//         else{
//             // 숫자 처리
//             long long num = 0;
//             for(auto& e:eachNums){
//                 num *= 10;
//                 num += e-'0';
//             }
//             numbers.push_back(num);
//             eachNums.clear();
            
            
//             // 기호 저장
//             ops.push_back(expression[i]);
//         }
//     }
//     // 마지막 숫자 처리
//     long long num = 0;
//     for(auto& e:eachNums){
//         num *= 10;
//         num += e-'0';
//     }
//     numbers.push_back(num);
//     eachNums.clear();
    
//     // -------------------------------------------------------
    
//     vector<char> priority;
//     priority.push_back('*');
//     priority.push_back('+');
//     priority.push_back('-');
//     // 기호 정렬
//     sort(priority.begin(), priority.end(), condition);
    
//     long long maxValue = -1;
//     // 순열
//     do{
//         vector<long long> copyNumbers = numbers;
//         vector<char> copyOps = ops;
//         // 우선순위대로 처리하기
//         for(int i=0; i<priority.size(); i++){
//             // 모든 기호 확인하기
//             for(int j=0; j<copyOps.size(); j++){
//                 if(copyOps[j] == priority[i]){
//                     // cout << copyNumbers[j] << " " << copyOps[j] << " " << copyNumbers[j+1];
//                     switch(copyOps[j]){
//                         case '+': copyNumbers[j] += copyNumbers[j+1]; break;
//                         case '-': copyNumbers[j] -= copyNumbers[j+1]; break;
//                         case '*': copyNumbers[j] *= copyNumbers[j+1]; break;
//                     }
//                     copyNumbers.erase(copyNumbers.begin()+j+1);
//                     copyOps.erase(copyOps.begin()+j);
//                     // cout << " = " << copyNumbers[j] << endl;
//                     j--;
//                 }
//             }
//         }
//         maxValue = max(maxValue, abs(copyNumbers[0]));
//     }while(next_permutation(priority.begin(), priority.end()));
    
    
//     long long answer = 0;
//     return maxValue;
// }