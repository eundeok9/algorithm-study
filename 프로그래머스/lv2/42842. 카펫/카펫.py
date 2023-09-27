def solution(brown, yellow):
    answer = []
    size = brown + yellow
    for i in range(3, size+1):
        if(size % i ==0):
            j = size // i
            row = max(i, j)
            col = min(i, j)
            if(2*row+2*col-4 == brown and (row-2) * (col-2) == yellow):
                answer.append(row)
                answer.append(col)
                break
            
    return answer