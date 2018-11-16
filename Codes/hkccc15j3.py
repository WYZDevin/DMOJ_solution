import sys
a = sys.stdin.readline().split(" ")
n = int(a[0])
m = int(a[1])
queen = []
board = [[False for j in range(n)]for i in range(n)]
count = 0
for i in range(m):
    raw = sys.stdin.readline().split(" ")
    x = int(raw[0]) -1
    y = int(raw[1]) -1
    xm = [1,0,-1]
    ym = [1,0,-1]
    board[x][y] = True
    for xx in xm:
        for yy in ym:
            if xx == yy and xx == 0:
                continue
            newx = x
            newy = y
            while newx + xx < n and newy + yy < n and newx + xx >= 0 and newy + yy >=0:
                newx += xx
                newy += yy
                if board[newx][newy] == False:
                    board[newx][newy] = True

for i in board:
    for j in i:
        if not j:
            count += 1
print(count)