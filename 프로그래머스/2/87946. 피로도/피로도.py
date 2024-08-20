from itertools import permutations

def solution(k, dungeons):
    answer = -1
    
    for dungeon in permutations(dungeons, len(dungeons)):
        tmp = k
        cnt = 0
        
        for a, b in dungeon:
            if tmp >= a:
                tmp -= b
                cnt += 1
        
        answer = max(cnt, answer)
    
    return answer