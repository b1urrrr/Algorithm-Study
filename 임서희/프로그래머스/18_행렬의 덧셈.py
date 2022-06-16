# 연습문제
# 레벨1: 행렬의 덧셈
def solution(arr1, arr2):
    for i in range(len(arr1)):
        for k in range(len(arr1[i])):
            arr1[i][k] += arr2[i][k]
    return arr1

# 다른 사람 코드
def sumMatrix(A,B):
    answer = [[c + d for c, d in zip(a, b)] for a, b in zip(A,B)]
    return answer

# 다른 사람 코드2
def sumMatrix(A,B):
    return [list(map(sum, zip(*x))) for x in zip(A, B)]


# 파이썬 문법
# zip() 내장 함수
number = [1,2,3]
letter = ['a','b','c']
for pair in zip(number,letter):
    print(pair)
# (1,'a')
# (2,'b')
# (3,'c')

# zip을 이용하면 여러 그룹의 데이터를 루프 한 번만 돌면서 처리할 수 있다.
# 즉, 병렬 처리가 가능하다.
for num, upper, lower in zip('1234','abcd','ABCD'):
    print(num, upper, lower)
# 1 a A
# 2 b B
# 3 c C
# 4 d D

# zip() 함수로 엮어 놓은 데이터를 다시 해체(upzip)하고 싶을 때도 zip() 함수를 사용한다.
numbers = (1,2,3)
letters = ('a','b','c')
pairs = list(zip(numbers,letters))
print(pairs) #[(1,'a'),(2,'b'),(3,'c')]

numbers, letters = zip(*pairs) # unpaking
print(numbers) # (1,2,3)
print(letters) # ('a','b','c')

# zip() 함수를 이용하면 dictionary 형태를 쉽게 만들 수도 있다.
# 키와 값을 담고 있는 리스트를 zip() 함수에 넘기고 이를 dict() 함수에 넣어주면 된다.
keys = [1,2,3]
values = ['a','b','c']
dict(zip(keys,values))
# {1:'a', 2:'b', 3:'c'}

# ﻿주의해야 할 사항은 zip() 함수로 넘기는 인자의 길이가 서로 다를 때
# 가장 짧은 인자 기준으로 데이터가 엮이고, 나머지는 버려진다는 점이다.
numbers = [1,2,3]
letters = ['a']
list(zip(numbers, letters))
# [(1,'a')]