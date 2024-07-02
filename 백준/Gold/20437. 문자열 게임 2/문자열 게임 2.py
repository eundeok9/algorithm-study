#1초 1024mb

import sys
input = sys.stdin.readline

t = int(input())

for _ in range(t):
    w = input().rstrip()
    k = int(input())
    
    count_dict = {}
    
    for char in w:
        count_dict[char] = count_dict.get(char, 0) + 1
    
    check = False
    max_length = -1
    min_length = len(w)
    
    check_dict = {}
    
    for i in range(len(w)):
        # 해당 문자열이 k개 이하면 다음 문자 확인
        if count_dict[w[i]] < k:
            continue
        
        # k개 이상인 문자를 찾으면 정답이 있음
        check = True
        
        # 해당 문자열을 key로 하고 index 리스트를 value로 갖는 딕셔너리
        check_dict[w[i]] = check_dict.get(w[i], []) + [i]
        
    for key, value in check_dict.items():
        for i in range(len(value) - k + 1):
            max_length = max(max_length, value[i+k-1] - value[i] + 1)
            min_length = min(min_length, value[i+k-1] - value[i] + 1)
    
    if check:
        print(min_length, max_length)
        
    else:
        print(-1)