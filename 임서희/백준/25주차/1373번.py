# 수학, 문자열
# 1373번: 2진수 8진수

n_8 = input()
n = list()
append_str = ''
if len(n_8) %3 == 2:
    n.append('0'+n_8[:2])
    for i in range(2,len(n_8)):
        append_str += n_8[i]
        if len(append_str) == 3:
            n.append(append_str)
            append_str = ''
elif len(n_8) %3 == 1:
    n.append('00'+n_8[:1])
    for i in range(1,len(n_8)):
        append_str += n_8[i]
        if len(append_str) == 3:
            n.append(append_str)
            append_str = ''
else:
    for i in range(len(n_8)):
        append_str += n_8[i]
        if len(append_str) == 3:
            n.append(append_str)
            append_str = ''
n_2 = [1, 2, 4]
res = ''
for i in n:
    i_sum = 0
    k = 0
    for j in i[::-1]:
        i_sum += int(j)*n_2[k]
        k+=1
    res += str(i_sum)
print(int(res))

# 진수 변환 함수 이용하는 더 짧은 코드
x = int(input(), 2)
print(format(x, 'o'))