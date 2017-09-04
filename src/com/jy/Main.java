package com.jy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] number = new int[] { 1, 2, 4, 7, 11, 15 };
		Scanner scanner = new Scanner(System.in);
		System.out.print("请输入和sum:");
		int sum = scanner.nextInt();

		System.out.println("数组:" + Arrays.toString(number));
		System.out.println("数组中是否至少存在一组和为" + sum + "的数:" + findNumersWithSum(number, sum));

		System.out.println("==========分隔线==========");

		System.out.print("请输入和s:");
		int s = scanner.nextInt();
		System.out.println("寻找出和为" + s + "的连续数列:");
		FindContinuousSequence(s);
		scanner.close();
	}

	/**
	 * 在排序数组中寻找和为sum的两个数，如果存在输出至少一组
	 * 
	 * @param number
	 *            输入的排序数组
	 * @param sum
	 *            两数之和
	 * @return 如果找到至少一组这样的数就返回true,否则返回false
	 */
	public static boolean findNumersWithSum(int[] number, int sum) {
		int length = number.length;
		if (number == null || length < 2)
			return false;
		// 收尾两个位置开始查找
		int head = 0;
		int tail = length - 1;
		while (head < tail) {
			int currentSum = number[head] + number[tail];
			if (currentSum == sum) {
				// 找到后输出并返回true
				System.out.println("数组中找和为" + sum + "的两个数:" + number[head] + " " + number[tail]);
				return true;
			}
			if (currentSum < sum)
				// 当前和比较小时，头指针往后移
				head++;
			else
				// 当前和比较大时，尾指针往前移
				tail--;
		}
		return false;
	}

	/**
	 * 寻找连续数列并打印，他们的和为sum
	 * 
	 * @param sum
	 *            连续数列的和
	 */
	public static void FindContinuousSequence(int sum) {
		// 至少有两个数，则他们的和肯定大于3
		if (sum < 3)
			return;
		// 分别定义较小数、较大数和中间数
		int small = 1;
		int big = 2;
		int middle = (1 + sum) >> 1;
		// 当前连续序列之和
		int currentSum = small + big;
		// 因为至少包含两个数，所以叫小数必须小于中间数
		while (small < middle) {
			if (currentSum == sum)
				printContinuousSequence(small, big);
			while (currentSum > sum && small < middle) {
				currentSum -= small;
				small++;
				if (currentSum == sum)
					printContinuousSequence(small, big);
			}
			big++;
			currentSum += big;
		}
	}

	/**
	 * 打印连续数列
	 * 
	 * @param small
	 *            连续数列开始的值
	 * @param big
	 *            连续数列结束的值
	 */
	public static void printContinuousSequence(int small, int big) {
		System.out.print("找到的连续序列:");
		for (int i = small; i <= big; i++)
			System.out.print(i + " ");
		System.out.println();
	}

}
