import java.util.Scanner;

public class MaxHeap_11279 {
	public static int lastIndex = 0;
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	public static void poll(int[] arr) {
		arr[1] = arr[lastIndex];
		arr[lastIndex] = 0;
		lastIndex--;
		
		int index = 1;
		while(true) {
			int leftChildIndex = index*2;
			int rightChildIndex = index*2+1;
			
			if(leftChildIndex>lastIndex) break;
			
			if(rightChildIndex<=lastIndex) {
				if(arr[index] > arr[leftChildIndex] && arr[index] > arr[rightChildIndex]) {
					break;
				}
				else if(arr[leftChildIndex]>arr[rightChildIndex]) {
					swap(arr, index, leftChildIndex);
					index = leftChildIndex;
				}else {
					swap(arr, index, rightChildIndex);
					index = rightChildIndex;
				}
			}else {
				if(arr[index] > arr[leftChildIndex]) break;
				else {
					swap(arr, index, leftChildIndex);
					index = leftChildIndex;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}
	
	public static void add(int value, int[] arr) {
        lastIndex++;
		int index=lastIndex;
		arr[lastIndex] = value;
        
		while(true) {
			if(index/2<=0) break;
			int parentValue = arr[index/2];
			if(arr[index] > parentValue) {
				int temp = arr[index];
				arr[index] = arr[index/2];
				arr[index/2] = temp;
				
				index /= 2;
			}else {
				break;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		for(int i=0; i<n; i++) {
			int x = sc.nextInt();
			
			if(x==0) {
				System.out.println(arr[1]);
				if(lastIndex!=0) {
					poll(arr);
				}
			}
			else add(x, arr);
		}
	}
}