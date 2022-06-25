# 2019 카카오 블라인드 채용
# 레벨1: 실패율
# 걸린 시간: 34분

# 내 코드: 정답이지만 효율성이 많이 떨어짐
# 최대 (6754.75ms, 18MB)
def solution(N, stages):
    stage = [0] * (N+1)
    no_clear = [0] * (N+1)
    
    for s in stages:
        no_clear[s-1] += 1
        for i in range(0,s):
            stage[i] += 1
    result = dict()        
    for i in range(N):
        if stage[i] == 0:
            stage[i] = 0
        else:
            stage[i] = no_clear[i]/stage[i]
        result[i+1] = stage[i]
        
    result = sorted(result.items(), key=lambda x:x[1], reverse=True)
    
    return [result[i][0] for i in range(N)]

# 다른 사람 코드: 최대 (14.34ms, 18.2MB)
def solution(N, stages):
    answer = []
    fail = []
    info = [0] * (N + 2)
    for stage in stages:
        info[stage] += 1
    for i in range(N):
        be = sum(info[(i + 1):])
        yet = info[i + 1]
        if be == 0:
            fail.append((str(i + 1), 0))
        else:
            fail.append((str(i + 1), yet / be))
    for item in sorted(fail, key=lambda x: x[1], reverse=True):
        answer.append(int(item[0]))
    return answer

# 시간 복잡도를 줄이는 방법을 고려해보기