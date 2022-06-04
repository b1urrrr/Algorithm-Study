# 계수 정렬
# 각 데이터가 몇 번 등장했는지 횟수를 기록

# 모든 원소 값이 0보다 크거나 같다고 가정한다
array = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

# 모든 범위를 포함하는 리스트 선언
count = [0] * (max(array)+1) 

for i in range(len(array)):
    count[array[i]] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i, end = ' ') # 등장한 횟수만큼 인덱스 출력