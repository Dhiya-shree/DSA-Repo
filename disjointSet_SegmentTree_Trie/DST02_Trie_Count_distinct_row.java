package disjointSet_SegmentTree_Trie;

/**
 * 
 * Count Distinct rows n a matrix 
 * 
 * Given a matrix , find the distinct number of rows
 * 
 * ex : 
 * Matrix:  1 0 0
 *          1 1 1
 *          1 0 0
 *          1 1 1
 *  No of distinct matrix= 2 ( 1 0 0, 1 1 1)
 *  
 * Matrix:  1 0 0
 *          1 0 0
 *          1 0 0
 *          1 1 1
 *  No of distinct matrix= 2 ( 1 0 0, 1 1 1)
 *  
 * Matrix:  1 0 0
 *          1 0 0
 *          1 0 0
 *          1 0 0
 *  No of distinct matrix= 1 ( 1 0 0)
 *  
 *  Naive sol :
 *  
 *  O mxN for mxN matrix
 *  
 *  Traverse all row 
 *  Check if each row similar to above row 
 *  if same - do not increment 
 *  if NOT - increment res
 *  return ans
 *  
 *  
 *  O mx2 
 *  Use Trie data 
 *  
 *  
 *  
 *  
 * 
 * @author shree
 *
 */


class TrieBinary{
	
	TrieBinary child[]=new TrieBinary[2];
	
}

public class DST02_Trie_Count_distinct_row {

	public static void main(String[] args) {
		// find distinct 
		

		boolean matrix[][]= {{true,true,false,true},
				{true,false,false,true},
				{true,true,false,true}};
		int m=matrix.length;
		int n=matrix[0].length;	
		
		int count=CountUnique(matrix,m,n);
		System.out.println(" Unique count is "+count);
		
		}

	private static int CountUnique(boolean[][] matrix, int m, int n) {
		// try to add
		// if inset=true new seq added 
		// if insert=false old
		
		TrieBinary root=new TrieBinary();
		int res=0;
		for(int i=0;i<m;i++) {
		
			boolean insert=InsertCurrentInTrie(matrix[i],n,root);
			if(insert) {
				res++;
			}
		}
		return res;
	}
				

	

	private static boolean InsertCurrentInTrie(boolean[] bs, int n, TrieBinary root) {
		//insert array of true false in root 
		
		boolean id=false;boolean isNew=false;int idx=0;
		for(int i=0;i<n;i++) {
		id=bs[i];
		idx=id?1:0;
		
		if(root.child[idx]==null) {
			isNew=true;
			root.child[idx]=new TrieBinary();
		}
		else {
			// nothng to do 
			//already exist 
		}
		
		if(i!=n-1) {
		root=root.child[idx];
		}
		
		}
		
		return isNew;
	}

}
