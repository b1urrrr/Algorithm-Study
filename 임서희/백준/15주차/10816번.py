# 틀림: 다시 풀기
def binary_search(array, target, start, end):
    total = 0
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            total += 1
            left = mid - 1
            right = mid + 1
            while array[left] == target and left != 0:
                total += 1
                left -= 1
            while array[right] == target and right != len(array)-1:
                total += 1
                right += 1
            return total
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

#n = int(input())
#array = list(map(int,input().split()))
#m = int(input())
#find_array = list(map(int,input().split()))

n = 10
array =[6, 3, 2, 10, 10, 10, -10, -10, 7, 3]
m = 8
find_array = [2, 3, 4, 5, -10]

for target in find_array:
    print(binary_search(array, target, 0, n-1))