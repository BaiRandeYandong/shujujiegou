import javax.swing.*;

public class ShortestPathFinder {//深度优先搜索算法
    private int[][] matrix;
    private int[][] shortestPathMatrix;
    private int rows;
    private int cols;
  static   int x;static int y;
 static  int [][] arr = new int[10][10];

    public ShortestPathFinder(int[][] matrix) {
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.shortestPathMatrix = new int[rows][cols];
    }

    public int findPathsCount() {
        return findPathsCount(x, y);
    }

    private int findPathsCount(int row, int col) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] == 4 || matrix[row][col] == -1) {
            // 如果越界或遇到墙(4)、已访问(-1)的格子，则返回0
            return 0;
        }

        if (matrix[row][col] == 2) {
            // 如果到达终点(2)，路径数目加1
            return 1;
        }

        // 标记当前格子为已访问
        matrix[row][col] = -1;

        // 递归探索四个方向
        int pathsCount = findPathsCount(row + 1, col)
                + findPathsCount(row - 1, col)
                + findPathsCount(row, col + 1)
                + findPathsCount(row, col - 1);

        // 恢复未访问状态
        matrix[row][col] = 3;

        return pathsCount;
    }

    public int findShortestPathLength() {
        return findShortestPathLength(x, y, 0);
    }

    private int findShortestPathLength(int row, int col, int currentLength) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] == 4 || matrix[row][col] == -1) {
            // 如果越界或遇到墙(4)、已访问(-1)的格子，则返回最大值表示不可达
            return Integer.MAX_VALUE;
        }

        if (matrix[row][col] == 2) {
            // 如果到达终点(2)，返回当前路径长度
            shortestPathMatrix[row][col] = 5;
            return currentLength;
        }

        // 标记当前格子为已访问
        matrix[row][col] = -1;

        // 递归探索四个方向
        int shortestPathLength = Math.min(
                Math.min(
                        findShortestPathLength(row + 1, col, currentLength + 1),
                        findShortestPathLength(row - 1, col, currentLength + 1)
                ),
                Math.min(
                        findShortestPathLength(row, col + 1, currentLength + 1),
                        findShortestPathLength(row, col - 1, currentLength + 1)
                )
        );

        // 恢复未访问状态
        matrix[row][col] = 3;

        if (shortestPathLength != Integer.MAX_VALUE) {
            // 标记路径的经过位置
            shortestPathMatrix[row][col] = 5;
        }

        return shortestPathLength;
    }

    public void printShortestPathMatrix() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(shortestPathMatrix[row][col]==5&&arr[row][col]!=1&&arr[row][col]!=2){
                    arr[row][col]=shortestPathMatrix[row][col];
                }
            }
        }
    }

    public static int [][] han(int [][] aaa) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10 ; j++) {
                if(aaa[i][j]==5){
                    aaa[i][j]=3;
                }
                if(aaa[i][j]==1){
                    x=i;y=j;
                }
                arr[i][j]=aaa[i][j];
            }
        }
        ShortestPathFinder paths = new ShortestPathFinder(aaa);
        int pathsCount = paths.findPathsCount();
        int shortestPathLength = paths.findShortestPathLength();


        JOptionPane.showConfirmDialog(null,"所有路径数目：" + pathsCount+" "+"最短路径长度为：" + shortestPathLength+" "+"起点到终点的所有联通路径均已经高亮显示","",JOptionPane.DEFAULT_OPTION);

        // 获取标记后的矩阵
        paths.printShortestPathMatrix();
        return  arr;
    }
}



