# 구현, 문자열
# 1718번: 암호
text, key = input(), input()

answer = ''

for i in range(len(text)):
    if text[i] == ' ': answer += ' '
    else: answer += chr((ord(text[i]) - ord(key[i%len(key)]) - 1) % 26 + ord('a'))

print(answer)