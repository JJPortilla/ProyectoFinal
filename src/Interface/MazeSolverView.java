package Interface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Panel;

import Models.Cell;

/**
 * MazeSolverView
 */
public class MazeSolverView extends JFrame {

    private JTextField rows;
    private JTextField columns;
    private JTextField start;
    private JTextField end;
    private JButton btnGenerate;
    private JButton btnClear;
    private JButton btnReset;

    private JButton btnDFS;
    private JButton btnBFS;
    private JButton btnRecursive;
    private JButton btnCachingRecursive;
    private Cell[][] mazes;

    public Cell[][] getMaze() {
        return mazes;
    }

    public void setMaze(Cell[][] maze) {
        this.mazes = maze;
    }

    private JPanel centerPanel;

    public JPanel getCenterPanel() {
        return centerPanel;
    }

    public void setCenterPanel(JPanel centerPanel) {
        this.centerPanel = centerPanel;
    }

    public String getRows() {
        return rows.getText();
    }

    public String getColums() {
        return columns.getText();
    }

    public MazeSolverView() {
        this.setTitle("Laberinto");
        this.setSize(600, 500);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(ABORT);
            }
        });

        JPanel topPanel = new JPanel(new FlowLayout());

        JPanel gridDataPanel = new JPanel(new GridLayout(2, 3));

        JPanel rowsPanel = new JPanel(new GridLayout(1, 2));
        JLabel rowLabel = new JLabel("Filas");
        rows = new JTextField();
        rowsPanel.add(rowLabel);
        rowsPanel.add(rows);

        gridDataPanel.add(rowsPanel);

        JPanel startPanel = new JPanel(new GridLayout(1, 2));
        JLabel startLabel = new JLabel("Inicio \"0,0\"");
        start = new JTextField();
        startPanel.add(startLabel);
        startPanel.add(start);

        gridDataPanel.add(startPanel);

        JPanel columnsPanel = new JPanel(new GridLayout(1, 2));
        JLabel columnsLabel = new JLabel("Columnas");
        columns = new JTextField();
        columnsPanel.add(columnsLabel);
        columnsPanel.add(columns);

        gridDataPanel.add(columnsPanel);

        JPanel endPanel = new JPanel(new GridLayout(1, 2));
        JLabel endLabel = new JLabel("Final \"3,3\"");
        end = new JTextField();
        endPanel.add(endLabel);
        endPanel.add(end);

        gridDataPanel.add(endPanel);

        topPanel.add(gridDataPanel);
        JPanel buttons = new JPanel(new GridLayout(3, 1));
        btnGenerate = new JButton("Generar");

        buttons.add(btnGenerate);
        btnClear = new JButton("Limpiar");
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                clear();
            }

        });

        buttons.add(btnClear);

        btnReset = new JButton("Limpiar Todo");
        btnReset.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }

        });

        buttons.add(btnReset);

        topPanel.add(buttons);

        this.add(topPanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        centerPanel.setBackground(Color.LIGHT_GRAY);

        this.add(centerPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 2));
        btnBFS = new JButton("BFS");
        bottomPanel.add(btnBFS);
        btnDFS = new JButton("DFS");
        bottomPanel.add(btnDFS);
        btnCachingRecursive = new JButton("Recursivo Caching");
        bottomPanel.add(btnCachingRecursive);
        btnRecursive = new JButton("Recursivo");
        bottomPanel.add(btnRecursive);

        this.add(bottomPanel, BorderLayout.SOUTH);

    }

    public void addGenerateListener(ActionListener listener) {
        btnGenerate.addActionListener(listener);
    }

    public void addBFSListener(ActionListener listener) {
        btnBFS.addActionListener(listener);
    }

    public void addDFSListener(ActionListener listener) {
        btnDFS.addActionListener(listener);
    }

    public void addRecursiveListener(ActionListener listener) {
        btnRecursive.addActionListener(listener);
    }

    public void addCachingRecursive(ActionListener listener) {
        btnCachingRecursive.addActionListener(listener);
    }

    public int[] getStart() {
        if (mazes == null) {
            JOptionPane.showMessageDialog(this, "Generar Laberinto");
            return null;
        } else {
            int[] s = new int[] { 0, 0 };

            try {
                String[] txt = start.getText().split(",");
                for (int i = 0; i < txt.length; i++) {
                    s[i] = Integer.parseInt(txt[i]);
                }
            } catch (Exception ex) {
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            return s;
        }
    }

    public int[] getEnd() {
        if (mazes == null) {
            JOptionPane.showMessageDialog(this, "Generar Laberinto");
            return null;
        } else {

            int[] s = new int[] { mazes.length - 1, mazes[0].length-1 };

            try {
                String[] txt = end.getText().split(",");
                for (int i = 0; i < txt.length; i++) {
                    s[i] = Integer.parseInt(txt[i]);
                }
            } catch (Exception ex) {
                // JOptionPane.showMessageDialog(this, ex.getMessage());
            }

            return s;
        }
    }

    public void clear() {
        for (int i = 0; i < mazes.length; i++) {
            for (int j = 0; j < mazes[0].length; j++) {
                Cell celda = mazes[i][j];
                celda.clear();
            }
        }
    }

    public void reset() {
        for (int i = 0; i < mazes.length; i++) {
            for (int j = 0; j < mazes[0].length; j++) {
                Cell celda = mazes[i][j];
                celda.reset();
            }
        }
    }
}