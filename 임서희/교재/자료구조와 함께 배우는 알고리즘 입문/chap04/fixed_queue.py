# 고정 길이 큐 클래스 FixedQueue 구현하기

from typing import Any


class FixedQueue:
    class Empty(Exception):
        # 비어 있는 FixedQueue에서 디큐 또는 피크할 때 내보내는 예외 처리
        pass

    class Full(Exception):
        # 가득 차 있는 FixedQueue에서 인큐할 때 내보내는 예외 처리
        pass

    def __init__(self, capacity: int) -> None:
        # 큐 초기화
        self.no = 0  # 현재 데이터 개수
        self.front = 0
        self.rear = 0
        self.capacity = capacity  # 큐의 크기
        self.que = [None] * capacity  # 큐의 본체

    def __len__(self) -> int:
        # 큐에 있는 데이터 개수 반환
        return self.no

    def is_empty(self) -> bool:
        return self.no <= 0

    def is_full(self) -> bool:
        return self.no >= self.capacity

    def enque(self, x: Any) -> None:
        # 데이터 x 인큐
        if self.is_full():
            raise FixedQueue.Full  # 큐가 가득 차 있을 때 예외 처리
        self.que[self.rear] = x
        self.rear += 1
        self.no += 1
        if self.rear == self.capacity:  # capacity와 rear가 같으면 다시 배열의 맨 앞 인덱스 0으로 되돌린다
            self.rear = 0  # 그러면 다음에 인큐하는 데이터는 que[0]에 위치에 저장된다.

    def deque(self) -> Any:
        if self.is_empty():
            raise FixedQueue.Empty  # 큐가 비어 있을 때 예외 처리
        x = self.que[self.front]
        self. front += 1
        self.no -= 1
        if self.front == self.capacity:  # capacity와 front가 같으면 배열의 한계를 넘어가게 된다
            # 그러므로 front을 0으로 되돌린다. 이렇게 하면 다음 디큐를 할 때 que[0] 위치에서 꺼낼 수 있다.
            self.front = 0
        return x

    def peek(self) -> Any:
        # 큐에서 데이터 피크(맨 앞 데이터를 들여다봄)
        if self.is_empty():
            raise FixedQueue.Empty
        return self.que[self.front]

    def find(self, value: Any) -> Any:
        # 큐에서 value를 찾아 인덱스 반환(없으면 -1 반환)
        for i in range(self.no):
            idx = (i + self.front) % self.capacity
            if self.que[idx] == value:
                return idx  # 검색 성공
        return -1  # 실패

    def count(self, value: Any) -> int:
        # 큐에 있는 value 개수 반환
        c = 0
        for i in range(self.no):  # 큐 데이터 선형 검색
            idx = (i + self.front) % self.capacity
            if self.que[idx] == value:  # 검색 성공
                c += 1  # 들어 있음
        return c

    def __contains__(self, value: Any) -> bool:
        # 큐에 value가 있는지 판단
        return self.count(value)

    def clear(self) -> None:
        self.no = self.front = self.rear = 0

    def dump(self) -> None:
        # 모든 데이터를 맨 앞부터 맨 끝 순으로 출력
        if self.is_empty():
            print('큐가 비었습니다.')
        else:
            for i in range(self.no):
                print(self.que[(i+self.front) % self.capacity], end='')
            print()
