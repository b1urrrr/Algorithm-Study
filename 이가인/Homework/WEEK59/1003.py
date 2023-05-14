import sys 

t = int(input())

for _ in range(t):
    zero_cnt = [1, 0]
    one_cnt = [0, 1]
    n = int(sys.stdin.readline())
    if (n > 1):
        for i in range(n-1):
            zero_cnt.append(one_cnt[-1])
            one_cnt.append(zero_cnt[-2] + one_cnt[-1])
    print(zero_cnt[n], one_cnt[n])