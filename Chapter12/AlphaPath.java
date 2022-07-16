// You must determine if there is an alphapath through a maze. An alphapath 
// starts at the letter 'A', ends at the letter 'Z', and is a sequence of 
// horizontally or vertically adjacent steps in which each step goes to the 
// next letter of the alphabet.

// Given a maze as a grid of letters, return "YES" if there is an alphapath 
// and "NO" if there is not an alphapath.

public class AlphaPath {
    private int Row;
    private int Col;
    private boolean res=false;

    public String hasPath(String[] maze) {
        // add code here
        Row = maze.length;
        Col = maze[0].length();

        for (int i=0;i<Row;i++) {
            if (maze[i].indexOf("A") != -1) {
                for (int j=0;j<Col;j++) {
                    if (maze[i].substring(j,j+1).equals("A")) {
                        helper(maze, 66, i, j);
                    }
                    if (res) {
                        return "YES";
                    }
                }
            }     
        }

        return "NO";
    }

    public void helper(String[] maze, int idx, int row, int col) {
        if (idx > 90) {
            res = true;
            return;
        }

        if (row + 1 < Row) {
            if (maze[row+1].substring(col, col+1).equals(String.valueOf((char) idx))) {
                helper(maze, idx+1, row+1, col);
            }
        }

        if (row - 1 >= 0) {
            if (maze[row-1].substring(col, col+1).equals(String.valueOf((char) idx))) {
                helper(maze, idx+1, row-1, col);
            }
        }

        if (col - 1 >= 0) {
            if (maze[row].substring(col-1, col).equals(String.valueOf((char) idx))) {
                helper(maze, idx+1, row, col-1);
            }
        }

        if (col + 1 < Col) {
            if (maze[row].substring(col+1, col+2).equals(String.valueOf((char) idx))) {
                helper(maze, idx+1, row, col+1);
            }
        }
    }
} 