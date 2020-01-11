import java.util.Scanner;

public class TreeTraversal_1991 {
	public static int findParentIndex(String[] tree, String parent) {
		int index = 0;
		
		for(int i=1; i<tree.length; i++) {
			if(tree[i] == null) continue;
			if(tree[i].equals(parent)) {
				index = i;
				break;
			}
		}
		return index;
	}
	public static void preorder(String[] tree, int index) {
		if(tree[index] == null) return ;
		
		System.out.print(tree[index]);
		preorder(tree, index*2);
		preorder(tree, index*2+1);
	}
	public static void inorder(String[] tree, int index) {
		if(tree[index] == null) return ;
		
		inorder(tree, index*2);
		System.out.print(tree[index]);
		inorder(tree, index*2+1);
	}
	public static void postorder(String[] tree, int index) {
		if(tree[index] == null) return ;
		
		postorder(tree, index*2);
		postorder(tree, index*2+1);
		System.out.print(tree[index]);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		String[] tree = new String[1000];
		tree[1] = "A";
		
		for(int i=0; i<n; i++) {
			String parent = sc.next();
			String leftChild = sc.next();
			String rightChild = sc.next();
			
			int parentIndex = findParentIndex(tree, parent);
			if(!leftChild.equals(".")) tree[parentIndex*2] = leftChild;
			if(!rightChild.equals(".")) tree[parentIndex*2+1] = rightChild;		
		}
		

		preorder(tree, 1);
		System.out.println();
		inorder(tree, 1);
		System.out.println();
		postorder(tree, 1);	
	}
}
