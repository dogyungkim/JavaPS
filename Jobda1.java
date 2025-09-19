import java.util.*;
class Jobda1 {
    static Map<Character, List<Integer>> graph;  // 그래프
    static int[] inDegree;   // 진입차수
    static int[] outDegree;  // 진출차수
    static boolean[] used;    // 단어 사용 여부
    static String[] W;        // 단어 배열

    public static void main(String[] args) {
        int N = 5;
        W = new String[]{"apple","elepant","tiger","red","domino"};  // static 변수에 할당
        
        // 그래프 초기화
        graph = new HashMap<>();
        inDegree = new int[26];  // 알파벳 26개
        outDegree = new int[26];
        used = new boolean[N];
        
        // 그래프 구성
        for (int i = 0; i < N; i++) {
            char start = W[i].charAt(0);
            char end = W[i].charAt(W[i].length() - 1);
            
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(i);  // 단어의 인덱스 저장
            
            inDegree[end - 'a']++;
            outDegree[start - 'a']++;
        }
        
        // 오일러 경로 존재 여부 확인
        boolean possible = checkEulerianPath();
        if (!possible) {
            System.out.println("NO");
            return;
        }
        
        // DFS로 경로 찾기
        List<Integer> path = new ArrayList<>();
        char startChar = findStartChar();
        if (dfs(startChar, N, path)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    
    static boolean checkEulerianPath() {
        int startNodes = 0;
        int endNodes = 0;
        
        for (int i = 0; i < 26; i++) {
            int diff = outDegree[i] - inDegree[i];
            if (diff > 1 || diff < -1) return false;
            if (diff == 1) startNodes++;
            if (diff == -1) endNodes++;
        }
        
        return (startNodes == 0 && endNodes == 0) || 
               (startNodes == 1 && endNodes == 1);
    }
    
    static char findStartChar() {
        // 시작 노드 찾기 (진출차수가 진입차수보다 1 큰 노드)
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] - inDegree[i] == 1) {
                return (char)('a' + i);
            }
        }
        // 없다면 진출차수가 있는 아무 노드나 반환
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                return (char)('a' + i);
            }
        }
        return 'a';
    }
    
    static boolean dfs(char current, int remainingWords, List<Integer> path) {
        if (remainingWords == 0) {
            return true;
        }
        
        List<Integer> edges = graph.getOrDefault(current, new ArrayList<>());
        for (int wordIdx : edges) {
            if (used[wordIdx]) continue;
            
            used[wordIdx] = true;
            path.add(wordIdx);
            // 다음 단어의 마지막 문자로 재귀 호출
            char nextChar = W[wordIdx].charAt(W[wordIdx].length() - 1);
            if (dfs(nextChar, remainingWords - 1, path)) {
                return true;
            }
            used[wordIdx] = false;
            path.remove(path.size() - 1);
        }
        
        return false;
    }
}