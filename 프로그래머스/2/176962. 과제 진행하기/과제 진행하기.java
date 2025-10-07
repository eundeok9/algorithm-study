import java.util.*;
class Solution {
    static class Task {
        String name;
        int start;
        int playtime;
        
        Task(String n, String s, String p) {
            this.name = n;
            this.start = toMinutes(s);
            this.playtime = Integer.parseInt(p);
        }
        
        static int toMinutes(String time) {
            String[] t = time.split(":");
            return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        }
    }
    
    public String[] solution(String[][] plans) {
        List<Task> list = new ArrayList<>();
        for(String[] p: plans) {
            list.add(new Task(p[0], p[1], p[2]));
        }
        
        list.sort((a, b) -> a.start - b.start);
        
        Stack<Task> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        
        for(int i=0; i<list.size() - 1; i++) {
            Task cur = list.get(i);
            Task next = list.get(i+1);
            
            int timeGap = next.start - cur.start; // 현재 과제를 진행할 수 있는 시간
            
            if(cur.playtime <= timeGap) {
                result.add(cur.name);
                
                int remain = timeGap - cur.playtime; // 멈춰둔 과제를 할 수 있는 시간
                
                while(!stack.isEmpty() && remain > 0) {
                    Task t = stack.pop();
                    if(t.playtime <= remain) {
                        remain -= t.playtime;
                        result.add(t.name);
                    } else {
                        t.playtime -= remain;
                        stack.push(t);
                        remain = 0;
                    }
                }
            } else {
                cur.playtime -= timeGap;
                stack.push(cur);
            }
        }
        
        result.add(list.get(list.size()-1).name);
        while(!stack.isEmpty()) {
            result.add(stack.pop().name);
        }
        
        String[] answer = new String[plans.length];
        for(int i=0; i<plans.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}