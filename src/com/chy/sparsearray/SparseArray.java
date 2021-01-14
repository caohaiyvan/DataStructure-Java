package com.chy.sparsearray;

/**
 * 稀疏数组
 *
 * @author chy
 * @date 2020/6/12 13:45
 */

public class SparseArray {
    public static void main(String[] args) {
        // 创建原始数组
        int sourceArray[][] = new int[11][11];
        sourceArray[1][2] = 1;
        sourceArray[2][3] = 2;
        sourceArray[3][4] = 3;
        System.out.println("===================原始数组====================");
        // 查看原始数组打印效果
        for (int[] row : sourceArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        /*
            原始数组转化为稀疏数组，已知原始数组有几行和几列，
            1、获取原始数组中的有效值个数并将原始数组的几行几列和几个有效值赋给稀疏数组的第一行
            2、稀疏数组的其他行：a、通过遍历原始数组获取其中中有效值的行和列及有效值本身，即为要放到稀疏数组中的值
                               b、具体将以上数值放到稀疏数组的什么位置：通过计数有效值为原始数组中的第几个有效值来确定放在稀疏数组的哪一行
                               （第几个有效值数=稀疏数组的行下标值），列下标值分别为0、1、2

         */
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (sourceArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        // 构造稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        // count用来计数存储在稀疏数组的第几行(count表示原始数组中第几个不为0的数存放在稀疏数组为几的下标下)
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (sourceArray[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = sourceArray[i][j];
                }
            }
        }
        System.out.println("===================稀疏数组====================");

        // 查看稀疏数组打印效果
        for (int[] row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        System.out.println("===================还原为原始数组====================");
        // 从稀疏数组的第一行可知原始数组的行和列数，以及稀疏数组有几行即第三列值+1行
        int array[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        // 从第二行开始遍历稀疏数组
        // 可通过数组.length获取二维数组的行数
        for (int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        for (int[] row : array) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }


    }
}
