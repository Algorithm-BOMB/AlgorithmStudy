## DP (Dynamic Programming: 동적 프로그래밍)

### 개념

DP란 큰 문제를 작은 문제로 나누어 푸는 문제를 일컫는 말이다. <br>
모든 작은 문제들은 한 번만 풀어야 하며, 따라서 정답을 구한 작은 문제의 답을 저장해 놓는다(Memoization).<br>
다시 그보다 큰 문제를 풀어나갈 때 이미 풀었던 작은 문제가 나타나면 앞서 저장한 작은 문제의 결과값을 이용한다.

### DP의 조건

1. 작은 문제가 반복이 일어나는 경우
2. 같은 문제는 구할 때마다 정답이 같은 경우

### Divide and Conquer (분할정복) 과 다른점

분할정복은 큰 문제를 해결하기 어려워 단지 작은 문제로 나누어 푸는 방법일 뿐, 작은 문제에서 반복이 일어나진 않는다.<br>
하지만 DP는 작은 부분 문제들이 반복되고 그 답이 바뀌지 않는다는 큰 차이가 있다.

### 예시

대표적인 예로 피보나치 수를 들 수 있다.

![dp](https://user-images.githubusercontent.com/43297823/129444456-6cba71f9-b0b1-412e-9b62-2cfd8f858cbe.jpg)

```
F(n) = F(n-1) + F(n-2)
```

### 구현방법

1. Bottom-up : 작은 문제부터 차근차근 구해나가는 방법. 위의 피보나치 수가 그 예시.

```python
def fibonacci_bottom_up(n):
    if n <= 1:
        return n
​
    fir = 0
    sec = 1
    for i in range(0, n-1):
        next = fir+sec
        fir = sec
        sec = next
    return next

if __name__ == '__main__':
    n = int(sys.stdin.readline())
    print(fibonacci_bottom_up(n))
```

2. Top-down : 큰 문제를 풀 때 작은 문제가 아직 풀리지 않았다면 그때 작은 문제를 해결함. 재귀함수로 구현하는 경우가 대부분.

```python
def fibonacci_top_down(n):
    if memo[n] > 0:
        return memo[n]
​
    if n <= 1:
        memo[n] = n
        return memo[n]
​
    else:
        memo[n] = fibonacci_top_down(n-1) + fibonacci_top_down(n-2)
        return memo[n]

if __name__ == '__main__':
    memo = [0 for i in range (100)]
    n = int(sys.stdin.readline())
    print(fibonacci_top_down(n))
```

## 자료 출처

DFS, BFS: https://galid1.tistory.com/507
