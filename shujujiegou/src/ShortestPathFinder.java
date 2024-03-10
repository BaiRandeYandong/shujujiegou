import javax.swing.*;

public class ShortestPathFinder {//������������㷨
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
            // ���Խ�������ǽ(4)���ѷ���(-1)�ĸ��ӣ��򷵻�0
            return 0;
        }

        if (matrix[row][col] == 2) {
            // ��������յ�(2)��·����Ŀ��1
            return 1;
        }

        // ��ǵ�ǰ����Ϊ�ѷ���
        matrix[row][col] = -1;

        // �ݹ�̽���ĸ�����
        int pathsCount = findPathsCount(row + 1, col)
                + findPathsCount(row - 1, col)
                + findPathsCount(row, col + 1)
                + findPathsCount(row, col - 1);

        // �ָ�δ����״̬
        matrix[row][col] = 3;

        return pathsCount;
    }

    public int findShortestPathLength() {
        return findShortestPathLength(x, y, 0);
    }

    private int findShortestPathLength(int row, int col, int currentLength) {
        if (row < 0 || col < 0 || row >= rows || col >= cols || matrix[row][col] == 4 || matrix[row][col] == -1) {
            // ���Խ�������ǽ(4)���ѷ���(-1)�ĸ��ӣ��򷵻����ֵ��ʾ���ɴ�
            return Integer.MAX_VALUE;
        }

        if (matrix[row][col] == 2) {
            // ��������յ�(2)�����ص�ǰ·������
            shortestPathMatrix[row][col] = 5;
            return currentLength;
        }

        // ��ǵ�ǰ����Ϊ�ѷ���
        matrix[row][col] = -1;

        // �ݹ�̽���ĸ�����
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

        // �ָ�δ����״̬
        matrix[row][col] = 3;

        if (shortestPathLength != Integer.MAX_VALUE) {
            // ���·���ľ���λ��
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


        JOptionPane.showConfirmDialog(null,"����·����Ŀ��" + pathsCount+" "+"���·������Ϊ��" + shortestPathLength+" "+"��㵽�յ��������ͨ·�����Ѿ�������ʾ","",JOptionPane.DEFAULT_OPTION);

        // ��ȡ��Ǻ�ľ���
        paths.printShortestPathMatrix();
        return  arr;
    }
}



