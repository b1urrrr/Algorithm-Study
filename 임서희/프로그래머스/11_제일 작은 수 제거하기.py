# 연습 문제
# 레벨1: 제일 작은 수 제거하기
def solution(arr):
    arr.pop(arr.index(min(arr)))
    if len(arr) == 0:
        arr.append(-1)
    return arr

# 다른 사람 코드
def solution(arr):
    answer = []
    if len(arr) == 1:
        answer.append(-1)
    else:
        answer = arr
        answer.remove(min(answer))
    return answer