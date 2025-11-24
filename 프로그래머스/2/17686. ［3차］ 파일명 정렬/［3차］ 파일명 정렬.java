import java.util.*;
class Solution {
    static class FileName implements Comparable<FileName> {
        String head, number, tail;
        FileName(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        
        public int compareTo(FileName o) {
            int headCmp = this.head.compareToIgnoreCase(o.head);
            if (headCmp != 0) return headCmp;

            return Integer.compare(Integer.parseInt(this.number), Integer.parseInt(o.number));
        }
    }
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        FileName[] arr = new FileName[files.length];
        for(int i=0; i<files.length; i++) {
            String file = files[i];
            
            int idx1 = 0;
            while(idx1 < file.length() && !Character.isDigit(file.charAt(idx1))) {
                idx1++;
            }
            
            String head = file.substring(0, idx1);
            
            int idx2 = idx1;
            int count = 0;
            while(idx2 < file.length() && Character.isDigit(file.charAt(idx2)) && count < 5) {
                idx2++;
                count++;
            }
            
            String number = file.substring(idx1, idx2);
            
            String tail = file.substring(idx2, file.length());
            
            // System.out.println(head + " " + number + " " + tail);
            
            arr[i] = new FileName(head, number, tail);
        }
        
        Arrays.sort(arr);
        
        for(int i=0; i<arr.length; i++) {
            answer[i] = arr[i].head + arr[i].number + arr[i].tail;
        }
        
        return answer;
    }
}