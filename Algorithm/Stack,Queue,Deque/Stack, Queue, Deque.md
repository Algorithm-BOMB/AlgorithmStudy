# 스택
## 스택의 개념
한 쪽 끝에서만 자료를 넣고 뺄 수 있는 LIFO(Last In First Out) 형식의 자료 구조

## 스택의 연산
스택(Stack)는 LIFO(Last In First Out) 를 따른다. 즉, 가장 최근에 스택에 추가한 항목이 가장 먼저 제거될 항목이다.

- pop(): 스택에서 가장 위에 있는 항목을 제거한다.
- push(item): item 하나를 스택의 가장 윗 부분에 추가한다.
- peek(): 스택의 가장 위에 있는 항목을 반환한다.
- isEmpty(): 스택이 비어 있을 때에 true를 반환한다.

## 스택의 구현
스택(Stack)은 **연결리스트**로 구현할 수 있다. 연결리스트의 같은 방향에서 아이템을 추가하고 삭제하도록 구현한다.
- 배열과 달리 스택은 상수 시간에 i번째 항목에 접근할 수 없다.
- 하지만 스택에서 데이터를 추가하거나 삭제하는 연산은 상수 시간에 가능하다.
- 배열처럼 원소들을 하나씩 옆으로 밀어 줄 필요가 없다.

```java
public class MyStack {
  private static class StackNode {
    private T data;
    private StackNode next;

    public StackNode(T data) {
      this.data = data;
    }
  }

  private StackNode top;

  public T pop() {
    if (top == null) throw new NoSuchElementException();
    T item = top.data;
    top = top.next;

    return item;
  }

  public void push(T item) {
    StackNode t = new StackNode(item);
    t.next = top;
    top = t;
  }

  public T peek() {
    if (top == null) throw new NoSuchElementException();
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}
```

## 스택의 사용 사례
재귀 알고리즘을 사용하는 경우 스택이 유용하다.

### 재귀 알고리즘
- 재귀적으로 함수를 호출해야 하는 경우에 임시 데이터를 스택에 넣어준다.
- 재귀함수를 빠져 나와 퇴각 검색(backtrack)을 할 때는 스택에 넣어 두었던 임시 데이터를 빼 줘야 한다.
- 스택은 이런 일련의 행위를 직관적으로 가능하게 해 준다.
- 또한 스택은 재귀 알고리즘을 반복적 형태(iterative)를 통해서 구현할 수 있게 해준다.
- DFS
### 웹 브라우저 방문기록 (뒤로가기)
### 실행 취소 (undo)
### 역순 문자열 만들기
### 수식의 괄호 검사 (연산자 우선순위 표현을 위한 괄호 검사)
Ex) 올바른 괄호 문자열(VPS, Valid Parenthesis String) 판단하기
### 후위 표기법 계산

## java 라이브러리 스택(Stack) 관련 메서드
### push(E item)
해당 item을 Stack의 top에 삽입  
Vector의 addElement(item)과 동일
### pop()
Stack의 top에 있는 item을 삭제하고 해당 item을 반환
### peek()
Stack의 top에 있는 item을 삭제하지않고 해당 item을 반환
### empty()
Stack이 비어있으면 true를 반환 그렇지않으면 false를 반환
### search(Object o)
해당 Object의 위치를 반환  
Stack의 top 위치는 1, 해당 Object가 없으면 -1을 반환


# 큐
## 큐의 개념
컴퓨터의 기본적인 자료 구조의 한가지로, 먼저 집어 넣은 데이터가 먼저 나오는 FIFO(First In First Out)구조로 저장하는 형식

## 큐의 연산
큐(Queue)는 FIFO(First-In-First-Out) 를 따른다.

- add(item): item을 리스트의 끝부분에 추가한다.
- remove(): 리스트의 첫 번째 항목을 제거한다.
- peek(): 큐에서 가장 위에 있는 항목을 반환한다.
- isEmpty(): 큐가 비어 있을 때에 true를 반환한다.

## 큐의 구현
큐(Queue)는 연결리스트 로 구현할 수 있다. 연결리스트의 반대 방향에서 항목을 추가하거나 제거하도록 구현한다.
```java
public class MyQueue {
  private static class QueueNode {
    private T data;
    private QueueNode next;

    public QueueNode(T data) {
      this.data = data;
    }
  }

  private QueueNode first;
  private QueueNode last;

  public void add(T item) {
    QueueNode t = new QueueNode(item);

    if (last != null) last.next = t;
    last = t;
    if (first == null) first = last;
  }

  public T remove() {
    if (first == null) throw new NoSuchElementException();
    T data = first.data;
    first = first.next;

    if (first == null) last = null;
    return data;
  }

  public T peek() {
    if (first == null) throw new NoSuchElementException();
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
```
- 큐(Queue)에서 처음과 마지막 노드를 갱신할 때 실수가 나오기 쉽다.

## 큐(Queue)의 사용 사례
데이터가 입력된 시간 순서대로 처리해야 할 필요가 있는 상황에 이용한다.

### 너비 우선 탐색(BFS, Breadth-First Search) 구현
- 처리해야 할 노드의 리스트를 저장하는 용도로 큐(Queue)를 사용한다.
- 노드를 하나 처리할 때마다 해당 노드와 인접한 노드들을 큐에 다시 저장한다.
- 노드를 접근한 순서대로 처리할 수 있다.
### 캐시(Cache) 구현
### 우선순위가 같은 작업 예약 (인쇄 대기열)
### 선입선출이 필요한 대기열 (티켓 카운터)
### 콜센터 고객 대기시간
### 프린터의 출력 처리
### 윈도 시스템의 메시지 처리기
### 프로세스 관리

## java 라이브러리 큐(Queue) 관련 메서드
###  두 가지 형태의 메서드
1. 수행이 실패했을 때 exception을 발생  
add(e), element(), remove()
2. 수행이 실패했을 때 null 또는 false를 반환  
offer(e), peek(), poll()
### 수행이 실패했을 때 exception을 발생하는 메서드
- boolean add(E item)  
해당 item을 Queue에 삽입  
삽입에 성공하면 true를 반환, 삽입할 공간이 없는 경우는 예외(IllegalStateException)를 발생
- E element()  
Queue의 Head에 있는 item을 삭제하지않고 해당 item을 반환
만약 Queue가 비어있으면 예외를 발생
- E remove()  
Queue의 Head에 있는 item을 삭제하고 해당 item을 반환
만약 Queue가 비어있으면 예외를 발생  
수행이 실패했을 때 null 또는 false를 반환하는 메서드
- boolean offer(E item)  
add(e)와 동일한 기능  
삽입에 성공하면 true를 반환, 실패하면 false를 반환
- E peek()
element()와 동일한 기능  
만약 Queue가 비어있으면 null을 반환
- E poll()  
remove()와 동일한 기능  
만약 Queue가 비어있으면 null을 반환

# Deque(덱)
## 덱의 개념
- Deque, Double-ended queue의 약자이다.
- 양 끝에서만 자료를 넣고 양 끝에서 뺄 수 있는 자료구조
- 큐는 push, pop을 할 수 있는 위치가 한 방향으로 고정되어 있지만, 덱은 앞에서도 push, pop, 뒤에서도 push, pop이 모두 가능하다.
- 중요한 자료구조는 맞지만, 덱의 특징을 이용해서 문제를 푸는 경우는 많지 않음.

## 덱의 연산
- push_front() : 덱의 앞에 자료를 넣는 연산

- pop_front() : 덱의 앞에서 자료를 빼는 연산

- push_back() : 덱의 뒤에 자료를 넣는 연산 

- pop_back() : 덱의 뒤에서 자료를 빼는 연산

- front() : 덱의 가장 앞에 있는 자료를 보는 연산

- back() : 덱의 가장 뒤에 있는 자료를 보는 연산

## 덱의 구현
- 앞, 뒤에서 삭제 추가 연산이 일어나기 때문에 보통 이중 연결리스트로 구현한다고 함

### DequeNode.java
```java
ackage Deque;
 
public class DequeNode {
    char data;
    DequeNode llink;
    DequeNode rlink;
    
    public DequeNode() {
        this.llink = null;
        this.rlink = null;
    }
    
    public DequeNode(char data) {
        this.data = data;
        this.llink = null;
        this.rlink = null;
    }
}
```
### Deque.java
```java
package Deque;
 
public class Deque {
    DequeNode front;
    DequeNode rear;
    
    public Deque() {
        front = null;
        rear = null;
    }
    
    public boolean isEmpty(){
        return (front==null);
    }
    
    public void insertFront(char item){
        DequeNode node = new DequeNode(item);
        if(isEmpty()){
            front = node;
            rear = node;
            node.rlink = null;
            node.llink = null;
        }else{
            node.rlink = front;
            node.llink = null;
            front.llink = node;
            front = node;
        }
    }
    
    public char deleteFront(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
            return 0;
        }else{
            char data = front.data;
            if(front.rlink==null){
                front = null;
                rear = null;
            }else{
                front = front.rlink;
                front.llink = null;
            }
            return data;
        }
    }
    
    public void insertRear(char item){
        DequeNode node =  new DequeNode(item);
        if(isEmpty()){
            front = node;
            rear = node;
            node.rlink = null;
            node.llink = null;
        }else{
            node.llink = rear;
            node.rlink = null;
            rear.rlink = node;
            rear = node;
        }
    }
    
    public char deleteRear(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
            return 0;
        }else{
            char data = rear.data;
            if(rear.llink==null){
                front = null;
                rear = null;
            }else{
                rear = rear.llink;
                rear.rlink = null;
            }
            return data;
        }
    }
    
    public void removeFront(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
        }else{
            if(front.rlink==null){
                front = null;
                rear = null;
            }else{
                front = front.rlink;
                front.llink = null;
            }
        }
    }
    
    public void removeRear(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
        }else{
            if(rear.llink==null){
                front = null;
                rear = null;
            }else{
                rear = rear.llink;
                rear.rlink = null;
            }
        }
    }
    
    public char peekRear(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
            return 0;
        }else{
            return rear.data;
        }
    }
    
    public char peekFront(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
            return 0;
        }else{
            return front.data;
        }
    }
    
    public void print(){
        if(isEmpty()){
            System.out.println("덱이 비어있습니다.");
        }else{
            DequeNode node = front;
            while(node!=null){
                System.out.print(node.data + " ");
                node = node.rlink;
            }
            System.out.println();
        }
    }
```

