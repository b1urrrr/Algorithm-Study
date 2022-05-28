# 내 코드
from sqlalchemy import column


n = input() # 입력 예시: a1
row = int(n[1]) # 1
col_alpha = n[0] # a
column = ['','a','b','c','d','e','f','g','h']

for i in range(1,len(column)):
    if col_alpha == column[i]:
        col = i

cnt = 0

# 8가지: (2,1),(-2,1),(2,-1),(-2,-1),(1,2),(-1,2),(-1,-2),(1,-2)
# 8가지 경우가 되는지 일일이 if절을 이용하여 확인
# 비효율적
if row<=6:
    if col<8:
        cnt+=1
    if col>1:
        cnt+=1
if row>=3:
    if col<8:
        cnt+=1
    if col>1:
        cnt+=1
if col<=6:
    if row<8:
        cnt+=1
    if row>1:
        cnt+=1
if col>=3:
    if row<8:
        cnt+=1
    if row>1:
        cnt+=1

# 답안 예시
input_data = input()
row = int(input_data[1])
col = int(ord(input_data[0]-ord('a'))) + 1 # a~h의 문자값을 숫자 열값으로 바꿔줌

result = 0

steps = [(2,1),(-2,1),(2,-1),(-2,-1),(1,2),(-1,2),(-1,-2),(1,-2)] # 8가지 경우를 steps에 넣음

for step in steps:
    next_row = row+step[0]
    next_col = col+step[1]

    # 해당 위치로 이동이 되는지 next 변수를 이용하여 if절로 확인하고 가능하면 result 증가
    if 1<=next_row<=8 and 1<=next_col<=8:
        result += 1

print(result)