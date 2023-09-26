def solution(phone_number):
    str = list(phone_number)
    
    for i in range(len(str)- 4):
        str[i] = '*'
    
    answer = "".join(str)
    return answer