'''
중복 닉네임 허락
기존에 무지가 나가서 프로도로 들어오면 기존 것도 변경해주어야 한다.

입력 - "명령 유저아이디 닉네임"

생각
- 유저아이디가 있으므로 닉네임을 변경했을 때도 유저아이디로 변경해준다.
- 닉네임이 변경되면 기존의 것도 변경되어야 한다.
- 이걸 시간복잡도를 줄이려면..
- record를 먼저 for문을 돌면서 가장 마지막에 된 닉네임만 기억
- 그리고 다시 한 번 record를 돌면서 Enter, Leave, Change에 따라서 나누어준다.
- 닉네임은 해당 유저에 해당하는 것만 ! 유저아이디 : 닉네임 <- 해쉬맵으로
'''


def get_name(record):
    id_name = dict()
    for r in record:
        one = r.split(" ")
        if one[0] == "Enter" or one[0] == "Change":
            id_name[one[1]] = one[2]
    return id_name


def solution(record):
    answer = []
    id_name = get_name(record)
    for r in record:
        one = r.split(" ")
        if one[0] == "Enter":
            s = id_name[one[1]] + "님이 들어왔습니다."
        elif one[0] == "Leave":
            s = id_name[one[1]] + "님이 나갔습니다."
        else:
            continue
        answer.append(s)
    return answer
