n, w, l = map(int, input().split())
truck = list(map(int, input().split()))
bridge = [0] * w
time = 0

while truck:
    time += 1
    bridge.pop(0)
    if sum(bridge) + truck[0] <= l:
        bridge.append(truck.pop(0))
    else:
        bridge.append(0)
    
print(time + w)
    

