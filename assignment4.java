/*Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays. */
import java.util.ArrayList;
import java.util.List;

public class assignment4 {
    public static int[] findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        
        // Convert the List to an array
        int[] commonElements = new int[result.size()];
        for (int index = 0; index < result.size(); index++) {
            commonElements[index] = result.get(index);
        }
        
        return commonElements;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 5, 7};
        int[] arr3 = {3, 4, 5, 6};
        
        int[] commonElements = findCommonElements(arr1, arr2, arr3);
        
        System.out.print("Common elements in all three arrays: ");
        for (int element : commonElements) {
            System.out.print(element + " ");
        }
    }
}
/*Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*

- answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
- answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1. */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class assignment4 {
    public static List<List<Integer>> findDistinctIntegers(int[] nums1, int[] nums2) {
        List<Integer> distinctInNums1 = new ArrayList<>();
        List<Integer> distinctInNums2 = new ArrayList<>();
        
        Set<Integer> setNums1 = new HashSet<>();
        Set<Integer> setNums2 = new HashSet<>();
        
        Add elements from nums1 to setNums1
        for (int num : nums1) {
            setNums1.add(num);
        }
        
        Add elements from nums2 to setNums2 and check for distinctness
        for (int num : nums2) {
            setNums2.add(num);
            if (!setNums1.contains(num)) {
                distinctInNums2.add(num);
            }
        }
        
        Check for distinct elements in nums1
        for (int num : setNums1) {
            if (!setNums2.contains(num)) {
                distinctInNums1.add(num);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(distinctInNums1);
        result.add(distinctInNums2);
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {4, 5, 6, 7};
        
        List<List<Integer>> distinctIntegers = findDistinctIntegers(nums1, nums2);
        
        System.out.println("Distinct integers in nums1 not present in nums2: " + distinctIntegers.get(0));
        System.out.println("Distinct integers in nums2 not present in nums1: " + distinctIntegers.get(1));
    }
}

// 💡 Given a 2D integer array matrix, return *the **transpose** of* matrix.

// The **transpose** of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.

public class assignment4 {
    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        int[][] transposeMatrix = new int[columns][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transposeMatrix[j][i] = matrix[i][j];
            }
        }
        
        return transposeMatrix;
    }
    
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        int[][] transposeMatrix = transpose(matrix);
        
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        System.out.println("Transpose Matrix:");
        printMatrix(transposeMatrix);
    }
    
    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

// Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
import java.util.Arrays;

public class assignment4 {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        
        int maxSum = arrayPairSum(nums);
        
        System.out.println("Maximized sum: " + maxSum);
    }
}

// 💡 You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete.

// Given the integer n, return *the number of **complete rows** of the staircase you will build*.
public class assignment4 {
    public static int arrangeCoins(int n) {
        int row = 0;
        int coins = n;
        
        while (coins >= row + 1) {
            row++;
            coins -= row;
        }
        
        return row;
    }
    
    public static void main(String[] args) {
        int n = 8;
        
        int completeRows = arrangeCoins(n);
        
        System.out.println("Number of complete rows: " + completeRows);
    }
}
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

import java.util.Arrays;

public class assignment4 {
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 1, 3, 5};
        
        int[] sortedSquares = sortedSquares(nums);
        
        System.out.println("Sorted squares: " + Arrays.toString(sortedSquares));
    }
}

// //  You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.

// Count and return *the number of maximum integers in the matrix after performing all the operations*
public class assignment4 {
    public static int maxCount(int m, int n, int[][] ops) {
        int minRow = m;
        int minCol = n;
        
        for (int[] op : ops) {
            minRow = Math.min(minRow, op[0]);
            minCol = Math.min(minCol, op[1]);
        }
        
        return minRow * minCol;
    }
    
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int[][] ops = {{2, 2}, {3, 3}};
        
        int maxIntegers = maxCount(m, n, ops);
        
        System.out.println("Number of maximum integers: " + maxIntegers);
    }
}

// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

// *Return the array in the form* [x1,y1,x2,y2,...,xn,yn].
import java.util.Arrays;
public class assignment4 {
    public static int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index] = nums[i];
            result[index + 1] = nums[i + n];
            index += 2;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int n = 3;
        
        int[] shuffledArray = shuffle(nums, n);
        
        System.out.println("Shuffled Array: " + Arrays.toString(shuffledArray));
    }
}
