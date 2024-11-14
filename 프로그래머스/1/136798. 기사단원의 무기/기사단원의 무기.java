class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for(int i=1; i<=number; i++) {
            int weaponPower = getPower(i);
            if(weaponPower > limit) {
                answer += power;
            } else {
                answer += weaponPower;
            }
        }
        
        return answer;
    }
    
    public int getPower(int number) {
        int count = 0;
        for(int i=1; i*i<=number; i++) {
            if(i*i== number) {
                count++;
            } else if(number % i == 0) {
                count += 2;
            }
        }
        
        return count;
    }
}