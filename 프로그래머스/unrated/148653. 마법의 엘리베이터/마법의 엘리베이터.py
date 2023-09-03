def solution(storey):
    answer = 0
    
    while storey:
        cur = storey % 10
        
        if cur > 5:
            answer += (10 - cur)
            storey += 10
        elif cur < 5:
            answer += cur
        else:
            if (storey // 10) % 10 > 4:
                storey += 10
            answer += cur
        storey //= 10
    
    return answer