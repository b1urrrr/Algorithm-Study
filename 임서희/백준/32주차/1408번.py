# 수학, 구현, 사칙연산
# 1408번: 24
h1, m1, s1 = map(int, input().split(':'))
h2, m2, s2 = map(int, input().split(':'))
t = h2*3600+m2*60+s2 - (h1*3600+m1*60+s1)
if t < 0:
    t += 60*60*24
h = t//3600 
m = (t%3600)//60 
s = t%60
print("%02d:%02d:%02d" % (h,m,s))