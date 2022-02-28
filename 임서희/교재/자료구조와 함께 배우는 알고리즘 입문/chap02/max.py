# 시퀀스 원소의 최댓값 출력하기

from typing import Any, Sequence

def max_of(a: Sequence) -> Any:
    """시퀀스형 a원소의 최댓값을 반환"""
    maximum = a[0]
    for i in range(1, len(a)):
        if a[i] > maximum:
            maximum = a[i]
        return maximum
    
if __name__ == '__main__':
    print('배열의 최댓값을 구합니다.')
    num = int(input('원소 수를 입력하세요: '))
    x = [None] * num # 원소 수가 num인 리스트 생성
    
    for i in range(num):
        x[i] = int(input(f'x[{i}]값을 입력하세요: '))
        
    print(f'최댓값은 {max_of(x)}입니다.')