// chap15 Q30 가사 검색
// (이진탐색은 아니고 Trie 이용한 풀이로 공부함)
// 출처 : https://iamheesoo.github.io/blog/algo-prog60060

import java.util.HashMap;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Trie[] tries = new Trie[100001];
        for (String word : words) {
            int len = word.length();
            if (tries[len] == null) tries[len] = new Trie();
            tries[len].insert(word);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int len = queries[i].length();
            if (tries[len] == null) answer[i] = 0;
            else answer[i] = tries[len].getCount(queries[i]);
        }
        return answer;
    }
}

class Trie {
    Node front, back;

    public Trie() {
        this.front = new Node();
        this.back = new Node();
    }

    public void insert(String word) {
        insertFront(word);
        insertBack(word);
    }

    private void insertFront(String word) {
        Node node = front;
        for (int i = 0; i < word.length(); i++) {
            node.count++;
            node = node.children.computeIfAbsent(word.charAt(i), c->new Node());
        }
    }

    private void insertBack(String word) {
        Node node = back;
        for (int i = word.length() - 1; i >= 0; i--) {
            node.count++;
            node = node.children.computeIfAbsent(word.charAt(i), c->new Node());
        }
    }

    public int getCount(String query) {
        if (query.charAt(0) == '?')
            return getCountFromBack(query);
        else
            return getCountFromFront(query);
    }

    private int getCountFromFront(String query) {
        Node node = front;
        for (int i = 0; i < query.length(); i++) {
            if (query.charAt(i) == '?') break;
            if (!node.children.containsKey(query.charAt(i))) return 0;
            node = node.children.get(query.charAt(i));
        }
        return node.count;
    }

    private int getCountFromBack(String query) {
        Node node = front;
        for (int i = query.length() - 1; i >= 0; i--) {
            if (query.charAt(i) == '?') break;
            if (!node.children.containsKey(query.charAt(i))) return 0;
            node = node.children.get(query.charAt(i));
        }
        return node.count;
    }
}

class Node {
    HashMap<Character, Node> children;
    int count;

    public Node() {
        this.children = new HashMap<>();
        this.count = 0;
    }
}