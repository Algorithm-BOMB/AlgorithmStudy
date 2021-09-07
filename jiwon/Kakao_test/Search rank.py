from collections import defaultdict
from itertools import combinations
from bisect import bisect_left

def pre_processing(info):
    dic = defaultdict(list)
    for i in info:
        i = i.split()
        comb = i[:-1]
        val = int(i[-1])
        for cnt in range(5):
            for key in combinations(comb, cnt):
                key = ''.join(key)
                dic[key].append(val)
    for key in dic.keys():
        dic[key].sort()
    return dic


def solution(info, query):
    answer = []
    info_dic = pre_processing(info)
    for q in query:
        q_list = q.split()
        key = [i for i in q_list if i.isalpha() and i != "and"]
        key = ''.join(key)
        answer.append(len(info_dic[key]) - bisect_left(info_dic[key], int(q_list[-1])))
    return answer
