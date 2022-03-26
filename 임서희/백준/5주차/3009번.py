# 틀린 내 코드
x1,y1 = map(int,input().split())
x2,y2 = map(int,input().split())
x3,y3 = map(int,input().split())

if x1 == x2:
    if y1 == y3:
        print(f'{x3} {y2}')
    elif y2 == y3:
        print(f'{x3} {y1}')
elif x2 == x3:
    if y1 == y3:
        print(f'{x1} {y2}')
    elif y2 == y3:
        print(f'{x1} {y1}')
elif x1 == x3:
    if y1 == y3:
        print(f'{x2} {y2}')
    elif y2 == y3:
        print(f'{x2} {y1}')

# 다른 코드
x_list = []
y_list = []

for i in range(3):
    x, y = map(int, input().split())
    x_list.append(x)
    y_list.append(y)

for i in range(3):
    if x_list.count(x_list[i]) == 1: # 한 번만 나온게 새로운 점
        x4 = x_list[i]
    if y_list.count(y_list[i]) == 1:
        y4 = y_list[i]
        
print(x4, y4)