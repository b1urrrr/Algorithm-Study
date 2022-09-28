n = input()
li_a = list()
num = [str(i) for i in range(0,10)]
li_n= list()

for i in n:
    if i in num:
        li_n.append(i)
    else:
        li_a.append(i)
        
li_a = sorted(li_a)
n_sum = sum(int(i) for i in li_n)
res = ''
for i in li_a:
    res += i
print(res + str(n_sum))