# 구현, 시뮬레이션
# 23881번: 알고리즘 수업 - 선택 정렬 1

n, k = map(int, input().split())
li = list(map(int, input().split()))

cnt = 0
result = -1
def selection_sort(li):
    global cnt, result 

    for i in range(n-1, 0, -1):
        max_i = li[0]
        index = 0 
        for j in range(1, i+1):
            max_i, index = li[j], j
        
        if li[i] != li[index]:
            li[i], li[index] = li[index], li[i]
            cnt += 1
        
        if cnt == k:
            result = f'{li[index]} {li[i]}'
    
    return result

print(selection_sort(li))