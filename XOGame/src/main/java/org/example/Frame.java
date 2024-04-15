package org.example;

import javax.swing.*;

public class Frame extends JFrame {
    public Logic logic = new Logic();
    public Button[] buttons = new Button[logic.length];

    public Frame() {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(logic.side * 100 + 16, logic.side * 100 + 39);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.add(panel);

        int index = 0;
        for (int y = 0; y < logic.side; y++) {
            for (int x = 0; x < logic.side; x++) {
                panel.add(buttons[index] = new Button(index, x, y, logic, this));
                index++;
            }
        }
        logic.startField();
        update();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }

    public void update() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(logic.field[i]);
        }
    }
}