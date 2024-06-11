def solution(answers):
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    scores = [0, 0, 0]
    for i in range(len(answers)):
        a = i % 5
        b = i % 8
        c = i % 10
        
        if first[a] == answers[i]:
            scores[0] += 1
        
        if second[b] == answers[i]:
            scores[1] += 1
        
        if third[c] == answers[i]:
            scores[2] += 1
    
    max_score = max(scores)
    
    answer = []
    
    for i in range(3):
        if max_score == scores[i]:
            answer.append(i+1)
    
    return answer