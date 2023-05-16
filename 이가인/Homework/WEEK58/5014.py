F, S, G, U, D = map(int, input().split())
cnt = 0

if S == G:
    print("use the stairs")
elif S > G:
    # 목적지가 시작점의 아래에 있는 경우
    # U가 0이면 올라갈 수 없으므로 무조건 use the stairs
    if D == 0:
        print("use the stairs")
    # D가 0이 아니면 아래로 내려가야 하므로 
    # 목적지까지의 거리가 D로 나누어 떨어지는지 확인
    # 나누어 떨어지면 몫을 출력
    # 나누어 떨어지지 않으면 올라갔다가 내려가야 하므로
    # 목적지까지의 거리에서 U를 빼고 D로 나누어 떨어지는지 확인
    # 나누어 떨어지면 몫을 출력
    else:
        if (S - G) % D == 0:
            cnt = (S - G) // D
            print(cnt)
        else:
            while (S <= F):
                S += U
                cnt += 1
                if (S - G) % D == 0:
                    cnt += (S - G) // D 
                    print(cnt)
                    break
                if (S > F):
                    print("use the stairs")
                    break
else:
    # 목적지가 시작점의 위에 있는 경우
    # D가 0이면 내려갈 수 없으므로 무조건 use the stairs
    if U == 0:
        print("use the stairs")
    # U가 0이 아니면 위로 올라가야 하므로
    # 목적지까지의 거리가 U로 나누어 떨어지는지 확인
    else:
        if (G - S) % U == 0:
            cnt = (G - S) // U
            print(cnt)
        else:
            while (S >= 0):
                S -= D
                cnt += 1
                if (G - S) % U == 0:
                    cnt += (G - S) // U
                    print(cnt)
                    break
                if (S < 0):
                    print("use the stairs")
                    break