/*
    프로그래머스 > 2020 KAKAO BLIND RECRUITMENT : 기둥과 보 설치
    - 문제 유형 : 구현, 시뮬레이션
*/

import java.util.*;

public class 기둥과_보_설치 {
    ArrayList<Structure> structures = new ArrayList<>();
    
    class Structure implements Comparable<Structure> {
        int x;
        int y;
        int type; // 0: 기둥, 1: 보
        
        public Structure(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
        
        @Override
        public int compareTo(Structure other) {
            if (this.x == other.x && this.y == other.y) 
                return Integer.compare(this.type, other.type);
            if (this.x == other.x) return Integer.compare(this.y, other.y);
            else return Integer.compare(this.x, other.x);
        }
    }
    
    public boolean canHandle() {
        A: for (int i = 0; i < structures.size(); i++) {
            int x = structures.get(i).x;
            int y = structures.get(i).y;
            int type = structures.get(i).type;
            
            // 기둥인 경우
            if (type == 0) {
                // 바닥인 경우
                if (y == 0) continue;
                for (int j = 0; j < structures.size(); j++) {
                    int nx = structures.get(j).x;
                    int ny = structures.get(j).y;
                    int ntype = structures.get(j).type;
                    
                    // 밑에 기둥이 존재하는 경우
                    if (nx == x && ny == y - 1 && ntype == 0) continue A;
                    // 왼쪽 아래에 보가 존재하는 경우
                    if (nx == x - 1 && ny == y && ntype == 1) continue A;
                    // 오른쪽 아래에 보가 존재하는 경우
                    if (nx == x && ny == y && ntype == 1) continue A;
                }
                return false;
            }
            // 보인 경우
            else if (type == 1) {
                boolean left = false;
                boolean right = false;
                
                for (int j = 0; j < structures.size(); j++) {
                    int nx = structures.get(j).x;
                    int ny = structures.get(j).y;
                    int ntype = structures.get(j).type;
                    
                    // 왼쪽 아래에 기둥이 존재하는 경우
                    if (nx == x && ny == y - 1 && ntype == 0) continue A;
                    // 오른쪽 아래에 기둥이 존재하는 경우
                    if (nx == x + 1 && ny == y - 1 && ntype == 0) continue A;
                    // 왼쪽에 보가 존재하는 경우
                    if (nx == x - 1 && ny == y && ntype == 1) left = true;
                    // 오른쪽에 보가 존재하는 경우
                    if (nx == x + 1 && ny == y && ntype == 1) right = true;
                }
                
                if (!left || !right) return false;
            }
        }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0]; // 가로 좌표 x 입력
            int y = build_frame[i][1]; // 세로 좌표 y 입력
            int a = build_frame[i][2]; // 구조물의 종류 a 입력 (0: 기둥, 1: 보)
            int b = build_frame[i][3]; // 구조물의 처리 유형 (0: 삭제, 1: 설치)
        
            // 구조물을 삭제하는 경우
            if (b == 0) {
                // 삭제할 구조물 탐색 후 삭제
                int index = 0;
                for (int j = 0; j < structures.size(); j++) {
                    if (x == structures.get(j).x
                        && y == structures.get(j).y 
                        && a == structures.get(j).type) index = j;
                }
                Structure erased = structures.get(index);
                structures.remove(index);
                
                // 삭제 시 조건을 불충족한다면 구조물 다시 추가
                if (!canHandle()) structures.add(erased);
            }
            
            // 구조물을 설치하는 경우
            else if (b == 1) {
                // 구조물 설치
                structures.add(new Structure(x, y, a));
                
                // 설치 시 조건을 불충족한다면 구조물 다시 삭제
                if (!canHandle()) structures.remove(structures.size() - 1);
            }
        }
        // 정렬
        Collections.sort(structures);
        int[][] answer = new int[structures.size()][3];

        // 2차원 배열로 변환
        for (int i = 0; i < structures.size(); i++) {
            answer[i][0] = structures.get(i).x;
            answer[i][1] = structures.get(i).y;
            answer[i][2] = structures.get(i).type;
        }
        
        return answer;
    }
}