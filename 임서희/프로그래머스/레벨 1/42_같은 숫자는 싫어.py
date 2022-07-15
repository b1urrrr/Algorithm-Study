# 스택/큐
# 레벨1: 같은 숫자는 싫어
# 걸린 시간: 5분
def solution(arr):
    stack = [-1]
    k = 0
    for i in arr:
        if stack[k] != i:
            stack.append(i)
            k+=1
    return stack[1:]

# 다른 사람 코드
def no_continuous(s):
    a = []
    for i in s:
        if a[-1:] == [i]: continue
        a.append(i)
    return a