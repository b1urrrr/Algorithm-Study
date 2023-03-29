# 백준 10809
s = input()

# 아스키 코드 이용
alphabet = list(range(97, 123))

for i in alphabet:
    print(s.find(chr(i)))