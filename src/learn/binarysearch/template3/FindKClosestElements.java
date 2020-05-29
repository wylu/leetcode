package learn.binarysearch.template3;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   FindKClosestElements.java
 * @Time    :   2020/05/29 23:07:53
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        if (x <= arr[0]) {
            copy(res, arr, 0, k - 1);
        } else if (x >= arr[arr.length - 1]) {
            copy(res, arr, arr.length - k, arr.length - 1);
        } else {
            int idx = binarySearch(arr, 0, arr.length - 1, x);
            if (idx < 0) idx = -idx - 1;
            int left = Math.max(0, idx - k - 1), right = Math.min(arr.length - 1, idx + k - 1);
            while (right - left > k - 1) {
                if ((x - arr[left]) <= (arr[right] - x)) right--;
                else left++;
            }
            copy(res, arr, left, right);
        }
        return res;
    }

    private int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    private void copy(List<Integer> res, int[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            res.add(arr[i]);
        }
    }

    public static void main(String[] args) {
        FindKClosestElements finder = new FindKClosestElements();
        int[] arr = new int[]{1, 1, 1, 10, 10, 10};
        List<Integer> res = finder.findClosestElements(arr, 1, 9);
        for (int e: res){
            System.out.print(e + " ");
        }
    }
}