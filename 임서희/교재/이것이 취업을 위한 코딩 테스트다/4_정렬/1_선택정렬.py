# 선택 정렬
# 데이터가 무작위로 여러 개 있을 때, 가장 작은 데이터를 선택해서 맨 앞에 있는 데이터와 바꾸는 것을 반복
# 즉, 매번 '가장 작은 것을 선택'하여 바꾸기 때문에 선택 정렬이라고 한다.

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i # 앞 원소 위치
    for j in range(i+1, len(array)): 
        if array[min_index] > array[j]:
            min_index = j # 가장 작은 원소의 인덱스 찾기
    array[i], array[min_index] = array[min_index], array[i] # 스와프(바꾸기)

print(array)