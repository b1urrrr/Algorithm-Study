n, l = map(int, input().split())
arr = list(map(int, input().split()))

arr.sort()

# 테이프를 붙이는 시작점
start = arr[0]
cnt = 1

for i in range(1, n):
    # 테이프를 붙이는 끝점
    end = arr[i] - 0.5

    # 테이프를 붙이는 시작점과 끝점 사이에 테이프를 붙일 수 없다면
    if start + l - 1 < end:
        # 테이프를 붙이는 시작점을 현재 위치로 바꾸고
        start = arr[i]
        # 테이프 개수를 1개 더한다.
        cnt += 1

print(cnt)