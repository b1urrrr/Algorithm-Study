alpa = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
s = input()

for i in alpa:
    s = s.replace(i, '*')  # s에 있는 alpa 원소를 *로 대체
print(len(s))
