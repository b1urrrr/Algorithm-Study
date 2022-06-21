# 10815번: 숫자 카드

# 이진 탐색 이용
n = int(input())
n_list = list(map(int, input().split()))
n_list.sort()
m = int(input())
m_list = list(map(int, input().split()))

def binary_search(l, find, start, end):
    if start > end:
        return None
    mid = (start+end)//2
    if l[mid] == find:
        return mid
    elif l[mid] > find:
        return binary_search(l, find, start, mid-1)
    else:
        return binary_search(l, find, mid+1, end)

result = []
for i in m_list:
    find = binary_search(n_list, i, 0, n-1)
    if find == None:
        result.append(0)
    else:
        result.append(1)

for i in result:
    print(i, end=' ')