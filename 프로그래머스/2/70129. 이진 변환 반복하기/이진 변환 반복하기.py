def solution(s):
    answer = []
    cnt = 0
    zeroCnt = 0
    while (s != '1'):
        
        cnt += 1
        result = ''.join(filter(lambda x: x != '0', s))
        zeroCnt += len(s) - len(result)
        s = bin(len(result))[2:]
    
    answer = [cnt, zeroCnt]
    return answer