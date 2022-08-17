# 10815번: 숫자 카드
# 이진 탐색 문제
import sys

def binary_search(element, some_list, start=0, end=None):
    if end == None:
        end = len(some_list) - 1
    if start > end:
        return 0

    mid = (start + end) // 2

    if element == some_list[mid]:
        return 1
    elif element < some_list[mid]:
        end = mid - 1
    elif element > some_list[mid]:
        start = mid + 1
    
    return binary_search(element, some_list, start, end)


n = int(sys.stdin.readline())
n_list = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
m_list = list(map(int, sys.stdin.readline().split()))

sorted_list = sorted(n_list)

answer_list = []

for i in range(len(m_list)):
    answer_list.append(binary_search(m_list[i], sorted_list))

answer = " ".join(map(str, answer_list))
print(answer)