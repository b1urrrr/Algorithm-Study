from typing import Any, Sequence
import copy

def seq_search(seq: Sequence, key: Any) -> int:
    # 시퀀스 seq에서 key와 일치하는 원소를 선형 검색(보초법)
    a = copy.deepcopy(seq) # seq 복사
    a.append(key) # 보초 key 추가

    i = 0
    while True:
        if a[i] == key:
            break
        i += 1
    return -1 if i == len(seq) else 1

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