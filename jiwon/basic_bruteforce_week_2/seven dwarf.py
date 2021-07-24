# 일곱 명이 아닌 아홉 명이었다.
# 일곱 난쟁이의 키의 합이 100이 된다.
# 정답이 여러가지인 경우에는 아무거나 출력
# 정답은 키의 오름차순

# 풀이
# 1. 아홉 명의 난쟁이의 키를 입력 받는다.
# 2. 입력 받은 난쟁이들의 키의 합을 구한 다음, 2명의 키를 빼본다 -> 2중 for문, 뺄 떄 리스트에서 제외


def get_100(h):
    h_sum = sum(h)
    for i in range(8):
        for j in range(i + 1, 9):
            if h_sum - (h[i] + h[j]) == 100:
                return i, j


def solution():
    h = [int(input()) for _ in range(9)]
    a, b = get_100(h)
    h.pop(a)
    h.pop(b - 1)
    h.sort()
    for i in h:
        print(i)


solution()
