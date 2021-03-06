package com.ly.leetcode.sub;


import android.util.Log;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 * 偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Subject198 implements Subjcet {
    private static final String TAG = "Subject198";

    @Override
    public void run() {
        int n = rob(new int[]{2, 7, 9, 11, 1});
        Log.e(TAG, "run: " + n);
    }

    private int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 如果数组中的元素个个数大于2个，对于【A】式，i=2，dp[2-3]不存在
        if (nums.length > 2) {
            nums[2] += nums[0];
        }

        // 从第四个元素开始处理
        int i = 3;
        for (; i < nums.length; i++) {
            // 求出第i个元素的最大值
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }

        // 如果只有一个元素，返回这个元素值
        if (nums.length == 1) {
            return nums[0];
        }
        // 有两个元素返回其中较大的值
        else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 多于两个元素，最大值在末尾两个之间，找最大的返回
        else {
            return Math.max(nums[i - 1], nums[i - 2]);
        }

    }
}
