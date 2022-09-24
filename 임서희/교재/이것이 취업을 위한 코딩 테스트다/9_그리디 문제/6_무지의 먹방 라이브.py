# 2019 KAKAO BLIND RECURITMENT
# 무지의 먹방 라이브
# 다시 풀기
def solution(food_times, k):
    i = 0
    sec = 1
    food_times = [1,2,3,4,5]
    while sec <= k:
        i = i%k
        if food_times[i] == 0:
            i += 1
            continue
        else:
            food_times[i] -= 1
        sec += 1
        i += 1
    i = i % k
    for j in range(i,len(food_times)):
        if food_times[j] != 0:
            return i+1
    else:
         return -1   