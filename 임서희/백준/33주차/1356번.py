# 사칙연산, 수학
# 1356번: 유진선
n = input()
n_len = len(n)
true = 0
for i in range(n_len - 1):
    left = 1
    right = 1
    for j in range(i + 1):
        left *= int(n[j])
    for k in range(i + 1, n_len):
        right *= int(n[k])
    if left == right:
        print("YES")
        true = 1
        break
if true == 0:
    print("NO")