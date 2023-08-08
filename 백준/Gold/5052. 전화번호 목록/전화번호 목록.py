import sys
input = sys.stdin.readline

def main():
    t = int(input())

    for _ in range(t):
        n = int(input())
        nums = [input().rstrip() for _ in range(n)]
        nums.sort()

        flag = True
        for i in range(n-1):
            length = len(nums[i])
            if nums[i] == nums[i+1][:length]:
                flag = False
                break

        if flag:
            print('YES')
        else:
            print('NO')

main()