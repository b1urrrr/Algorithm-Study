# 그리디 알고리즘, 정렬
# 2217번: 로프
# 문제 접근 방식을 잘 모르겠어서 다른 사람 코드 참고
# 다시 풀어보기
n = int(input())
rope = []
value = []
for i in range(N):
    rope.append(int(input()))
rope = sorted(rope, reverse=True)
for num in range(n):
    value.append(rope[num]*(num+1))
print(max(value))