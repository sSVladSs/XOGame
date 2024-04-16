package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JButton {
    private final int index;
    private final Logic logic;
    private final Frame frame;

    public Button(int index, int x, int y, Logic logic, Frame frame) {
        this.index = index;
        this.logic = logic;
        this.frame = frame;

        this.setBounds(x * 100, y * 100, 100, 100);
        this.setForeground(Color.BLACK); // Button color
        this.setFont(new Font("Tahoma", Font.BOLD, 70)); // Button size
        this.addActionListener(new keyAdapter());
    }

    public void action(String text) {
        JOptionPane.showMessageDialog(null, text);
        logic.startField();
        frame.update();
    }

    public boolean result(String symbol) {
        if (symbol == "X") {
            action("ВЫ ВЫИГРАЛИ!");
            return true;
        }
        if (symbol == "O") {
            action("ВЫ ПРОИГРАЛИ!");
            return true;
        }
        if (symbol == "Deadlock") {
            action("НИЧЬЯ!");
            return true;
        }
        return false;
    }

    private class keyAdapter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(!logic.positionUser(index)) {
                return;
            }
            frame.update();
            if (result(logic.resultGame())) {
                return;
            }

            logic.positionPC();
            frame.update();
            result(logic.resultGame());
        }
    }
}
