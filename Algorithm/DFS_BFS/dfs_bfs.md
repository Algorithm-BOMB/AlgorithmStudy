# AlgorithmStudy

## 재귀

- 재귀함수: 자기 자신을 호출하는 함수

재귀 알고리즘은 재귀함수를 이용한 알고리즘으로, 어떤 문제를 해결하기 위해 문제의 범위보다 약간 좁은 하위 문제를 해결한다. 문제가 간단해져서 바로 풀 수 있는 문제로 작아질 때까지 하위 문제들을 계속해서 해결해낸 다음 하위 문제에 대한 해답을 이용하여 원래 문제를 해결한다.<br>

대표적인 예시로 팩토리얼 구하기가 있다.

```
int factorial(int n)
{
    //base case
    if (n == 0 || n == 1)
    {
        return 1;
    }
    //Recusion case
    return n*factorial(n - 1);

}
```

## DFS (Depth-First Search: 깊이우선탐색)

![dfs](https://user-images.githubusercontent.com/43297823/126872431-b14daa04-625b-4c5c-a91d-3ed0f901a018.gif)

DFS는 그래프 전체를 탐색하는 방법중 하나로써, 시작점 부터 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색하고 넘어가는 방법이다.<br>
스택이나 재귀함수를 통해서 구현할 수 있는데 재귀함수가 구현이 간편하기에 대부분 재귀함수로 구현한다.<br>
구현시 주의할점은 노드를 방문시 방문 여부를 반드시 검사해야 하며, 그렇지 않다면 무한루프에 빠질 수 있다.<br>
<br>
DFS의 장점

1. 현재 경로상의 노드들만 기억하면 되므로, 저장 공간의 수요가 비교적 적음
2. 목표 노드가 깊은 단계에 있는 경우 해를 빨리 구할 수 있음
3. 구현이 너비 우선 탐색(BFS) 보다 간단함

DFS의 단점

1. 단순 검색 속도는 너비 우선 탐색(BFS) 보다 느림
2. 해가 없는 경우에 빠질 가능성이 있음 (사전에 임의의 깊이를 지정한 후 탐색하고, 목표 노드를 발견하지 못할 경우 다음 경로를 탐색하도록 함)
3. 깊이 우선 탐색은 해를 구하면 탐색이 종료되므로, 구한 해가 최단 경로가 된다는 보장이 없음(목표에 이르는 경로가 다수인 경우 구한 해가 최적이 아닐 수 있음)

## BFS (Breadth-First Search: 너비우선탐색)

![bfs](https://user-images.githubusercontent.com/43297823/126872433-e9d66508-e47e-4596-8b45-ecc04d4ca965.gif)

BFS는 그래프 전체를 탐색하는 방법 중 하나로써 루트 노드(혹은 다른 임의의 노드)에서 시작해서 인접한 노드를 먼저 탐색하는 방법이다.<br>
시작 정점으로부터 가까운 정점을 먼저 방문하고 멀리 떨어져 있는 정점을 나중에 방문하는 순회함으로써 노드를 넓게(wide) 탐색한다.<br>
주로 두 노드 사이의 최단 경로 혹은 임의의 경로를 찾고 싶을 때 이 방법을 사용한다.<br>
주로 구현은 Queue에 이웃하는 정점을 다 담아놓고 차례대로 POP을 하는 방식으로 구현한다.<br>
<br>
BFS의 장점

1. 노드의 수가 적고 깊이가 얕은 경우 빠르게 동작할 수 있다.
2. 단순 검색 속도가 깊이 우선 탐색(DFS)보다 빠름
3. 너비를 우선 탐색하기에 답이 되는 경로가 여러개인 경우에도 최단경로임을 보장한다.
4. 최단경로가 존재한다면 어느 한 경로가 무한히 깊어진다해도 최단경로를 반드시 찾을 수 있다.

BFS의 단점

1. 재귀호출의 DFS와는 달리 큐에 다음에 탐색할 정점들을 저장해야 하므로 저장공간이 많이 필요하다.
2. 노드의 수가 늘어나면 탐색해야하는 노드 또한 많아지기에 비현실적이다.

## 자료 출처

DFS, BFS: https://coding-factory.tistory.com/611
