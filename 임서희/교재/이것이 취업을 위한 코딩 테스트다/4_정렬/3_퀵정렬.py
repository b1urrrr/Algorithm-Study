# 퀵 정렬
# 피벗을 설정하여 작은 데이터와 큰 데이터를 서로 교환해주는 과정을 반복하며 정렬하는 알고리즘

# 직관적인 형태의 퀵 정렬 소스코드
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end: # 원소가 1개인 경우 종료
        return 
    pivot = start # 피벗은 첫 번째 원소로 지정
    left = start + 1
    right = end
    while left <= right:
        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # 피벗보다 작은 데이터를 찾을 때까지 반복
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right: # 엇갈리면 작은 데이터와 피벗 교체
            array[right], array[pivot] = array[pivot], array[right]
        else: # 엇갈리지 않으면 작은 데이터와 큰 데이터끼리 교체
            array[left], array[right] = array[right], array[left]
    quick_sort(array, start, right-1)
    quick_sort(array, right+1, end)

quick_sort(array, 0, len(array)-1)
print(array)

# 시간적인 측면에서 조금 비효율적이지만, 파이썬의 장점을 살려 짧게 작성하고 직관적인 소스코드
array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort2(array):
    # 리스트가 하나 이하의 원소만 담고 있으면 종료
    if len(array) <= 1:
        return array
    pivot = array[0] # 피벗은 첫 번째 원소
    tail = array[1:] # 피벗을 제외한 리스트

    left_side = [x for x in tail if x <= pivot] # 분할된 왼쪽 부분
    right_side = [x for x in tail if x > pivot] # 분할된 오른쪽 부분

    return quick_sort2(left_side) + [pivot] + quick_sort2(right_side)

print(quick_sort2(array))