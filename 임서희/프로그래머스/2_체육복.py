# 탐욕법(Greedy)
# 레벨1: 체육복
# 80점
# 테스트케이스 5,12,13,14 실패
def solution(n, lost, reserve):
    reserve_count = [0] * (n+2)
    num = n - len(lost)
    for i in reserve:
        reserve_count[i] += 1
    for i in range(len(lost)):
        if reserve_count[lost[i]-1] != 0:
            num += 1
            reserve_count[lost[i]-1] = 0
        elif reserve_count[lost[i]+1] != 0:
            num += 1
            reserve_count[lost[i]+1] = 0
        elif reserve_count[lost[i]] != 0:
            num+=1
            reserve_count[lost[i]] = 0 # 자기 자신도 포함
    return num

n = 3
lost = [3]
reserve = [3]
print(solution(n,lost, reserve))

# 다시 풀기