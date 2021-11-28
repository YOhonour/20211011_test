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
class Solution {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m; this.n = n; this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    public int dfs(int i, int j, int si, int sj) {
        if(i >= m || j >= n || k < si + sj || visited[i][j]) return 0;
        visited[i][j] = true;
        return 1 + dfs(i + 1, j, (i + 1) % 10 != 0 ? si + 1 : si - 8, sj) + dfs(i, j + 1, si, (j + 1) % 10 != 0 ? sj + 1 : sj - 8);
    }
}

