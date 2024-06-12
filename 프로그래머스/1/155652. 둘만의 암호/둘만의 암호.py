def solution(s, skip, index):
    words = list(s)
    skip_words = list(skip)
    
    # print(chr(ord(words[0]) + 1))
    
    answer = ''
    
    for word in words:
        tmp_index = index
        while(tmp_index):
            word = chr(ord(word)+1)
            
            if word == '{':
                word = 'a'
            
            if word in skip_words:
                continue
            else:
                tmp_index -= 1
        
        answer += word
            
    return answer