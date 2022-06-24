# 2022 카카오 블라인드 채용
# 레벨1: 신고 결과 받기
# 걸린 시간: 25분
def solution(id_list, report, k):
    r = set() # 중복 신고를 제거하기 위한 집합
    
    for re in report:
        a, b = re.split(" ")
        r.add((a,b)) # 신고자 ID와 신고된 ID를 집합 r에 추가
    
    r = list(r) # 중복 신고를 제거하기 위한 집합을 리스트로 변경

    i = dict() # id_list의 존재하는 id가 몇번 신고 당했는지 세는 딕셔너리
    for id in id_list: 
        i[id] = 0 # 신고 횟수는 우선 모두 0으로 초기화
    
    res = dict() # 신고된 ID가 K횟수 이상만큼 신고되면 신고한 ID에게 
                 # 이메일을 보내기 위해 확인하는 딕셔너리
    for id in id_list:
        res[id] = 0 # 이메일 횟수도 우선 모두 0으로 초기화
    
    for j in range(len(r)):
        i[r[j][1]] += 1 # 신고된 ID에 따라 딕셔너리의 value값을 1증가(신고 받은 횟수 증가)
        
    for j in range(len(r)):
        if i[r[j][1]] >= k: # 신고된 횟수가 K이상 일경우
            res[r[j][0]] += 1 # 신고자에게 받게 되는 이메일 횟수 증가 
    
    result = [] # return할 결과 리스트
    for value in res.values(): # 신고자에게 받게 되는 이메일 횟수 값만 꺼내서
        result.append(value) # 결과 리스트에 append
    return result


# 다른 사람 코드 1
def solution(id_list, report, k):
    answer = [0] * len(id_list)    
    reports = {x : 0 for x in id_list}

    for r in set(report):
        reports[r.split()[1]] += 1

    for r in set(report):
        if reports[r.split()[1]] >= k:
            answer[id_list.index(r.split()[0])] += 1

    return answer

# 다른 사람 코드 2
def solution(id_list, report, k):
    answer = [0] * len(id_list)
    dic_report = {id: [] for id in id_list} # 해당 유저를 신고한 ID
    for i in set(report):
        i = i.split()
        dic_report[i[1]].append(i[0])

    for key, value in dic_report.items():
        if len(value) >= k:
            for j in value:
                answer[id_list.index(j)] += 1

    return answer