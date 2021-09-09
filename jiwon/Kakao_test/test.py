'''
후보키를 찾는 문제

생각
1. 조합을 사용해야 할듯
1-1. 유일성과 최소성을 만족해야 한다. 유일성은 집합으로 하면 되지 않을까. 두 쌍으로 집합을 구성할 수 있나?
2. 중요한 건 여러 개를 뽑는다고 해서 무조건 후보키가 아닌 '최소성'을 만족해야함
3. 그럼 최소성을 어떻게 만족?
4. 최소성은 조합을 1~len(realation)으로 뽑아 기존의 키 중 최소인지 먼저 확인

'''

from itertools import combinations


def test2(c, row, dic):
    s = ""
    for k in c:
        s += row[k]
    if s not in dic:
        dic[s] = 0
        return True
    return False


def solution(relation):
    unique = []
    col = [i for i in range(len(relation[0]))]
    for i in range(1, len(relation[0])):
        for c in combinations(col, i):
            dic = dict()
            for row in relation:
                if not test2(c, row, dic):
                    break
            else:
                unique.append(c)
    # 최소성이 맞는 지 확인
    print(unique)
    answers = set(unique)
    for i in range(len(unique)):
        for j in range(i + 1, len(unique)):
            if len(unique[i]) == len(set(unique[i]) & set(unique[j])):
                answers.discard(unique[j])
    return len(answers)


print(solution([["100","ryan","music","2"],["200","apeach","math","2"],["300","tube","computer","3"],["400","con","computer","4"],["500","muzi","music","3"],["600","apeach","music","2"]]))

