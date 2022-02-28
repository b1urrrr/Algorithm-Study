# 리스트에서 임의의 원솟값을 업데이트하기

def change(lst, idx, val):
    lst[idx] = val
    
x = [11, 22, 33, 44, 55]
print('x= ', x)

index = int(input('업데이트할 인덱스를 선택하세요: '))
value = int(input('새로운 값을 입력하세요: '))

change(x, index, value)
print(f'x = {x}')