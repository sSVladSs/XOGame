package org.example;

public class Result {
    private final int width;
    private final int height;
    private final int distance;
    private String[] field;

    public Result(int width, int height, int distance) {
        this.width = width;
        this.height = height;
        this.distance = distance;
    }

    public String process(String[] array) {
        this.field = array;

        int counterField = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < height; j++) {
                if (array[border(j, i)] != null) {
                    counterField++;
                }

                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (!(k == 0 & l == 0)) {

                            if (check(j, i, l, k, "X")) {
                                return "X";
                            }
                            if (check(j, i, l, k, "O")) {
                                return "O";
                            }
                            if (counterField == array.length) {
                                return "Deadlock";
                            }
                        }
                    }
                }
            }
        }
        return "Draw";
    }

    public boolean check(int x, int y, int a, int b, String symbol) {
        for (int i = 0; i < distance; i++) {
            int index = border(x + a * i, y + b * i);
            if (index == -1) {
                return false;
            } else {
                if (field[index] != symbol) {
                    return false;
                }
            }
        }
        return true;
    }

    public int border(int x, int y) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            return y * width + x;
        }
        return -1;
    }
}
