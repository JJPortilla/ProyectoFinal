package Models;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.event.*;

/**
 * Cell
 */
public class Cell extends JPanel {

    public int row;
    public int column;
    private boolean locked;
    private boolean visited;
    private boolean incorrect;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
        if (visited)
            this.setBackground(Color.yellow);
        else if (locked)
            this.setBackground(Color.black);
        else
            this.setBackground(Color.white);

        repaintt(1000);
    }

    public boolean isIncorrect() {
        return incorrect;
    }

    public void setIncorrect(boolean incorrect) {
        this.incorrect = incorrect;
        if (incorrect)
            this.setBackground(Color.red);
        else if (locked)
            this.setBackground(Color.black);
        else
            this.setBackground(Color.white);
        repaintt(1000);
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
        if (locked)
            this.setBackground(Color.BLACK);
        else
            this.setBackground(Color.white);
        repaintt(1000);
    }

    public Cell(int row, int column) {
        this.setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.locked = false;
        this.row = row;
        this.column = column;

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setLocked(!locked);
            }
        });

    }

    public void clear() {
        setIncorrect(false);
        setVisited(false);
    }

    public void reset() {
        setLocked(false);
        clear();
    }

    @Override
    public String toString() {
        return "Cell [row=" + row + ", column=" + column + "]" + this.hashCode();
    }

    public void repaintt(long tm) {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Actualiza las coordenadas (por ejemplo, mueve el componente)

                repaint(); // Solicita el repintado
            }
        });
        timer.start();
    }

}