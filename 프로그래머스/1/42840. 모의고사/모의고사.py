def solution(answers):
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    scores = [0, 0, 0]
    for i in range(len(answers)):
        
        
        if first[i % len(first)] == answers[i]:
            scores[0] += 1
        
        if second[i % len(second)] == answers[i]:
            scores[1] += 1
        
        if third[i % len(third)] == answers[i]:
            scores[2] += 1
    
    max_score = max(scores)
    
    answer = []
    
    for i in range(3):
        if max_score == scores[i]:
            answer.append(i+1)
    
    return answer