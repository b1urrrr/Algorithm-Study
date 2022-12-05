# 23881번
# 지난 주차 때 풀지 못한 23881번 해답
# 배열 A의 크기 N, 교환 횟수 K
# 배열 A의 원소 중 가장 큰 값을 max_item 변수에 저장
# max_item이 가장 마지막 원소가 아닐 경우, 마지막 원소와 자리를 교환한 뒤 cnt에 1을 더함
# 정렬된 값을 제외한 배열에서 위의 과정을 반복
# cnt의 값이 K가 되었을 때, answer의 값을 arr[i], max_item으로 포매팅한다.
import sys

n, k = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
cnt = 0
answer = -1

def selection(arr):
	global cnt, answer

	for i in range(n-1, 0, -1):
		max_item, idx = arr[0], 0
		for j in range(1, i+1):
			if arr[j] > max_item:
				max_item, idx = arr[j], j

		if arr[i] != arr[idx]:
			arr[i], arr[idx] = arr[idx], arr[i]
			cnt += 1

		if cnt == k:
			answer = f'{arr[idx]} {arr[i]}'

	return answer
		
print(selection(arr))