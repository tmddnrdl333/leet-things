package algorithms;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        boolean bfsResult = bfs(0, 0);
        System.out.println(bfsResult ? "SUCCESS" : "FAILED");
    }

    // given the map below,
    // start from (0,0), search for the `1` by BFS
    static int[][] map = new int[][]{
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 1}
    };

    // (x, y) coordinates
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] visit = new boolean[4][4];

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static boolean bfs(int startX, int startY) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(startX, startY));
        visit[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int x = node.x, y = node.y;
            System.out.println("-------------------------");
            System.out.println("current position: (" + x + ", " + y + ")");
            show();
            if (map[x][y] == 1) {
                return true;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !visit[nx][ny]) {
                    queue.offer(new Node(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
        return false;
    }

    // shows cells discovered so far (= in queue + already processed)
    // note: marked at enqueue time, so frontier cells appear as visited before being processed
    static void show() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) System.out.print(visit[i][j] ? "1" : "0");
            System.out.println();
        }
    }
}
