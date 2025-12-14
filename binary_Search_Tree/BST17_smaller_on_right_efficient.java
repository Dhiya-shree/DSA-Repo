package binary_Search_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * {@link #BST17_smaller_on_right_efficient()}
 * Continuation .....
 * 
 * @author shree
 *
 */
public class BST17_smaller_on_right_efficient {

	public static void main(String[] args) {
		// ans for smaller on right
		try {
			BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));

			int t = Integer.parseInt(Br.readLine().trim());

			while (t-- > 0) {

				int n = Integer.parseInt(Br.readLine().trim());

				String[] arr = Br.readLine().trim().split(" ");

				// Our own more efficient - 0.63 secs
				Augumented_SmallerOnright(arr, n);

				// GoG ans TreeSet - 3.51 secs
				TreeSet_HeadSet(arr, n);

			}
			Br.close();
		} catch (Exception e) {
			System.out.println(" Error observed --->" + e);
		}

	}

	private static void TreeSet_HeadSet(String[] arr, int n) {
		// Use tree set

		int array[] = new int[n];
		int c = 0;
		for (int i = n - 1; i >= 0; i++) {
			array[c] = Integer.parseInt(arr[i]);
		}
		// We have reversed array
		System.out.println(" Array rev :" + arr.toString());

		// Add one by one to tree set and use HeadSet operation
		TreeSet<Integer> Ts = new TreeSet<>();
		Ts.add(array[0]);
		int countMax = 0;
		SortedSet<Integer> curr = null;
		for (int i = 1; i < n; i++) {
			curr = Ts.headSet(array[i]);
			countMax = Math.max(countMax, curr.size());
			Ts.add(array[i]);
		}

		System.out.println(" Ans max " + countMax);
	}

	static int Maxim;

	public static void Augumented_SmallerOnright(String arr[], int n) {

		int data = 0;
		int c = 0;
		n = arr.length;
		// n=arr.length;
		// Fucking read
		// Better fucking read eerything in terminal before pproceesing
		// That t will hit in next test case
		// if(n>0) {
		// System.out.println(" N "+n);
		// // return;
		// }
		if (n == 0) {
			System.out.println();
		} else if (n == 1) {
			System.out.println(0);
		} else {
			Maxim = 0;
			hs = new HashSet<>();
			// String arr[]=s.split(" ");
			// Reverse the array of int and insert
			data = Integer.parseInt(arr[n - 1]);// last as root
			BSTLCNode root = new BSTLCNode(data);
			hs.add(data);
			// System.out.println("Array "+Arrays.toString(arr));
			// CountArr=new int[n];
			for (int i = n - 2; i > -1; i--) {
				// Insert reverse
				// System.out.println(" Inserting...."+data);
				data = Integer.parseInt(arr[i]);
				if (!hs.isEmpty() && !hs.contains(data)) {
					c = InsertReverse(root, data);
					// System.out.println(" Inserting...."+data+" count "+c);
					// System.out.println("=================+maxim"+Maxim);
					// ViewCountBST(root);
					// System.out.println();
					hs.add(data);
				} else {
					// Just count for duplicate data , that are high and can have higher count
					// Do not insert
					c = FindLesser(root, data);
					Maxim = Math.max(c, Maxim);
				}
			}
			System.out.println("----------------------------------------------------");
			System.out.println(Maxim);

		}

	}

	private static int FindLesser(BSTLCNode root, int data) {
		// go left and right and share count
		int count = 0;
		if (root == null) {
			return 0;
		}

		while (root != null) {

			if (root.data > data) {
				// go left Do not update already present element
				// root.updateCount();
				if (root.left == null) {
					// root.left=new BSTLCNode(data);
					break;
				} else {
					root = root.left;
				}

			} else {
				// data is big go right
				count = root.count + count + 1;
				if (root.right == null) {
					// Do not add data already element present
					// Just taking count leser than curr data
					// root.right=new BSTLCNode(data);
					break;
				} else {
					root = root.right;
				}

			}
		}
		// Maxim=Math.max(Maxim, count);
		// System.out.println(" Count of "+data+"...."+count);
		// -1 done to remove the consideration of duplicate already we have
		return (count - 1);
	}

	static HashSet<Integer> hs;

	private static int InsertReverse(BSTLCNode root, int data) {
		// insert bas
		int count = 0;
		if (root == null) {
			return 0;
		}

		while (root != null) {

			if (root.data > data) {
				// go left
				root.updateCount();
				// UpdateAllRight(root.right);
				Maxim = Math.max(Maxim, count);
				if (root.left == null) {
					root.left = new BSTLCNode(data);
					break;
				} else {
					root = root.left;
				}

			} else {
				// data is big go right
				count = root.count + count + 1;
				if (root.right == null) {
					root.right = new BSTLCNode(data);
					break;
				} else {
					root = root.right;
				}

			}
		}
		Maxim = Math.max(Maxim, count);
		// System.out.println(" Count of "+data+"...."+count);
		return count;

	}

}
