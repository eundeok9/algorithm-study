import sys
input = sys.stdin.readline

n = int(input())
arr1 = list(map(int, input().split()))
m = int(input())
arr2 = list(map(int, input().split()))

arr1.sort()

for num in arr2:
    lt, rt = 0, n-1
    isExist = False
    
    # 이분탐색
    while lt <= rt:
        mid = (lt + rt) // 2
        if num == arr1[mid]: # 값이 존재한다면
            isExist = True
            print(1)
            break
        elif num > arr1[mid]: # 현재 값이 더 크다면
            lt = mid + 1
        else:
            rt = mid - 1
    
    if not isExist:
        print(0)