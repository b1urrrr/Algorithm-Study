# 정렬
# 걸린 시간: 12분
def solution(array, commands):
    answer = []
    for a in range(len(commands)):
        i = commands[a][0]
        j = commands[a][1]
        k = commands[a][2]
        l = array[i-1:j]
        l.sort()
        result = l[k-1]
        answer.append(result)
    return answer