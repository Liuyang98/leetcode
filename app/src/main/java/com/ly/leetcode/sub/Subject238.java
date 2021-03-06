package com.ly.leetcode.sub;

/**
 * 删除链表中的节点
 * <p>
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Subject238 implements Subjcet {
    private static final String TAG = "Subject238";

    @Override
    public void run() {

        productExceptSelf(new int[]{2, 3, 4, 5});
    }

    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] r = new int[length];
        r[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--)
            r[i] = r[i + 1] * nums[i + 1];

        int l = 1;
        for (int i = 0; i < length; i++) {
            r[i] = l * r[i];
            l *= nums[i];
        }

        return r;
    }
}
