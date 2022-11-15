from collections import deque

def get_next_pos(pos, b):
    next_pos = []
    pos = list(pos)

    pos1_x, pos1_y, pos2_x, pos2_y = pos[0][0], pos[0][1], pos[1][0], pos[1][1]
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        pos1_next_x, pos1_next_y, pos2_next_x, pos2_next_y = pos1_x + dx[i], pos1_y + dy[i], pos2_x + dx[i], pos2_y + dy[i]
        if b[pos1_next_x][pos1_next_y] == 0 and b[pos2_next_x][pos2_next_y] == 0:
            next_pos.append({(pos1_next_x, pos1_next_y),(pos2_next_x, pos2_next_y)})
    if pos1_x == pos2_x:
        for i in [-1,1]:
            if b[pos1_x +i][pos1_y] == 0 and b[pos2_x +i][pos2_y] == 0:
                next_pos.append({(pos1_x,pos1_y), (pos1_x +i, pos1_y)})
                next_pos.append({(pos2_x, pos2_y), (pos2_x + i, pos2_y)})
    elif pos1_y == pos2_y:
        for i in [-1,1]:
            if b[pos1_x][pos1_y +i] == 0 and b[pos2_x][pos2_y + i] == 0:
                next_pos.append({(pos1_x,pos1_y), (pos1_x,pos1_y + i)})
                next_pos.append({(pos2_x, pos2_y), (pos2_x, pos2_y +i)})
    return next_pos

def solution(b):
    n = len(b)
    new_b = [[1]*(n+2) for _ in range(n+2)]
    for i in range(n):
        for j in range(n):
            new_b[i+1][j+1] = b[i][j]
    q =deque()
    visited = []
    pos = {(1,1), (1,2)}
    q.append((pos,0))
    visited.append(pos)
    while q:
        pos, cost = q.popleft()
        if (n,n) in pos:
            return cost
        for next_pos in get_next_pos(pos, new_b):
            if next_pos not in visited:
                q.append((next_pos, cost+1))
                visited.append(next_pos)
    return 0 