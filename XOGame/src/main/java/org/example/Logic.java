package org.example;

public class Logic {
    public int side = 3;
    public int length = side * side;
    public String[] field = new String[length];
    Result result = new Result(side, side, side);
    Counter counter = new Counter(result);

    public void startField() {
        field = new String[length];
        // Оптимальные позиции (3х3)
//        int[] array = {0,2,4,6,8};
//        int index = (int) (Math.random() * array.length);
//        field[array[index]] = "giO";
        // Рандомные позиции.
        int index = (int) (Math.random() * length);
        field[index] = "O";
    }

    public String resultGame() {
        return result.process(field);
    }

    public boolean write(int index, String symbol) {
        if (field[index] == null) {
            field[index] = symbol;
        } else {
            return false;
        }
        return true;
    }

    public boolean positionUser(int index) {
        return write(index, "X");
    }

    public boolean positionPC() {
        return write(counter.process(field), "O");
    }
}
