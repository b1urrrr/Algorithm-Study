# 이진 탐색
# 1072번: 게임

X, Y = map(int, input().split())
Z = 100 * Y // X 

left = 1
right = 1000000000
res = -1

while left <= right:
    # mid -> 추가로 진행하는 게임 수
    mid = (left + right) // 2
        
    nx = X + mid
    ny = Y + mid
    nz = ny * 100 // nx

    # 승률이 변경되면 범위를 줄여서 더 작은 추가 게임 수를 찾는다.
    if Z != nz:
        right = mid - 1
        res = mid
    else:
        left = mid + 1
    
print(res)