def solution(seoul):
    answer = ''
    loc = -1
    for i in range(len(seoul)):
        if(seoul[i] == 'Kim'):
            loc = i
            break
    
    answer = "김서방은 " + str(loc) + "에 있다"
    return answer