import sys
a = int(sys.stdin.readline())

while True:
    fuck = False
    for i in range(2,int(a**0.5)):
        if a%i == 0:
            fuck = True
            break
    if fuck:
        a = a+1
        continue
    else:
        break
if a == 1:
    a = 2

print(a)