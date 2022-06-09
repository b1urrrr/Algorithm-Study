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

# 주의하기
# pop 사용하면 인덱스가 바뀐다는 것!
T= int(input())

for _ in range(T):
    n, m = map(int,input().split()) #n: 문서개수, m:현재 궁금한 문서가 몇번째인지
    major = list(map(int, input().split()))
    major_where = [0 for i in range(n)] # 위치 저장용 리스트
    major_where[m] = 1 # 찾으려는 것만 1로 초기화

    cnt = 0
    while True:
        if major[0] == max(major):
            cnt += 1
            if major_where[0] == 1: # 중요도가 최대값이면서 우리가 찾으려는 인덱스면 cnt 출력후 break
                print(cnt)
                break
            else:
                major.pop(0) # 중요도만 제일 크고 우리가 찾는 인덱스가 아니면 pop만
                major_where.pop(0)
        else:
            major.append(major.pop(0))
            major_where.append(major_where.pop(0))