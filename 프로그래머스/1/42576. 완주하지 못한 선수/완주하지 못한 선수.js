function solution(participant, completion) {
    let answer = '';
    const myMap = new Map();

    for (const part of participant){
        if(!myMap.get(part)){
            myMap.set(part, 1);
        }else{
            myMap.set(part, myMap.get(part)+1);
        }
    }

    for(const comp of completion){
        if(myMap.get(comp)){
            myMap.set(comp, myMap.get(comp)-1);
        }
    }
    
    for(const part of participant){
        if(myMap.get(part) && myMap.get(part) >=1 ){
            answer = part;
        }
    }
    return answer;
}