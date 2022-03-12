A, B = input().split()

A = int(A[2] + A[1] + A[0])  # 역순: int(A[::-1])
B = int(B[2] + B[1] + B[0])

print(max(A, B))
