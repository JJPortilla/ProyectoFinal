package Controllers;

import java.util.*;

import Models.Cell;

public class Solver {

    public List<Cell> getPathCachingRecursive(Cell[][] grid, int[] start, int[] end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return path;
        }

        // Map para almacenar si ya visitamos una Cell y si es parte del camino
        Map<Cell, Boolean> cache = new HashMap<>();
        if (getPathCachingRecursive(grid, start[0], start[1], path, cache, end)) {
            return path;
        }

        return new ArrayList<>();
    }

    private boolean getPathCachingRecursive(Cell[][] grid, int row, int col,
            List<Cell> path, Map<Cell, Boolean> cache, int[] end) {

        if (row >= grid.length || row < 0 || col < 0 || col >= grid[0].length || grid[row][col].isLocked()) {
            return false;
        }
        Cell point = grid[row][col];
        if (cache.containsKey(point)) {
            return cache.get(point);
        }
        boolean isAtEnd = (row == end[0] && col == end[1]);
        boolean success = false;
        cache.put(point, success);

        if (isAtEnd || getPathCachingRecursive(grid, row, col + 1, path, cache, end)
                || getPathCachingRecursive(grid, row + 1, col, path, cache, end) ||
                getPathCachingRecursive(grid, row - 1, col, path, cache, end) ||
                getPathCachingRecursive(grid, row, col - 1, path, cache, end)) {
            path.add(point);
            success = true;
        }
        point.setVisited(true);

        if (!success) {
            point.setIncorrect(true);
        }

        return success;
    }

    public List<Cell> getPathRecursive(Cell[][] grid, int[] start, int[] end) {
        List<Cell> path = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return path;
        }

        // Map para almacenar si ya visitamos una Cell y si es parte del camino
        if (getPathRecursive(grid, start[0], start[1], path, end)) {
            return path;
        }

        return new ArrayList<>();
    }

    private boolean getPathRecursive(Cell[][] grid, int row, int col,
            List<Cell> path, int[] end) {

        if (row >= grid.length || row < 0 || col < 0 || col >= grid[0].length || grid[row][col].isLocked()
                || grid[row][col].isVisited()) {
            return false;
        }
        Cell point = grid[row][col];

        boolean isAtEnd = (row == end[0] && col == end[1]);
        boolean success = false;
        point.setVisited(true);

        if (isAtEnd || getPathRecursive(grid, row, col + 1, path, end)
                || getPathRecursive(grid, row + 1, col, path, end) ||
                getPathRecursive(grid, row - 1, col, path, end) ||
                getPathRecursive(grid, row, col - 1, path, end)) {
            path.add(point);
            success = true;
        }

        if (!success) {
            point.setIncorrect(true);
        }

        return success;
    }

    public void getPathBFS(Cell[][] maze, int[] start, int[] end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Cell> queue = new LinkedList<>();
        queue.add(maze[start[0]][start[1]]);
        visited[start[0]][start[1]] = true;
        maze[start[0]][start[1]].setVisited(true);
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int row = current.row;
            int col = current.column;

            if (row == end[0] && col == end[1]) {
                path.add(current);
                break;
            }

            for (int[] direction : new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if (isValidMove(maze, newRow, newCol, visited)) {
                    visited[newRow][newCol] = true;
                    Cell next = maze[newRow][newCol];
                    queue.add(next);
                    next.setVisited(true);
                    path.add(next);
                }
            }
        }

    }

    private boolean isValidMove(Cell[][] maze, int row, int col, boolean[][] visited) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length &&
                !maze[row][col].isLocked() && !visited[row][col];
    }

    public void getPathDFS(Cell[][] maze, int[] start, int[] end) {
        List<Cell> path = new ArrayList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        dfs(maze, start[0], start[1], end[0], end[1], path, visited);
    }

    private boolean dfs(Cell[][] maze, int row, int col, int endRow, int endCol, List<Cell> path, boolean[][] visited) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col].isLocked()
                || visited[row][col]) {
            return false;
        }

        Cell cell = maze[row][col];
        visited[row][col] = true;
        cell.setVisited(true);
        path.add(cell);

        if (row == endRow && col == endCol) {
            return true;
        }

        for (int[] direction : new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (dfs(maze, newRow, newCol, endRow, endCol, path, visited)) {
                return true;
            }

        }

        path.remove(cell);
        // cell.setVisited(true);
        cell.setIncorrect(true);
        return false;
    }

}
