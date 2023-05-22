def solution(s):
    answer = ''
    token = s.split(' ')
    for i in token:
        for j in range(len(i)):
            if j % 2 == 0:
                answer += i[j].upper()
            else:
                answer += i[j].lower()
        answer += ' '
    
    return answer[0:-1]