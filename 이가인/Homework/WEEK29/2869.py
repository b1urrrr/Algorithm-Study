import math
a, b, v = map(int, input().split())

k = v #남은 거리
day = (v-b) / (a-b)
print(math.ceil(day))