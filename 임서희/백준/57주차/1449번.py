# 정렬
# 1449번: 수리공 항승
n, l = map(int, input().split())
li = list(map(int, input().split()))

li.sort()

cnt = 0

tape = 0 # 마지막으로 막은 위치
for p in li:
    # 구멍이 난 곳에 테이프를 붙이는데
    if tape < p: # 이미 테이프가 붙어 있으면 넘어감
        cnt += 1
        tape = p + l - 1 # 테이프가 붙은 마지막 위치는 구멍난 위치에 테이프 길이 - 1

print(cnt)