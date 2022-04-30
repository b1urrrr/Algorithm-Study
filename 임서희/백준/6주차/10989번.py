# 메모리 초과 (힙 정렬도 똑같이 메모리 초과)
import sys

N = int(sys.stdin.readline())
a = []

for i in range(N):
    s = int(sys.stdin.readline())
    a.append(s) # append 함수를 쓰면 메모리 재할당이 되어서 효율적 X
a.sort()
for i in range(len(a)):
    print(a[i])

# 다른 사람 코드
# 카운팅 정렬 이용
# 메모리 초과 X

N = int(sys.stdin.readline())
a = [0] * 10001 # 미리 10001개 원소가 있도록 초기화

for i in range(N):
    a[int(sys.stdin.readline())] += 1 # 입력받은 값을 인덱스 번호로

for i in range(10001): # 0~10000 인덱스 돌기
    if a[i] != 0: # 0이 아니라면 해당 입력이 1번 이상 들어온 것
        for j in range(a[i]): # 해당 입력이 몇 번 들어왔느냐에 따라서
            print(i) # 그 개수만큼 print