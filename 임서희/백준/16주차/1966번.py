# 큐
# 1966번: 프린터 큐
# 다시 풀기
from collections import deque
T= int(input())

for _ in range(T):
    cnt = 0 # 몇번째인지
    n, m = map(int,input().split()) #n: 문서개수, m:현재 궁금한 문서가 몇번째인지
    data = list(map(int, input().split()))
    major = deque()
    for k in data:
        major.append(k)
    find = major[m] # 궁금한 문서의 중요도
    i = 0
    a = -1
    while True:
        if major[i] < max(major):
            major.append(major.popleft())
        else:
            a = major.popleft()
            cnt += 1
        if a == find:
            break
        else:
            i += 1
            i = i % n
    print(cnt)
