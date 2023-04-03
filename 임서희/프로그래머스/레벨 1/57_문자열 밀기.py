# 연습 문제
# 레벨: 문자열 밀기
def solution(A, B):
    for cnt in range(len(A)):
        if A == B:
            return cnt
        A = A[-1] + A[:-1]
        print(A)
    
    return -1