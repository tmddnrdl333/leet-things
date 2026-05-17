package algorithms;

public class DFS {

    public static void main(String[] args) {
        boolean dfsResult = dfs(0, 0);
        System.out.println(dfsResult ? "SUCCESS" : "FAILED");
    }

    // given the map is like below,
    // start from (0,0), search the `1` by DFS
    static int[][] map = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
    };

    static boolean[][] visit = new boolean[4][4];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean dfs(int x, int y) {
        System.out.println("-------------------------");
        visit[x][y] = true;
        System.out.println("current position: (" + x + ", " + y + ")");
        show();
        if (map[x][y] == 1) {
            return true;
        }
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !visit[nx][ny]) {
                if (dfs(nx, ny)) return true;
            }
        }
        return false;
    }

    // shows cells where dfs() has been entered (= explored path including dead ends)
    static void show() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) System.out.print(visit[i][j] ? "1" : "0");
            System.out.println();
        }
    }
}
