package com.chy.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
 * 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾（未排序序列的第一位）。以此类推，直到全部待排序的数据元素排完。
 *
 * @author chy
 * @date 2021/1/17 18:11
 */

public class SelectSortTest {
    public static void main(String[] args) {
        int arr[] = {10, 9, 7, 6, 4, 8, 3};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            // 每次都假设arr[i]为最小值
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 若arr[j]的值比min小，则将min = arr[j],并标记该值对应的索引
                // 注意：此处并不是替换，而是赋值给min
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}

