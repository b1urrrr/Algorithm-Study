# 시간초과 답
# from re import T
# import sys

# x = sys.stdin.readline()
# ten_num = 0
# answer = ''
# for i in range(len(x)):
#     ten_num += int(x[-1]) * (2**i)
#     x = x[:-1]

# while ten_num != 0:
#     answer += str(ten_num%8)
#     ten_num = ten_num // 8
# print(answer[::-1])

print(oct(int(input(), 2))[2:])