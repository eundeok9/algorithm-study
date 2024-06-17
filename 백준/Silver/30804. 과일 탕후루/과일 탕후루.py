import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

nums = [0] * 10

left = 0
cnt = 0
kind = 0
maxCnt = 0

for right in range(n):
    if nums[arr[right]] == 0:
        kind += 1
        
    nums[arr[right]] += 1
    cnt += 1
    
    while kind > 2:
        if nums[arr[left]] == 1:
            kind -= 1
        nums[arr[left]] -= 1
        cnt -= 1
        left += 1
    
    maxCnt = max(maxCnt, cnt)

print(maxCnt)