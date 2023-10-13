# dfs/bfs
def dfs(array, sum, i, target):
    if i == length:
        if sum == target:
            global result
            result += 1
        return
    
    dfs(array, sum + array[i], i+1, target)
    dfs(array, sum - array[i], i+1, target)
    

def solution(numbers, target):
    answer = 0
    
    global length, result
    result = 0
    length = len(numbers)
    
    dfs(numbers, 0, 0, target)

    return result