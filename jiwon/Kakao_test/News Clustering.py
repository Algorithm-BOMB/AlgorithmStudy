'''
A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의
나눗셈이 정의 되지 않을 때에는 (둘 다 공집합인 경우) 1로 처리
다중집합의 경우
교집합은 min, 합집합은 max

입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다.

생각
같은 것을 어떻게 중첩 시킬 수 있을까..? 딕셔너리?
딕셔너리에 저장하고 하나는 집합으로 처리하면 될 듯

풀이
1. 문자열을 두 글자씩 끊어서 다중집합으로 처리 (숫자, 특수문자 제외) -> 확인
2. 다중집합으로 처리할 때 하나는 집합에 하나는 딕셔너리에 포함

'''


from collections import defaultdict


def get_multiset(str0):
    str0 = str0.upper()
    dic0 = defaultdict(int)
    set0 = set()
    for i in range(len(str0) - 1):
        s = str0[i:i+2]
        if s.isalpha():
            dic0[s] += 1
            set0.add(s)
    return dic0, set0


def solution(str1, str2):
    dic1, set1 = get_multiset(str1)
    dic2, set2 = get_multiset(str2)
    a = sum([min(dic1[item], dic2[item]) for item in set1&set2])
    b = sum([max(dic1[item], dic2[item]) for item in set1|set2])
    answer = int(a / b * 65536) if b != 0 else 65536
    return answer
