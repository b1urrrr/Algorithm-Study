# pypy3 코드로 제출해야 함
# 힙 정렬 heapq 모듈 이용
# 시간 복잡도 O(nlogn)
import heapq

N = int(input())
heap = []

for _ in range(N):
    i = int(input())
    heapq.heappush(heap, i)
for i in range(len(heap)):
    print(heapq.heappop(heap))


# 힙 정렬
def heap_sort(a):
    def down_heap(a, left, right):
        temp = a[left]
        parent = left
        while parent<(right+1)//2:
            cl = parent * 2 + 1
            cr = cl + 1
            child = cr if cr <= right and a[cr] > a[cl] else cl
            if temp >= a[child]:
                break
            a[parent] = a[child]
            parent = child
        a[parent] = temp
    n = len(a)
    for i in range((n-1)//2, -1, -1):
        down_heap(a,i,n-1)
    for i in range(n-1,0,-1):
        a[0],a[i] = a[i],a[0]
        down_heap(a,0,i-1)
        
N = int(input())
x = [None] * N

for i in range(N):
    x[i] = int(input())

heap_sort(x)

for i in range(N):
    print(x[i])    