import Controllers.Controller;
import Controllers.Solver;
import Interface.MazeSolverView;

public class App {
    public static void main(String[] args) throws Exception {
        new Controller(new MazeSolverView(), new Solver());
    }
}
