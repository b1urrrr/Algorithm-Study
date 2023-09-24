# Summer/Winter Coding(2019)
# 레벨2: 멀쩡한 사각형
# 무슨 규칙인지 몰라서 질문하기에 있는 접근 방법을 보긴 했음
def solution(w,h):
    total = w * h
    w_h = w+h
    # 최대공약수: 유클리드 호제법
    while h!=0:
        w,h = h, w%h
    return total-(w_h-w)
    