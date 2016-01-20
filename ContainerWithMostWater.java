package net.test.testng.leetcode;

import org.junit.Test;

public class ContainerWithMostWater {

	/**
	 * orginal method -- time exceeded.
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		if (height == null || height.length <= 1) {
			return 0;
		}
		int i = 0, j = height.length - 1;
		int max = 0;
		// complexity: n^2 in time ,1 in space.
		for (i = 0; i < height.length; i++) {
			for (j = i + 1; j < height.length; j++) {
				int current = (height[i] > height[j] ? height[j] : height[i])
						* (j - i);
				max = current > max ? current : max;
			}
		}

		while (i < j) {
			int current = (height[i] > height[j] ? height[j] : height[i])
					* (j - i);
			max = current > max ? current : max;

		}

		return max;
	}

	/**
	 * adavanced method
	 * @param height
	 * @return
	 */
	public int maxAreaAdv(int[] height) {

		if (height == null || height.length <= 1) {
			return 0;
		}

		int low = 0, high = height.length - 1;
		int max = 0;
		while (low < high) {
			//  record current head and tail's height
			int lowMax = height[low], highMax = height[high];
			//  calculate the container's space
			int area = (high - low)
					* (height[low] < height[high] ? height[low] : height[high]);
			max = max > area ? max : area;

			// filter out all smaller container between head and tail
			if (height[low] <= height[high]) {
				while (height[low] <= lowMax && low < height.length - 1) {
					low++;
				}
			} else {
				while (height[high] <= highMax && high > 0) {
					high--;
				}
			}

		}

		return max;
	}

	@Test
	public void test() {

		int[] testData = new int[30000];
		for (int i = 0; i < 30000; i++) {
			testData[i] = i + 1;
		}
		System.out.println(maxArea(testData));

	}

}
