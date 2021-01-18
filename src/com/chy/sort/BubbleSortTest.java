package com.chy.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 从第一个位置开始到倒数第二个位置，分别与右侧相邻的一个位置进行比较，因此进行了 arr.length - 1 趟排序
 * 若两个相邻元素逆序，则进行交换
 * 若从小到大排序则一趟排序后，最大值出现在最右侧
 *
 * @author chy
 * @date 2021/1/17 17:06
 */

public class BubbleSortTest {
    public static void main(String[] args) {
        int arr[] = {10, 9, 7, 6, 4, 8, 3};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void bubbleSort(int[] arr) {
        int temp;
        // 用于标记数据是否发生了替换
        boolean flag = false;
        // 需要几趟排序：arr.length - 1
        for (int i = 0; i < arr.length - 1; i++) {
            // 若发生了替换，则进行下一趟排序，并且重置flag的值
            flag = false;
            // 因为第一趟需要-0，第二趟需要-1，因此第n趟需要 -n+1,并且此值与i的值相对应，因此此处用i替换要减去的值
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            // 如果未发生替换，则数列是有序的
            if (!flag) {
                break;
            }
        }
    }

}

