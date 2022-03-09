# while문으로 작성한 선형 검색 알고리즘

from re import I
from typing import Any, Sequence


def seq_serch(a: Sequence, key: Any) -> int:
    # 시퀀스 a에서 key와 값이 같은 숸소를 선형 검색(while)
    i = 0

    while True:
        if i == len(a):
            return -1
        if a[i] == key:
            return i
        i += 1


if __name__ == '__main__':
    num = int(input('원소 수를 입력하세요: '))
    x = [None] * num

    for i in range(num):
        x[i] = int(input(f'x[{i}]: '))

    ky = int(input('검색할 값을 입력하세요: '))

    idx = seq_serch(x, ky)

    if idx == -1:
        print('검색값을 갖는 원소가 존재하지 않습니다.')
    else:
        print(f'검색값은 x[{idx}]에 있습니다.')
