# 구현
# 1076번: 저항
a = {
     "black": 0,
     "brown": 1,
     "red": 2,
     "orange": 3,
     "yellow": 4,
     "green": 5,
     "blue": 6,
     "violet": 7,
     "grey": 8,
     "white":9}

result = ""
for _ in range(2):
    b = input()
    result += str(a[b])
c = input()
result += "0" * a[c]
print(int(result))