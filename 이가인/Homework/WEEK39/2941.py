cro = input()
num = len(cro)
for i in range(len(cro)):
    if (cro[i] == "=") and (cro[i-1] == "z") and (cro[i-2] == "d"):
        num -= 2
    elif (cro[i] == 'j') and ((cro[i-1] == 'n') or (cro[i-1] == 'l')):
        num -= 1
    elif (cro[i] == "=") and ((cro[i-1] == 'c') or (cro[i-1] == 's') or (cro[i-1] == 'z')):
        num -= 1
    elif (cro[i] == "-") and ((cro[i-1] == 'c') or (cro[i-1] == 'd') or (cro[i-1] == 'z')):
        num -= 1
print(num)