from bisect import bisect_left, bisect_right

def count_by_range(a, left_value, right_value):
    right_i = bisect_right(a, right_value)
    left_i = bisect_left(a,left_value)
    return right_i - left_i

array = [[]for _ in range(10001)]
revsered = [[] for _ in range(10001)]

def solution(words, q):
    answer = []
    for word in words:
        array[len(word)].append(word)
        reversed[len(word)].append(word[::-1])
    for i in range(10001):
        array[i].sort()
        reversed[i].sort()
    
    for k in q:
        if k[0] != '?':
            res = count_by_range(array[len(k)], k.replace('?','a'), k.replace('?','z'))
        else:
            res = count_by_range(reversed[len(k)], k[::-1].replace('?','a'), k[::-1].replace('?','z'))
            answer.append(res)
        return answer