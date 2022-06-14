package chap06;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Example6_9 {
    static class Fruit implements Comparable<Fruit> {
        String name;
        int score;

        Fruit(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Fruit other) {
            if (this.score > other.score) return 1;
            return -1;
        }
    }

    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();

        fruits.add(new Fruit("바나나", 2));
        fruits.add(new Fruit("사과", 5));
        fruits.add(new Fruit("당근", 3));

        Collections.sort(fruits);

        for (int i = 0; i < fruits.size(); i++) {
            System.out.print("(" + fruits.get(i).name + ", " + fruits.get(i).score + ") ");
        }
    }
}
