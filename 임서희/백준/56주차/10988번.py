# 구현
# 10988번: 팰린드롬인지 확인
i = input()
if i == i[::-1]:
    print(1)
else:
    print(0)