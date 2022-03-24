x,y,w,h = map(int, input().split())

print(min(abs(x-0),abs(x-w),abs(y-0),abs(y-h)))
# pirnt(min(x,y,w-x,h-y)) 와 동일