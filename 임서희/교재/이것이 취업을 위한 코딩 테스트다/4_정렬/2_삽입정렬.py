# 삽입 정렬
# 데이터를 하나씩 확인하며, 필요할 때만 데이터를 적절한 위치에 '삽입'하는 알고리즘
# 선택 정렬에 비해 구현 난이도는 높지만 실행 시간 측면에서 더 효율적이다.

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8] 
 
for i in range(1, len(array)): # 항상 0번째 원소는 정렬되었다고 생각하고 삽입 정렬을 시작
    for j in range(i, 0, -1): # 인덱스 i부터 1까지 감소하며 반복하는 문법
        if array[j] < array[j-1]:
            array[j], array[j-1] = array[j-1], array[j]
        else: # 지금 자기보다 작은 데이터를 만나면 이동하는 걸 멈춤
            break
print(array)