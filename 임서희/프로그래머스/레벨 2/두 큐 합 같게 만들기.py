# 일부 정답 (수정필요!)
from collections import deque
import copy

global que1, que2 # 원본 큐
global res
res = 1e9

def dfs(q1, q2, cnt):
    if cnt == -1:
        cnt = -1
        return -1
    if len(q1) < 1 or len(q2) < 1:
        cnt = -1
        return -1
    if sum(q1) == sum(q2):
        global res
        if res > cnt:
            res = cnt
        return cnt
    if q2 == que1 and q1 == que2:
        return -1
    if cnt > len(que1) * 2:
        return -1

    qa1, qa2 = copy.deepcopy(q1), copy.deepcopy(q2)
    qa2.append(qa1.pop(0))

    qb1, qb2 = copy.deepcopy(q1), copy.deepcopy(q2)
    qb1.append(qb2.pop(0))

    cnt += 1
    dfs(qa1, qa2, cnt)
    dfs(qb1, qb2, cnt)
    
def solution(queue1, queue2):
    global que1, que2, res
    que1, que2 = queue1, queue2
    cnt = 0

    dfs(queue1, queue2, cnt)
    
    return res if res != 1e9 else -1
