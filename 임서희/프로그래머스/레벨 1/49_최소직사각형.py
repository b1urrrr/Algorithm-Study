# 완전 탐색
# 레벨1: 최소 직사각형
# 틀려서 다시 풀기
def solution(sizes):
    w_sizes = sorted(sizes, key=lambda x: (x[0], x[1]))
    h_sizes = sorted(sizes, key=lambda x: (x[1], x[0]))
    print(w_sizes)
    print(h_sizes)
    max_w = sizes[-1][0]
    print(max_w)
    answer = 0
    return answer