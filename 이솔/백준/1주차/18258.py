import sys

from collections import deque
arr1 = []
arr = deque(arr1)
a = int(sys.stdin.readline())
for i in range(0, a):
    b = (sys.stdin.readline().split())
    if b[0] == "front":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[0])
    elif b[0] == "back":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[len(arr)-1])
    elif b[0] == "empty":
        if len(arr) == 0:
            print(1)
        else:
            print(0)
    elif b[0] == "pop":
        if len(arr) == 0:
            print(-1)
        else:
            print(arr[0])
            arr.remove(arr[0])

    elif b[0] == "size":
        print(len(arr))
    else:
        # if b[0]==["push"]:
        arr.append(b[1])
