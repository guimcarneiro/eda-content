package ae12;

import java.util.Arrays;

public class SomaDois {

	public static int[] two_sum(int[] v, int target) {
		int[] array = new int[] {};
		boolean achouArray = false;
		for(int i=0;i<v.length-1;i++) {
			for(int j=i+1;j<v.length;j++) {
				if(v[i] + v[j] == target) {
					array = new int[] {v[i], v[j]};
					achouArray = true;
					break;
				}
			}
			if(achouArray) {
				break;
			}
		}
		return array;
	}
	
	public static void main(String[] args) {
		
		int[] v1 = new int[] {1, 13, 0, 4, 5};
		System.out.println(Arrays.toString(v1));
		System.out.println(Arrays.toString(two_sum(v1, 5)));
	}
}
