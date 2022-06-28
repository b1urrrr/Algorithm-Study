# 정렬
# 레벨2: 가장 큰 수

# 53점
def solution(numbers):
    numbers = [str(num) for num in numbers]
    numbers = sorted(numbers, key = lambda x:(x[0],x[-1]),reverse=True) # 같은 인덱스의 값이 같으면 그 다음 인덱스를 
                                                                        # 비교하게 하고 싶은데 고민중
    #print(numbers)
    return "".join(num for num in numbers)


# 다른 사람 풀이
def solution(numbers):
    numbers = [str(num) for num in numbers]
    numbers = sorted(numbers, key = lambda x:x*3,reverse=True) # 1000이하의 숫자가 입력되므로
    # *3을 해서 비교해준다. 문자열은 인덱스 0부터 하나씩 비교를 하여 정렬하므로 9, 34, 30, 3이란 수가 있으면 
    # reverse=True일 경우, 999, 343434, 303030, 333으로 바뀌어 9, 34, 3, 30 으로 정렬하게 된다.
    return str(int("".join(num for num in numbers)))
    
    