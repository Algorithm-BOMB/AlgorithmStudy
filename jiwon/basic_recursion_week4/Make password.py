# 서로 다른 L개의 알파벳 소문자들로 구성,
# 최소 한 개의 모음과 두 개의 자음으로 구성되어 있다.
# 알파벳이 암호에서 증가하는 순서로 배열되어 있을 것이다.
# abc는 가능, bac는 불가능

# 풀이
# 1. 사전순으로 증가하는 경우가 아닌 경우는 제외
# <- 정렬을 시킨 뒤에 하면 되지 않을까?
# 2. 최소 한 개의 모음과 두 개의 자음으로 구성되어 있는지 확인
# <- 마지막에 하면 될 듯?
# 3. 재귀를 돌릴때 for문으로 돌려야할 듯 개수가 매번 변하니깐

from sys import stdout

l, c = map(int, input().split())
vowel = "aeiou"
pw = sorted(input().split())


def dfs(a, s, v):
    if len(s) == l:
        cnt = 0
        for i in s:
            if i in vowel:
                cnt += 1
        if cnt >= 1 and len(s) - cnt >= 2:
            stdout.write(s + "\n")
        return
    for i in range(a, c):
        if not v[i]:
            v[i] = True
            dfs(i + 1, s + pw[i], v)
            v[i] = False


def solution():
    v = [False] * c
    dfs(0, "", v)


solution()
