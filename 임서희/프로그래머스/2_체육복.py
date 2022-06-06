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
# 85점
# 테스트케이스 1,6,7 실패
def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()

    for i in lost: # 자기 자신이 잃어버린거 여벌 있으면 먼저 제외
        if i in reserve:
            lost.pop(lost.index(i))
            reserve.pop(reserve.index(i))
            
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
    return num

# 수정된 맞는 코드
# 걸린 시간: 52분
# 참고: https://devpouch.tistory.com/110 ([python] list로 for문 돌면서 remove할때 주의할점)
def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()

    # for i in lost:로 하면 루프를 돌면서 건너뛰게 되는 경우 발
    for i in lost[:]: # 자기 자신이 잃어버린거 여벌 있으면 먼저 제외
        if i in reserve:
            lost.pop(lost.index(i))
            reserve.pop(reserve.index(i))
    
    reserve_count = [0] * (n+2)
    
    num = n - len(lost)
    print(lost, reserve, num)
    for i in reserve:
        reserve_count[i] += 1
    
    for i in range(len(lost)):
        if reserve_count[lost[i]-1] != 0:
            num += 1
            reserve_count[lost[i]-1] = 0
        elif reserve_count[lost[i]+1] != 0:
            num += 1
            reserve_count[lost[i]+1] = 0
    return num