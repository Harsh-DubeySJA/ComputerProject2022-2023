import java.util.Scanner;

public class Container {
	
	private int getArea(int[] height) {
		int area = 0;
		for (int right = height.length - 1, left = 0, w = right - left, h = Math.min(height[right], height[left]); left < right;) {
			area = Math.max(area, (h * w));
			if (height[right] < height[left]) right--;
			else if (height[left] < height[right]) left++;
			else {
				right--;
				left++;
			}
			w = right - left;
			h = Math.min(height[right], height[left]);
		}
		return area;
	}	
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		Container container = new Container();
		System.out.println(container.getArea(new int[] { 1, 7, 2, 2, 2, 4, 3, 6, 7, 5}));
		sc.close();
	}

}
