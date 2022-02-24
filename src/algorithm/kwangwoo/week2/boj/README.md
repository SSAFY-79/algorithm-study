## 문제 :mag:

[BOJ/1913번](https://www.acmicpc.net/problem/1913) 달팽이

[BOJ/2578번](https://www.acmicpc.net/problem/2578) 빙고

[BOJ/4396번](https://www.acmicpc.net/problem/4396) 지뢰 찾기

[BOJ/12933번](https://www.acmicpc.net/problem/12933) 오리

[BOJ/14467번](https://www.acmicpc.net/problem/14467) 소가 길을 건넌 이유 1


---------------------------------------------------------------------------

## 히스토리 :memo:

### BOJ/1913: 달팽이

> 1회 : 시간초과<br>
> 2회 : 시간초과<br>
> 3회 : [성공](https://github.com/BumBamBi/algorithm-study/blob/main/src/algorithm/kwangwoo/week2/boj/q1913/Main.java)
- 상하좌우로 이동하는 경우에 따라 변수값 조절하여 값을 채워나감
- Scanner를 사용하여 시간초과
- BuffuredReader를 사용해도 시간초과
- BufferedWriter도 함께 사용하니 통과

### BOJ/2578: 빙고

> 1회 : [성공](https://github.com/BumBamBi/algorithm-study/tree/main/src/algorithm/kwangwoo/week2/boj/q2578)
- 대각선 2개와 가로 5개, 세로 5개의 빙고 경우의 수를 비교
- 한번 빙고가 되면 재탐색을 하지 않음

### BOJ/4396: 지뢰 찾기

> 1회 : 오답 <br>
> 2회 : [성공](https://github.com/BumBamBi/algorithm-study/blob/main/src/algorithm/kwangwoo/week2/boj/q4396/Main.java)
- 지뢰를 열어도 전부 *로 출력하는 것이 아니라, 열기로한 칸은 제대로 출력하고 지뢰도 표시해야하는데, 그러지 않아서 오답

### BOJ/12933: 오리

> 1회 : 오답 <br>
> 2회 : 오답 <br>
> 4회 : 오답 <br>
> 3회 : [성공](https://github.com/BumBamBi/algorithm-study/blob/main/src/algorithm/kwangwoo/week2/boj/q12933/Main.java)

- 1회 : quack을 마무리 하지 않은 경우(q, qu, qua, quack) -1을 출력하지 않아서 오답
- 2회 : 메소드 리턴값 예외값 처리를 했으나, 문제조건에서 q,u,a,c,k 만 입력는 조건이 있으므로 오답
- 3회 : quack을 제대로 마무리 하지 않은 경우 추가했으나, 최적화 중 char와 Character를 혼용하여 사용하여 오답
- 4회 : Character 대신 char을 사용하여 정답

### BOJ/14467: 소가 길을 건너간 이유 1

> 1회 : [성공](https://github.com/BumBamBi/algorithm-study/blob/main/src/algorithm/kwangwoo/week2/boj/q14467/Main.java)
- 1회 : HashMap를 이용하여 <소의 번호, 현 상태>를 저장, 검색, 수정하여 구현

<br>

---------------------------------------------------------------------------

## 하고 싶은 말(optional)

### BOJ/1913: 달팽이

가운데부터 숫자를 증가시키면서 구현

방향의 경우를 각 0~3으로 주면서 switch문으로 row나 col의 +1 or -1 시키면서 동작 

### BOJ/2578: 빙고

빙고를 만들 수 있는 경우는 가로 5개, 세로 5개, 대각선 2개

각 빙고 여부를 확인하는 대각선 boolean 변수 2개, 세로 boolean[5], 가로 boolean[5] 선언

각 변수의 값을 확인하면서, 한 번 빙고가 되면 빙고카운트를 +1 하면서, 해당 라인은 다시 탐색하지 않도록 함

이를 통해 빙고카운트가 총 3개 이상(한번에 2개 이상 빙고가 될 수 있으므로)이면 끝

### BOJ/4396: 지뢰 찾기

각 가로, 세로의 사이즈르 +2 하여, 팔방탐색 시 index신경을 쓰지 않도록 함

현재 상태(.과 *이 들어온 값)를 저장하는 char 2차원배열, 오픈여부(O가 들어오면 True)을 저장하는 boolean 2차원 배열 선언

오픈여부를 확인하며 지뢰 여부확인, 팔방탐색을 수행

### BOJ/12933: 오리

ArrayList를 통해 q가 입력되면 add, quack이 차례로 잘 수행되면 remove 하는 식으로 구현

각 q, u, a, c, k 를 저장하고 있는 table을 만들어서 인덱스로 접근 가능하도록 함

list를 조회하면서, 현재 입력값이 제대로 된 순서가 맞다면 char 값 update

char 값이 k가 되면 해당 char 삭제

이러면서 list의 사이즈 최대 값을 구함 

마지막에 list의 size가 0이 아니라면 제대로 마무리 되지 않은 것이므로 -1

### BOJ/14467: 소가 길을 건너간 이유 1

HashMap을 통해 키-소의번호, 값-상태 로 두며 구현

값이 다르면 update 후 카운트+1