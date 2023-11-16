# SWEA 5658 보물상자 비밀번호
# 시간 15초 / 메모리 256MB

t = int(input())

for tc in range(1, t+1):
    n, k = map(int, input().split())
    numbers = list(input().rstrip())

    passwords = set() # 비밀번호를 담을 set, 중복된 수는 저장하지 않게 하기 위해 set 사용!

    # 회전은 0~(n/4)회전이 진행됨, 각 회전마다 시작위치가 1씩 증가함
    for i in range(n//4): # i 회전
        for j in range(i,n,n//4):
            password = ''
            for x in range(j, j+(n//4)):
                if x >= n:
                    x = x % n
                password += numbers[x]
            # print(password)
            passwords.add(password)
        # print("-----------")


    for password in passwords:
        passwords.remove(password)
        password = int(password, 16)
        passwords.add(password)

    passwords = list(passwords)
    passwords.sort(reverse=True)

    print("#{} {}".format(tc, passwords[k-1]))

