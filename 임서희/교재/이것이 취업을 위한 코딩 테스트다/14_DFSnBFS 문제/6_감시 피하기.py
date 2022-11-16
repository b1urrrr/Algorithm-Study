from itertools import combinations

n = int(input())
b = []
teachers = []
spaces = []

for i in range(n):
    b.append(list(input().split()))
    for j in range(n):
        if b[i][j] == 'T':
            teachers.append((i, j))
        if b[i][j] == 'X':
            spaces.append((i,j))

def watch(x,y,directon):
    if directon == 0:
        while y >= 0:
            if b[x][y] == 'S':
                return True
            if b[x][y] == '0':
                return False
            y -= 1

    if directon == 1:
        while y < n:
            if b[x][y] == 'S':
                return True
            if b[x][y] == '0':
                return False
            y += 1
    
    if directon == 2:
        while x >= 0:
            if b[x][y] == 'S':
                return True
            if b[x][y] == '0':
                return False
            x -= 1
    
    if directon == 3:
        while x < n:
            if b[x][y] == 'S':
                return True
            if b[x][y] == '0':
                return False
            x += 1
    return False

def process():
    for x, y in teachers:
        for i in range(4):
            if watch(x,y,i):
                return True
    return False

find = False

for data in combinations(spaces, 3):
    for x, y in data:
        b[x][y] = '0'
    if not process():
        find = True
        break
    for x, y in data:
        b[x][y] = 'X'
if find:
    print('YES')
else:
    print('NO')