# 가로, 세로 길이가 정수이고 넓이가 area인 직사각형에서 변의 길이 나열하기

area = int(input('직사각형의 넓이를 입력하세요: '))

# 1부터 사각형 넓이 계산
for i in range(1, area+1):
    if i*i > area:
        break
    if area % i:
        continue
    print(f'{i} x {area // i}')