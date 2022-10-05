package chap14;

import java.util.*;

public class Question14_25 {
    public class Stage implements Comparable<Stage>{
        int index;
        float fail;
        
        public Stage(int index, float fail) {
            this.index = index;
            this.fail = fail;
        }
        
        @Override
        public int compareTo(Stage other) {
            return Float.compare(other.fail, this.fail);
        }
    }
    
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        int index = 0;
        int player = stages.length;
        int count = 0;
        
        ArrayList<Stage> stageInfo = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            player -= count;
            count = 0;
            while (index < stages.length && i == stages[index]) {
                count++;
                index++;
            }
            
            if (player <= 0) stageInfo.add(new Stage(i, 0));
            else stageInfo.add(new Stage(i, count / (float) player));
        }
        
        Collections.sort(stageInfo);
        
        int[] answer = new int[N];
        float[] fail = new float[N];
        for (int i = 0; i < stageInfo.size(); i++) {
            answer[i] = stageInfo.get(i).index;
            fail[i] = stageInfo.get(i).fail;
        }
        
        return answer;
    }
}