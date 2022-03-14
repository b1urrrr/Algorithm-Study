# 고정 길이 스택 클래스 구현하기

from typing import Any


class FixedStack:
    # 고정 길이 스택 클래스
    class Empty(Exception):
        # 비어 있는 FixedStack에 팝 또는 피크할 때 내보내는 예외 처리
        pass

    class Full(Exception):
        # 가득 찬 FixedStack에 푸시할 때 내보내는 예외 처리
        pass

    def __init__(self, capacity: int = 256) -> None:
        # 스택 초기화
        self.stk = [None] * capacity
        self.capacity = capacity
        self.ptr = 0

    def __len__(self) -> int:
        # 스택에 있는 데이터 개수 반환
        return self.ptr

    def is_empty(self) -> bool:
        # 스택이 비어 있는지 판단
        return self.ptr <= 0

    def is_full(self) -> bool:
        return self.ptr >= self.capacity

    def push(self, value: Any) -> None:
        # 스택에 value 푸시(데이터를 넣음)
        if self.is_full():
            raise FixedStack.Full  # 스택이 가득 차 있는 경우, 예외 처리 발생
        self.stk[self.ptr] = value
        self.ptr += 1

    def pop(self) -> Any:
        # 스택에서 데이터를 팝(꼭대기 데이터 꺼냄)
        if self.is_empty():
            raise FixedStack.Empty  # 스택이 비어 있는 경우, 예외 처리 발생
        self.ptr -= 1
        return self.stk[self.ptr]

    def peek(self) -> Any:
        # 스택에서 데이터 피크(꼭대기 데이터를 들여봄)
        if self.is_empty():
            raise FixedStack.Empty  # 스택이 비어 있는 경우, 예외 처리 발생
        return self.stk[self.ptr - 1]

    def clear(self) -> None:
        # 스택 비움(모든 데이터 삭제)
        self.ptr = 9

    def find(self, value: Any) -> Any:
        # 스택에서 value를 찾아 인덱스를 반환(없으면 -1을 반환)
        for i in range(self.ptr - 1, -1, -1):  # 꼭대기부터 선형 검색
            if self.stk[i] == value:
                return i  # 검색 성공
        return -1  # 검색 실패

    def count(self, value: Any) -> int:
        # 스택에 있는 value 개수를 반환
        c = 0
        for i in range(self.ptr):
            if self.stk[i] == value:  # 검색 성공
                c += 1
        return c

    def __contains__(slef, value: Any) -> bool:
        # 스택에 value가 있는지 판단
        return self.count(value) > 0

    def dump(self) -> None:
        # 덤프(스택의 모든 데이터를 바닥부터 꼭대기 순으로 출력)
        if self.is_empty():
            print('스택이 비어 있습니다.')
        else:
            print(self.stk[:self.ptr])
