package days;

import java.util.HashMap;

public class Day14 {
    private boolean dfs(char[][] board, char[] word,int x,int y,int index){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word[index]) return false;
        if (index == (word.length-1)) return true;
        board[x][y] = '\0';
        boolean res = dfs(board,word,x-1,y,index+1) ||
                dfs(board,word,x+1,y,index+1) ||
                dfs(board,word,x,y-1,index+1) ||
                dfs(board,word,x,y+1,index+1);
        board[x][y] = word[index];
        return res;
    }
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,chars,i,j,0)) return true;
            }
        }
        return false;
    }

    int nums(int a){
        int s = 0;
        while (a > 0){
            s += a % 10;
            a /= 10;
        }
        return s;
    }
    public int movingCount(int m, int n, int k) {
        return 0;
    }
    public static void main(String[] args) {
        Day14 day14 = new Day14();
        System.out.println();
    }
}
