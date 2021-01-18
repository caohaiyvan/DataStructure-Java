package com.chy.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 对于给定的一组记录，初始时假设第一个记录自成一个有序序列，其余记录为无序序列。
 * 接着从第二个记录开始，按照记录的大小一次插入到前面的有序序列中，直到最后一个记录插入到有序序列中为止
 *
 * @author chy
 * @date 2021/1/18 12:10
 */

public class InsertSortTest {
    public static void main(String[] args) {
        int arr[] = {10, 9, 7, 6, 4, 8, 3};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        // 除了第一个元素外其他元素都要进行插入操作
        for (int i = 1; i < arr.length; i++) {
            // 要插入的值
            int insertVal = arr[i];
            // 要插入的位置的索引初始值为插入值所在位置的前一个位置
            int insertIndex = i - 1;
            // insertIndex >= 0 用以不造成索引越界
            // 当insertVal < arr[insertIndex]时说明未找到要添加的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                // 使当前insertIndex位置的元素向后覆盖
                arr[insertIndex + 1] = arr[insertIndex];
                // 此处insertIndex--是使insertVal与前一个位置的元素进行比较，若比较结果为insertVal < arr[insertIndex]
                // 前一个位置的元素就继续覆盖它后面的一个元素，也就形成了元素后移的效果，直到结束循环
                insertIndex--;


            }
            // 找到位置即结束循环，要插入的位置为 insertIndex+1
            arr[insertIndex + 1] = insertVal;
        }

    }
}
