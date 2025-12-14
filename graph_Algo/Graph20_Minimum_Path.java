package graph_Algo;

/**
 * 
 * Minimum Cost Path
Difficulty: HardAccuracy: 26.99%Submissions: 120K+Points: 8
Given a square grid of size N, each cell of which contains an integer cost that represents a cost to traverse through that cell, we need to find a path from the top left cell to the bottom right cell by which the total cost incurred is minimum.
From the cell (i,j) we can go (i,j-1), (i, j+1), (i-1, j), (i+1, j).  

Examples :

Input: grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}}
Output: 43
Explanation: The grid is-
9 4 9 9
6 7 6 4
8 3 3 7
7 4 9 10
The minimum cost is-
9 + 4 + 7 + 3 + 3 + 7 + 10 = 43.
Input: grid = {{4,4},{3,7}}
Output: 14
Explanation: The grid is-
4 4
3 7
The minimum cost is- 4 + 3 + 7 = 14.
Expected Time Complexity: O(n2*log(n))
Expected Auxiliary Space: O(n2) 
 Constraints:
1 ≤ n ≤ 500
1 ≤ cost of cells ≤ 500
 * 
 * 
 */
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MinPath{
	int i,j;
	MinPath(int x,int y){
		i=x;j=y;
	}
}

public class Graph20_Minimum_Path {

	 //Function to return the minimum cost to react at bottom
		//right cell from top left cell.
	public static void main(String[] args) {
	
	        // Code here
	        
	        // Use Prim spanning 
	        
	        // From examples Key length = grid length +1
	        
	        // Alwways from 0,0 to V,V 
	        
	        // So go only bottom / left 
		
		int grid[][] = null;
		BufferedReader Br=new BufferedReader(new InputStreamReader(System.in));
		try {
			PrintStream out = new PrintStream(new FileOutputStream("C:\\Users\\shree\\Documents\\outputoutput_MinimumPath.txt"));
			System.setOut(out);
			int T=Integer.parseInt(Br.readLine().trim());
			 grid=new int[T][T];
			int c=0;
			while(T-->0) {
				String s[]=Br.readLine().split(" ");
				for(int i=0;i<s.length;i++) {
					grid[c][i]=Integer.parseInt(s[i].trim());
				}
				c++;
			}
			
			 Br.close();
			
		} catch (Exception e) {
			// error 
			e.printStackTrace();
		}
		
		
	        
	        int V=grid.length;
	       int  minans=0;
	        // Just go with DFS 
	        visited=new int[V][V];
	        visitedB=new boolean[V][V];
	        boolean [][]visitedC=new boolean[V][V];
	        minans=minimumCostPath(grid);//DFSMinCost(grid,V,V-1,V-1,0,visitedC);//i,j,ans,steps
	        MIMI=20;
	        System.out.println();
	        System.out.println(" Minimum is ");
	       for(int i=0;i<50 && i<V;i++){
	            System.out.println(Arrays.toString(visited[i]));
	        }
	        System.out.println("Ans -->"+minans);
	        
	    //    System.out.println(" Asn 2"+MIMI);
	        
	      //  System.out.println(Arrays.toString(visited[1]));
	        
	        
	       
	      
	    }
	
	//Function to return the minimum cost to react at bottom
		//right cell from top left cell.
	    public static int minimumCostPath(int[][] grid)
	    {
	      
	      int V=grid.length;
	      visited=new int[V][V];
	      int c=V-1;
	      for(int i=V-1;i>=0;i--){
	          for(int j=V-1;j>=0;j--){
	              
	              
	        	 // if(j==i) {
	                  // source destination grid/path
	                  DFSN(i,j,V-1,V-1,grid,V);
	        	  //}
	        	 
	          }
	          for(int j=0;j<V;j++){
	        	  
	        	  CheckSideWays(i,j,grid,V);
	        	 // CheckSideWays(i-c,j,grid,V);
	          }
	          
	          c--;
	          
	          
	         System.out.println(Arrays.toString(visited[i]));
	      }
	      
	      System.out.println(" Ans ------>>>>>>");
	      for(int i=0;i<V;i++) {
	    	  System.out.println(Arrays.toString(visited[i]));
	      }
	      
	      
	      visited2=new boolean[V][V];minAns=Integer.MAX_VALUE;
	      // TRy DFS with visited continue with minimum path 
	      DFSFromDestination(grid,V-1,V-1,V,0);
	      
	      System.out.println(" Ans is "+minAns);
	   
	      visited2=new boolean[V][V];minAns=Integer.MAX_VALUE;
	      // TRy DFS with visited continue with minimum path 
	      DFSFromDestinationVisited(grid,0,0,V,0);
	      
	      System.out.println(" Ans is>>> "+minAns);
	       return visited[0][0];
	       
	        
	     }
	     
	    static boolean visited2[][];static int minAns;
	     private static int DFSFromDestination(int[][] grid, int i, int j, int V,int ans) {
		//DFS with visited and grid 
	    	 
	     if(i==0 && j==0) {
	    	 minAns=Math.min(minAns,ans+grid[i][j]);
	    	 System.out.println(" Ans "+ans+grid[i][j]);
	    	 return minAns;
	     }
	     
	 
	     if(visited2[i][j]==false) {
	    	 System.out.println(i+"-"+j+"=="+grid[i][j]+"  "+ans);
	    	 visited2[i][j]=true;
	    	 int minAll=Integer.MAX_VALUE;
	    	 int min1=Integer.MAX_VALUE;
	    	 int min2=Integer.MAX_VALUE;
	    	 int min3=Integer.MAX_VALUE;
	    	 int min4=Integer.MAX_VALUE;
	    	 
	    	 //ans set 
	    	 ans=ans+grid[i][j];
	    	 if(i+1<V && visited2[i+1][j]==false) {
	    		 min1=DFSFromDestination(grid,i+1, j, V, ans);
	    		minAll=Math.min(minAll, min1);
	    	 }
	    	 if(j+1<V && visited2[i][j+1]==false) {
	    		 min2= DFSFromDestination(grid,i,j+1, V, ans);
	    		minAll=Math.min(minAll, min2);
	    	 }
	    	 if(i-1>-1 && visited2[i-1][j]==false) {
	    		 min3= DFSFromDestination(grid,i-1, j, V, ans);
	    		minAll=Math.min(minAll, min3);
	    	 }
	    	 if(j-1>-1 && visited2[i][j-1]==false) {
	    		 min4= DFSFromDestination(grid,i,j-1, V, ans);
	    		minAll=Math.min(minAll, min4);
	    	 }
	    	 visited2[i][j]=false;
	    	 return minAll;
	     }
		return visited[i][j];
	}
	     
	     
	//     static boolean visited2[][];static int minAns;
	     private static void DFSFromDestinationVisited(int[][] grid, int i, int j, int V,int ans) {
		//DFS with visited and grid 
	    	 
	     if(i==V-1 && j==V-1) {
	    	 minAns=Math.min(minAns,ans+grid[i][j]);
	    	 System.out.println(" ///////////"+minAns+"-------------"+(ans+grid[i][j]));
	    	 return;
	     }
	     
	     
	     if(visited2[i][j]==false) {
	    	 System.out.println(i+"-"+j+"=="+grid[i][j]+"  "+ans);
	    	 visited2[i][j]=true;
	    	 int minAll=Integer.MAX_VALUE;
	    	 int min1=Integer.MAX_VALUE;
	    	 int min2=Integer.MAX_VALUE;
	    	 int min3=Integer.MAX_VALUE;
	    	 int min4=Integer.MAX_VALUE;
	    	 
	    	 //ans set 
	    	 
	    	 ans=ans+grid[i][j];
	    	 if(i+1<V && visited2[i+1][j]==false) {
	    		 min1=visited[i+1][j];
	    		minAll=Math.min(minAll, min1);
	    	 }
	    	 if(j+1<V && visited2[i][j+1]==false) {
	    		 min2=visited[i][j+1];
	    		minAll=Math.min(minAll, min2);
	    	 }
	    	 if(i-1>-1 && visited2[i-1][j]==false) {
	    		 min3=visited[i-1][j];
	    		minAll=Math.min(minAll, min3);
	    	 }
	    	 if(j-1>-1 && visited2[i][j-1]==false) {
	    		 min4=visited[i][j-1];
	    		minAll=Math.min(minAll, min4);
	    	 }
	    	 System.out.println(i+"-"+j+"=="+grid[i][j]+"  "+ans+" max 1:"+min1+" 2:"+min2+" 3:"+min3+" 4:"+min4+" Min all "+minAll);
	    	 
	    	 if(minAll!=Integer.MAX_VALUE) {
	    	 if(minAll==min1) {
	    		 DFSFromDestinationVisited(grid,i+1, j, V, ans);
	    	 }
	    	 if(minAll==min2) {
	    		 DFSFromDestinationVisited(grid,i,j+1, V, ans);
	    	 }
	    	 if(minAll==min3) {
	    		 DFSFromDestinationVisited(grid,i-1, j, V, ans);
	    	 }
	    	 if(minAll==min4) {
	    		 DFSFromDestinationVisited(grid,i,j-1, V, ans);
	    	 }
	    	 }
	    	 
	     }
		
	}

		private static void CheckUpDown(int i, int j, int[][] grid, int V) {
		// for up down checks 
	    	 int val=Integer.MAX_VALUE;
	    	 if(i==-1) {
	    		 return;
	    		
	    	 }
	    	 
	    	 if(visited[i][j]!=0) {
	    		 val=visited[i][j]-grid[i][j];
	    	 }
	    	 
	    	/* if(i-1>-1 && visited[i-1][j]!=0 && visited[i-1][j]<val) {
		    	  val=visited[i-1][j];
		      }*/
		      if(i+1<V &&  visited[i+1][j]!=0 && visited[i+1][j]<val) {
		    	  val=visited[i+1][j];
		      }
		      
		      visited[i][j]=val+grid[i][j];
		
	}
	     /*
	      6
1 1000 1 1 1 1
1 1 1 1000 1000 1
1000 1000 1000 1 1 1
1 10000 1000 1 1000 1000
1000 10000 1000 1 2000 200
1 10000 1000 1 1 2 
	      
	      */

		private static void CheckSideWays(int i, int j, int[][] grid, int v) {
		// for sideway checking 
			
	    	 int val=0;
	    	 if(visited[i][j]==0) {
	    		 val=Integer.MAX_VALUE;
	    	 }
	    	 else {
	    		 val=visited[i][j]-grid[i][j];
	    	 }
	    	
	      if(j-1>-1 && visited[i][j-1]!=0 && visited[i][j-1]<val) {
	    	  val=visited[i][j-1];
	    	  System.out.println(visited[i][j-1]);
	      }
	     
	      if(j+1<v && visited[i][j+1]!=0 && visited[i][j+1]<val) {
	    	  val=visited[i][j+1];
	    	  System.out.println(visited[i][j+1]);
	      }
	     
	    /*  if(i-1>-1 && visited[i-1][j]!=0 && visited[i-1][j]<val) {
	    	  val=visited[i-1][j];
	    	  System.out.println(visited[i-1][j]);
	      }*/
	      if(i+1<v &&  visited[i+1][j]!=0 && visited[i+1][j]<val) {
	    	  val=visited[i+1][j];
	      }
	      visited[i][j]=val+grid[i][j];
	      
		
	}

		static int visited[][];
	      public static void DFSN(int si,int sj,int di,int dj,int[][] grid,int V)
	    {
	        int i=si,j=sj;
	        if(si==di && sj==dj){
	            visited[si][sj]=grid[si][sj];
	            return ;
	        }
	        if(visited[si][sj]==0){
	        	
	             int max1=Integer.MAX_VALUE;;
		             int max2=Integer.MAX_VALUE;;
		             int max3=Integer.MAX_VALUE;;
		             int max4=Integer.MAX_VALUE;;
	            if(si+1<V && visited[si+1][sj]!=0){
	                max1=visited[si+1][sj];
	            }
	            if(si+1>=V){
	             //dn
	            }
	            else{
	                DFSN(si+1,sj,V-1,V-1,grid,V);
	                  max1=visited[si+1][sj];
	            }
	            ////////////////////// J +1
	             if(sj+1<V && visited[si][sj+1]!=0){
	                max2=visited[si][sj+1];
	            }
	            if(sj+1>=V){
	                //dn
	            }
	            else{
	                 DFSN(si,sj+1,V-1,V-1,grid,V);
	                 max2=visited[si][sj+1];
	            }
	            //////////////// i - 1
	             if(si-1>-1 && visited[si-1][sj]!=0){
	                max3=visited[si-1][sj];
	            }
	            if(si-1<0){
	                //dn
	            }
	            else{
	               //  DFSN(si-1,sj,V-1,V-1,grid,V);
	                 max3=visited[si-1][sj];
	            }
	            
	             if(sj-1>-1 && visited[si][sj-1]!=0){
	                max4=visited[si][sj-1];
	            }
	            if(sj-1<0){
	                //dn
	            }
	            else{
	              //   DFSN(si,sj-1,V-1,V-1,grid,V);
	                  max4=visited[si][sj-1];
	            }
	            
	            visited[i][j]=Integer.MAX_VALUE;
	            if( max1!=Integer.MAX_VALUE && max1!=0 && max1<visited[i][j]){
	                visited[i][j]=max1;
	            }
	            if(max2!=Integer.MAX_VALUE && max2!=0 && max2<visited[i][j]){
	                visited[i][j]=max2;
	            }
	            if(max3!=Integer.MAX_VALUE && max3!=0 && max3<visited[i][j]){
	                visited[i][j]=max3;
	            }
	            if(max4!=Integer.MAX_VALUE && max4!=0 && max4<visited[i][j]){
	                visited[i][j]=max4;
	            }
	            System.out.println(" For "+grid[i][j]+" at "+i+"-"+j+" val is "+visited[i][j]+" max 1-"+max1+" 2-"+max2+" 3-"+max3+" 4-"+max4);
	            if(visited[i][j]==Integer.MAX_VALUE || visited[i][j]==0){
	                visited[i][j]=grid[i][j];
	            }
	            else{
	                 visited[i][j]=grid[i][j]+visited[i][j];
	            }
	            System.out.println(" For "+grid[i][j]+" at "+i+"-"+j+" val is "+visited[i][j]);
	        }
	        
	    }
   

	public static int BFSMinCost(int[][] grid,int V){
	       int minimum=0;

	       Queue<MinPath> q=new ArrayDeque<>();
	       q.add(new MinPath(0,0));
	       MinPath curr=null;
	       int i=0,j=0;
	       boolean visit[][]=new boolean[V][V];	
	       int minCurr=Integer.MAX_VALUE;
	       int mini=Integer.MAX_VALUE;
	       while(!q.isEmpty()) {
	    	   
	    	   int size=q.size();
	    	   for(int k=0;k<size;k++) {
	    		   curr=q.poll();
	    		   
	    		   i=curr.j;
	    		   j=curr.j;
	    		   
	    		   if(i+1<V && visit[i+1][j]==false) {
	    			   q.offer(new MinPath(i+1,j));
	    		   }
	    		   if(j+1<V && visit[i][j+1]==false) {
	    			   q.offer(new MinPath(i,j+1));
	    		   }
	    		   if(i-1>-1 && visit[i-1][j]==false) {
	    			   q.offer(new MinPath(i-1,j));
	    		   }
	    		   if(j-1>-1 && visit[i][j-1]==false) {
	    			   q.offer(new MinPath(i+1,j));
	    		   }
	    		   
	    		   
	    	   }
	    	   
	    	   minCurr=Integer.MAX_VALUE;
	       }
	       
	       
   
       return minimum;
    }
	    
	  //  static int visited[][];
	static boolean visitedB[][];
	    // For U sharpe 
	    // Need to check for back also 
	    // Add a variable prev 
	    // Do not run for prev 
	    static int MIMI;
	     public static int DFSMinCost(int[][] grid,int V,int i,int j,int ans,boolean [][]visitedC){
	       

	         if(i==0 && j==0){
	        	// System.out.println("Ans------------------------------------------------- "+ans);
	        	 return grid[i][j];
	             //must to give return here 
	         }
	       
	         if(visitedC[i][j]==false){
	           //  steps=steps+1;
	        	 
	        	visitedB[i][j]=true;
	             int max1=Integer.MAX_VALUE;
	             int max2=Integer.MAX_VALUE;
	             int max3=Integer.MAX_VALUE;
	             int max4=Integer.MAX_VALUE;
	      //       System.out.print(grid[i][j]+"-->");
	          /**
	           5
1 1 1000 1000 1000
1000 1 1000 1000 1000
1 1 1000 10001 1000
1 10000 10000 1000 1000
1 1 1 1 2
 
6
1 1000 1 1 1 1
1 1 1 1000 1000 1
1000 1000 1000 1 1 1
1 10000 1000 1 1000 1000
1000 10000 1000 1 2000 200
1 10000 1000 1 1 2

	            
	           
	           */
	             if(MIMI>0) {
	             System.out.print(i+"-"+j+"="+grid[i][j]+" ");
	             MIMI--;
	             }
	             boolean set1=false, set2=false,set3=false,set4=false;
	             ans=ans+grid[i][j];
	             if(i+1<V&&  visitedC[i+1][j]) {
	            	// visitedC[i+1][j]=true;
	              max1=visited[i+1][j]; 
	              set1=true;
	            }
	            else if(i+1>=V){
		               // do nothing 
	            	 set1=true;
		           }
	            else {
	            	
	            	max1= DFSMinCost(grid,V,i+1,j,ans,visitedC);
	            }
	            
	             if(j+1<V  && visitedC[i][j+1]) {
	            	max2=visited[i][j+1];
	            	set2=true;
	            }
	            else if(j+1>=V){
	               //do nothing 
	            	set2=true;
	            }
	            else {
	            	DFSMinCost(grid,V,i,j+1,ans,visitedC);
	             }
	             if(max1!=Integer.MAX_VALUE || max2!=Integer.MAX_VALUE) {
	             visited[i][j]=Math.min(max2, max1);
	             }
	        /*    only right and down enough 
	              Always going from left top corner so.....*/
	             if(i-1>-1 && visitedC[i-1][j]) {
	              set3=true;
	            	 max3=visited[i-1][j];
	            }
	           else if( i-1<0){
	        	   //do nothing 
	            	set3=true;
	            }
	           else {
	        	   max3=DFSMinCost(grid,V,i-1,j,ans,visitedC);
	             }
	             if( visited[i][j]!=0 ) {
	             visited[i][j]=Math.min(max3,visited[i][j]);
	             }
	             else if(max3!=Integer.MAX_VALUE ) {
	            	 visited[i][j]=max3;
	             }
	           if(j-1>-1 && visitedC[i][j-1]) {  
	        	   set4=true;
	        	   max4=visited[i][j-1];
	            }
	            else if(j-1<0){
	                set4=true;
	            }
	            else {
	            	max4=DFSMinCost(grid,V,i,j-1,ans,visitedC);
	           }
	           if( visited[i][j]!=0 ) {
		             visited[i][j]=Math.min(max4,visited[i][j]);
		             }
		             else if(max4!=Integer.MAX_VALUE ) {
		            	 visited[i][j]=max4;
		             }
	           visited[i][j]=visited[i][j]+grid[i][j];
	            
	         if(set1 && set2 && set3 && set4) {
	        	 visitedC[i][j]=true;
	         }
	            	
	             //visited[i][j]=Math.min(Math.min(max3, max4),Math.min(max2, max1))+grid[i][j];
	            System.out.println(" I-J "+i+"-"+j+" val "+visited[i][j]+" max1"+max1+" max2"+max2+" max3"+max3+" max4"+max4);
	           
	        }
	       
	       // if available return or set and return 
	             return visited[i][j];
	        
	     }
	     
}


class GFG
{
  public static void main(String[] args) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int T = Integer.parseInt(br.readLine().trim());
      while(T-->0)
      {
          String[] s = br.readLine().trim().split(" ");
          int n = Integer.parseInt(s[0]);
          int[][] grid = new int[n][n];
          for(int i = 0; i < n; i++){
              String[] S = br.readLine().trim().split(" ");
              for(int j = 0; j < n; j++){
                  grid[i][j] = Integer.parseInt(S[j]);
              }
          }
          Solution obj = new Solution();
          int ans = obj.minimumCostPath(grid);
          System.out.println(ans);
      
System.out.println("~");
}
  }
}
//} Driver Code Ends


class Solution
{
  //Function to return the minimum cost to react at bottom
	//right cell from top left cell.
  public int minimumCostPath(int[][] grid)
  {
      // Code here
      int n=grid.length;
      int cost[][]=new int[n][n];
   
      for(int i=0;i<n;i++){
          for(int j=0;j<n;j++){
          cost[i][j]=Integer.MAX_VALUE;
          }
      }
       boolean checked[][]=new boolean[n][n];
         cost[0][0]=grid[0][0];
        q=new PriorityQueue<N>();
        q.add(new N(0,0,0));
        while(!q.isEmpty()){
            N c=q.poll();
            relax(c.i,c.j,grid,cost,n);
       //      System.out.print(q);
            
        }
      //    for(int i=0;i<n;i++){
       //    System.out.println(Arrays.toString(cost[i]));   
        //  }
      return cost[n-1][n-1];//+grid[0][0];
      
  }
 
 PriorityQueue<N> q;
  public void relax(int i,int j,int[][] grid,int cost[][],int n){
      int left,top,right,down=Integer.MAX_VALUE;
      //    PriorityQueue<N> q=new PriorityQueue<N>();
          if(i-1>=0 && cost[i-1][j]>cost[i][j]+grid[i-1][j]){
              cost[i-1][j]=cost[i][j]+grid[i-1][j];
              left=cost[i-1][j];
              q.add(new N(i-1,j,left));
          }
          if(i+1<n && cost[i+1][j]>cost[i][j]+grid[i+1][j]){
              cost[i+1][j]=cost[i][j]+grid[i+1][j];
              right=cost[i+1][j];
              q.add(new N(i+1,j,right));
          }
          if(j-1>=0 && cost[i][j-1]>cost[i][j]+grid[i][j-1]){
              cost[i][j-1]=cost[i][j]+grid[i][j-1];
              down=cost[i][j-1];
              q.add(new N(i,j-1,down));
          }
          if(j+1<n && cost[i][j+1]>cost[i][j]+grid[i][j+1]){
              cost[i][j+1]=cost[i][j]+grid[i][j+1];
              top=cost[i][j+1];
              q.add(new N(i,j+1,top));
          }
          
       
      
  }
  
}
/*
9 4 9 9 
6 7 6 4
8 3 3 7
7 4 9 10

*/

class N implements Comparable<N>{
  int i,j,val;
  N(int a,int b,int v){
      i=a;j=b;val=v;
  }
  
  public int compareTo(N a){
      return this.val-a.val;
  }
  public String toString(){
      return i+"-"+j;
  }
}
