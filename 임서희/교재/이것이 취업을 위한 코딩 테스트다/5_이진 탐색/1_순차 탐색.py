# 순차 탐색
# 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법

def sequential_search(n, target, array):
	for i in range(n):
		if array[i] == target:
				return i + 1
print("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요: " )
input_data = input().split()
n = int(input_data[0])
target = input_data[1]

print("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.")
array = input().split()

print(sequential_search(n, target, array))