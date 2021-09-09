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


def solution(relation):
    unique = []
    col = [i for i in range(len(relation[0]))]
    for i in range(1, len(relation[0]) + 1):
        for c in combinations(col, i):
            row_list = [tuple(row[k] for k in c) for row in relation]
            if len(set(row_list)) == len(row_list):
                unique.append(c)
    # 최소성이 맞는 지 확인
    answers = set(unique)
    for i in range(len(unique)):
        for j in range(i + 1, len(unique)):
            if len(unique[i]) == len(set(unique[i]) & set(unique[j])):
                answers.discard(unique[j])
    return len(answers)
