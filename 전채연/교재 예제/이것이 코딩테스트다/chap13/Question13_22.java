package chap13;

public class Question13_22 {
    class Move {
        Node A;
        Node B;
        
        public Move(int xA, int yA, int xB, int yB) {
            this.A = new Node(xA, yA);
            this.B = new Node(xB, yB);
        }
    }
    
    class Node {
        int x;
        int y;
        
        public Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    Move[] move = {new Move(-1, 0, -1, 0), new Move(0, 1, 0, 1), new Move(1, 0, 1, 0), new Move(0, -1, 0, -1), new Move(1, 1, 0, 0), new Move(-1, 1, 0, 0), new Move(0, 0, -1, -1), new Move(0, 0, 1, -1)};
    
    public int solution(int[][] board) {
        int answer = 0;
        return answer;
    }
}