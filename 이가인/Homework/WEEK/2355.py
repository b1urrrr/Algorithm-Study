A, B = map(int, input().split())

Max = max(A, B)
Min = min(A, B)

sum = (Max + Min) * (Max - Min + 1 ) / 2
print(int(sum))

