package binary_Search_Tree;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
//import java.util.Arrays;
//import java.util.TreeSet;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * * Problem #3 :
 * Smaller on the right - HARD
 * Given an array arr[] of N elements.
 * The task is to count maximum number of distinct smaller elements on
 * right side of any array element.
 * 
 * For example, in {10, 6, 9, 7, 20, 19, 21, 18, 17, 16}, the result is 4.
 * Note that 20 has maximum 4 smaller elements on right side.
 * Other elements have less count,
 * for example 10 has 3 smaller elements on right side.
 * 
 * 1) Create a tree
 * 10
 * 6 20
 * 9 19 21
 * 7 18
 * 
 * 17
 * 16
 * 2) Count no of nodes root to leftmost for every node
 * 
 * Under aLL circumstance itb is failing
 * 
 * reverse the string array of integers
 * and instead of smaller on right ---> Reverse and find smaller on left
 *
 * 
 * Input
 * 
 * 3
 * 5
 * 5 5 5 5 5
 * 5
 * 6 5 5 5 5
 * 8
 * 36 8 14 52 28 64 8 17
 * 
 * 4
 * 10
 * 10 6 9 7 20 19 21 18 17 16
 * 5
 * 5 4 3 2 1
 * 5
 * 1 2 3 4 5
 * ]
 * 1 2 3 2 1
 * 
 * 
 * 
 * 
 * 1
 * 7
 * 25 82 7 76 34 72 31
 * 
 * 
 * 
 * Duplicate
 * 1
 * 8
 * 36 8 14 52 28 64 8 17
 * 
 * @author shree
 *
 */
public class BST09_Smaller_On_Right {

	public static void main(String[] args) {
		// Use buffered reader

		try {
			// Create a PrintStream for writing to a file
			// PrintStream out = new PrintStream(new
			// FileOutputStream("C:\\Users\\shree\\Documents\\outputoutput_smallerOnRight.txt"));

			// Redirect System.out to the file
			// System.setOut(out);

			int data = 0;
			int c = 0;
			BufferedReader Br = new BufferedReader(new InputStreamReader(System.in));

			int t = Integer.parseInt(Br.readLine().trim());

			while (t-- > 0) {

				int n = Integer.parseInt(Br.readLine().trim());

				String[] arr = Br.readLine().trim().split(" ");
				n = arr.length;
				// n=arr.length;
				// Fucking read
				// Better fucking read eerything in terminal before pproceesing
				// That it will hit in next test case
				// if(n>0) {
				// System.out.println(" N "+n);
				// // return;
				// }
				// if(n==0) {
				// System.out.println();
				// }
				// else if(n==1) {
				// System.out.println(0);
				// }
				// else
				{
					Maxim = 0;
					hs = new HashSet<>();
					// String arr[]=s.split(" ");
					// Reverse the array of int and insert
					data = Integer.parseInt(arr[n - 1]);// last as root
					BSTLCNode root = new BSTLCNode(data);
					hs.add(data);
					System.out.println("Array " + Arrays.toString(arr));
					CountArr = new int[n];
					for (int i = n - 2; i > -1; i--) {
						// Insert reverse
						// System.out.println(" Inserting...."+data);
						data = Integer.parseInt(arr[i]);
						if (!hs.isEmpty() && !hs.contains(data)) {
							c = InsertReverse(root, data);
							System.out.println(" Inserting...." + data + " count " + c);
							System.out.println("=================+maxim" + Maxim);
							// ViewCountBST(root);
							System.out.println();
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

					System.out.println();
					ca = 0;
					ViewCountBST(root);

					System.out.println();
					System.out.println(Arrays.toString(CountArr));

					int ans = GoRightMost(root, 0);
					System.out.println(" Rightmost " + ans);

					ans = GLeftMost(root);
					System.out.println(" Left a");

					System.out.println(" HS " + hs.size());
				}

				// totalCount--;
			}
			// out.close();
			Br.close();
		} catch (Exception e) {
			System.out.println(" Error " + e);
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
				// go left
				// root.updateCount();
				// UpdateAllRight(root.right);
				// Maxim=Math.max(Maxim,count);
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
					// root.right=new BSTLCNode(data);
					break;
				} else {
					root = root.right;
				}

			}
		}
		// Maxim=Math.max(Maxim, count);
		// System.out.println(" Count of "+data+"...."+count);
		return (count - 1);
	}

	private static int GoRightMost(BSTLCNode root, int c) {
		// go right
		if (root == null) {
			return 0;
		}
		c = c + root.count;
		System.out.println(" Curr " + root.data + "--->" + root.count);
		GoRightMost(root.right, c);
		return c;
	}

	private static int GLeftMost(BSTLCNode root) {
		// go right
		if (root == null) {
			return 0;
		}
		// c=c+root.count;
		System.out.println(" Curr " + root.data + "--->" + root.count);
		int c = GLeftMost(root.left) + root.data;
		return c;
	}

	static HashSet<Integer> hs;
	static int CountArr[];
	static int ca;

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

	static int Maxim;

	/*
	 * private static void MAIN1() {
	 * BufferedReader Br=new BufferedReader(new InputStreamReader(System.in));
	 * 
	 * 
	 * try {
	 * int data=0;
	 * int Tree_count=Integer.parseInt(Br.readLine());
	 * while(Tree_count>0) {
	 * maxCount=0;
	 * int n=Integer.parseInt(Br.readLine());
	 * if(n==0) {
	 * System.out.println();
	 * continue;
	 * }
	 * if(n==1) {
	 * System.out.println("1");
	 * continue;
	 * }
	 * //We have no of nodes in a tree
	 * String s=Br.readLine();
	 * String arrS[]=s.split(" ");
	 * //int arr[]=new int[n];
	 * BSTLCNode root=new BSTLCNode(Integer.parseInt(arrS[0]));
	 * for(int i=1;i<n;i++) {
	 * //Calling insert here
	 * //arr[i]=
	 * data=Integer.parseInt(arrS[i]);
	 * InsertWithCount(root,data);
	 * }
	 * //System.out.println(Arrays.toString(arr));
	 * System.out.println(maxCount);
	 * Tree_count--;
	 * ViewCountBST(root);
	 * Br.close();
	 * }
	 * 
	 * }
	 * catch(Exception e) {
	 * System.out.println(" error "+e);
	 * }
	 * 
	 * }
	 * static TreeSet<Integer> ts;static int maxCount;
	 * private static void InsertWithCount(BSTLCNode root,int data) {
	 * // insert
	 * //int currCount=0;
	 * while(root!=null) {
	 * 
	 * //Not needed
	 * // if(root.data==data) {
	 * // return;
	 * // root.updateCount();
	 * // )maxCount=Math.max(root.count,maxCount);
	 * //}
	 * 
	 * if(root.data<data) {
	 * if(root.right==null) {
	 * root.right=new BSTLCNode(data);
	 * return;
	 * }
	 * //Go to right
	 * root=root.right;
	 * }
	 * else {
	 * //Update root and its right
	 * //Updating must be done regardless of adding data or not
	 * if(root.data!=data) {
	 * root.updateCount();
	 * }
	 * maxCount=Math.max(root.count,maxCount);
	 * UpdateAllRight(root.right);
	 * 
	 * if(root.left==null) {
	 * root.left=new BSTLCNode(data);
	 * return;
	 * }
	 * //Go to left
	 * //currCount=root.count+1;
	 * root=root.left;
	 * }
	 * }
	 * }
	 */
	private static void UpdateAllRight(BSTLCNode root) {
		// update all nodes

		if (root == null) {
			return;
		}

		root.updateCount();
		// =Math.max(root.count,maxCount);
		UpdateAllRight(root.left);
		UpdateAllRight(root.right);

	}

	private static void ViewCountBST(BSTLCNode root) {
		if (root == null) {
			return;
		}

		ViewCountBST(root.left);
		// System.out.print("<--");
		System.out.print(root.data + " ");
		CountArr[ca] = root.count;
		ca++;
		// System.out.print("-->");
		ViewCountBST(root.right);
	}

}

class BSTLCNode {
	int count;
	int data;
	BSTLCNode left, right;

	public BSTLCNode(int d) {
		count = 0;
		data = d;
		left = null;
		right = null;
	}

	public void setCount(int c) {
		this.count = c;
	}

	public void updateCount() {
		this.count = this.count + 1;
	}
}
