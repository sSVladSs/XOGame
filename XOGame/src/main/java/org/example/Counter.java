package org.example;

public class Counter {
    private int index;
    int depth = 2;
    Result result;

    Counter(Result result) {
        this.result = result;
    }

    public int process(String[] array) {
        recursion("O", array, -1, depth);
        return index;
    }

    public int recursion(String symbol, String[] arrayOut, int coordinate, int depth) {
        String[] array = arrayOut.clone();
        if (coordinate >= 0) {
            array[coordinate] = symbol;
        }
        if (result.process(array) == symbol) {
            return 2;
        }

        int score = 0, maxScore = -1, index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null && depth > 0) {
                if (symbol == "X") {
                    score = recursion("O", array, i, depth - 1);
                }
                if (symbol == "O") {
                    score = recursion("X", array, i, depth - 1);
                }
                if (score > maxScore) {
                    maxScore = score;
                    index = i;
                }
            }
        }

        this.index = index;

        if (maxScore == -1) {
            return 1;
        } else {
            return 2 - maxScore;
        }
    }
}
