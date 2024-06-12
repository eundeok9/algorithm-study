def solution(A,B):
    A.sort()
    B.sort()
    
    answer = 0
    
    for i in range(len(A)):
        j = i+1
        answer += (A[i] * B[-j])

    return answer