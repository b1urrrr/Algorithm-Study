n, m = map(int, input().split())

set_A = []
set_B = []

set_A = set(map(int, input().split()))
set_B = set(map(int, input().split()))
      
res = len(set_A - set_B) + len(set_B - set_A)
print(res)
