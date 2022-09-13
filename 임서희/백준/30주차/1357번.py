# 구현, 문자열
# 1357번: 뒤집힌 덧셈
n, m = map(int, input().split())
res = str(int(n[::-1])+int(m[::-1]))
print(int(res[::-1]))