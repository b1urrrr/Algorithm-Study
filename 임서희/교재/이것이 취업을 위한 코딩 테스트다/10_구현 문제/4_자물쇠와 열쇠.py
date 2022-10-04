def rotate(array, d):
    n = len(array)  # 배열의 길이
    result = [[0] * n for _ in range(n)]

    if d % 4 == 1:
        for r in range(n):
            for c in range(n):
                result[c][n - r - 1] = array[r][c]
    elif d % 4 == 2:
        for r in range(n):
            for c in range(n):
                result[n - r - 1][n - c - 1] = array[r][c]
    elif d % 4 == 3:
        for r in range(n):
            for c in range(n):
                result[n - c - 1][r] = array[r][c]
    else:
        for r in range(n):
            for c in range(n):
                result[r][c] = array[r][c]

    return result

def check(new_lock):
    n = len(new_lock) // 3
    for i in range(n, n * 2):
        for j in range(n, n * 2):
            if new_lock[i][j] != 1:
                return False
    return True


def solution(key, lock):
    m = len(key)
    n = len(lock)
    new_lock = [[0] * (n * 3) for _ in range(n * 3)]
    for i in range(n):
        for j in range(n):
            new_lock[n + i][n + j] = lock[i][j]

    for i in range(1, n * 2):
        for j in range(1, n * 2):
            for d in range(4):
                r_key = rotate(key, d)
                for x in range(m):
                    for y in range(m):
                        new_lock[i + x][j + y] += r_key[x][y]

                if check(new_lock):
                    return True

                for x in range(m):
                    for y in range(m):
                        new_lock[i + x][j + y] -= r_key[x][y]

    return False