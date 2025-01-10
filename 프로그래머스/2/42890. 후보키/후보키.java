import java.util.*;

class Solution {
    static int R;
    static int C;
    static List<List<Integer>> candidateKeys;  // 후보키를 저장할 리스트

    public int solution(String[][] relation) {
        int answer = 0;
        R = relation.length;
        C = relation[0].length;
        
        candidateKeys = new ArrayList<>();
        
        // 1부터 C까지의 열 조합을 검사
        for (int i = 1; i <= C; i++) {
            combinations(i, 0, new ArrayList<>(), relation);    
        }
        return candidateKeys.size();
    }
    
    // 조합을 구하는 함수
    public void combinations(int length, int start, List<Integer> current, String[][] relation) {
        if (current.size() == length) {
            if (isUnique(current, relation) && isMinimal(current)) {
                candidateKeys.add(new ArrayList<>(current));  // 현재 조합을 후보키로 추가
            }
            return;
        }
        
        for (int i = start; i < C; i++) {
            current.add(i);
            combinations(length, i + 1, current, relation);
            current.remove(current.size() - 1);
        }
    }
    
    // 유일성 검사
    public boolean isUnique(List<Integer> columns, String[][] relation) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for (int col : columns) {
                sb.append(relation[i][col]);
            }
            if (!set.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }
    
    // 최소성 검사
    public boolean isMinimal(List<Integer> columns) {
        for (List<Integer> key : candidateKeys) {
            // 이미 발견된 후보키가 현재 조합에 포함되면 최소성 만족하지 않음
            if (key.size() < columns.size() && columns.containsAll(key)) {
                return false;
            }
        }
        return true;
    }
}
