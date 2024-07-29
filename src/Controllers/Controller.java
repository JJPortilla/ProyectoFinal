package Controllers;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Panel;

import Interface.MazeSolverView;
import Models.Cell;

/**
 * Controller
 */
public class Controller {

    private MazeSolverView view;
    private Solver solver;

    public Controller(MazeSolverView view, Solver solver) {
        this.view = view;
        this.solver = solver;

        this.view.addBFSListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                BfS();
            }

        });

        this.view.addDFSListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DFS();
            }

        });
        this.view.addRecursiveListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                recursive();
            }

        });
        this.view.addCachingRecursive(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                recursiveCaching();
            }

        });

        this.view.addGenerateListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                generateMaze();
            }

        });

        this.view.setVisible(true);
    }

    protected void BfS() {
        if (view.getMaze() == null) {
            JOptionPane.showMessageDialog(view, "Generar Laberinto");
            return;
        }

        solver.getPathBFS(view.getMaze(), view.getStart(), view.getEnd());
    }

    protected void DFS() {
        if (view.getMaze() == null) {
            JOptionPane.showMessageDialog(view, "Generar Laberinto");
            return;
        }
        solver.getPathDFS(view.getMaze(), view.getStart(), view.getEnd());

    }

    protected void recursive() {
        if (view.getMaze() == null) {
            JOptionPane.showMessageDialog(view, "Generar Laberinto");
            return;
        }

        solver.getPathRecursive(view.getMaze(), view.getStart(), view.getEnd());
    }

    protected void recursiveCaching() {
        if (view.getMaze() == null) {
            JOptionPane.showMessageDialog(view, "Generar Laberinto");
            return;
        }

        solver.getPathCachingRecursive(view.getMaze(), view.getStart(), view.getEnd());
    }

    private void generateMaze() {
        int row = Integer.parseInt(this.view.getRows());
        int column = Integer.parseInt(this.view.getColums());

        Cell[][] maze = new Cell[row][column];
        GridLayout grid = new GridLayout(row, column);

        JPanel center = view.getCenterPanel();
        center.setLayout(grid);
        center.removeAll();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Cell celda = new Cell(i, j);
                center.add(celda);
                maze[i][j] = celda;

            }
        }
        view.setMaze(maze);
        center.revalidate();
        center.repaint();
    }

}