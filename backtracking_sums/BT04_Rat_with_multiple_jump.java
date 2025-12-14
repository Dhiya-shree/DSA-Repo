package backtracking_sums;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BT04_Rat_with_multiple_jump {

	public static void main(String[] args) {
		// rat with multiple jumps 
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  try {
		int n=Integer.parseInt(br.readLine().trim());
		int maze[][]=new int[n][n];
		int t=0;
		while(t<n) {
			String s[]=br.readLine().trim().split(" ");
			for(int i=0;i<n;i++) {
				maze[t][i]=Integer.parseInt(s[i]);
			}
			t++;
		}
		
		System.out.println(" Maze is ");
		 for(int k=0;k<n;k++){
             for(int l=0;l<n;l++){
                 System.out.print(maze[k][l]+" ");
             }
              System.out.println();
         }
		 
		solve(maze,n);
	} catch (Exception e) {
		e.printStackTrace();
	} 
	  
	  
	
	}

	public static void solve(int[][] maze, int N)
    {
        // add your code here
     visited=new int[N][N];ans=new int[N][N];
        shortPath=Integer.MAX_VALUE;
      //  recur(maze,N,0,0,0);
    if(recur(maze,N,0,0,0)){
        for(int k=0;k<N;k++){
               for(int l=0;l<N;l++){
                   System.out.print(ans[k][l]+" ");
               }
                System.out.println();
           }
    }
    else{
         System.out.println("-1");
    }
    }
    
    
    static int visited[][];static int shortPath;static int ans[][];
    public static boolean recur(int[][] maze, int n,int i,int j,int path){
       if(i==n-1 && j==n-1){
           visited[i][j]=1;
           if(path<shortPath){
               shortPath=path;
               for(int k=0;k<n;k++){
               for(int l=0;l<n;l++){
                   ans[k][l]=visited[k][l];
               }
             //   System.out.println();
           }
           }
           return true;
       }
        if(isSafe(maze,n,i,j,path)){
            System.out.println(i+" - "+j);
            visited[i][j]=1;
            int val=maze[i][j];
            //For reaching destination with same hops
            //Forward 
            boolean anb=false;
           
          // From less hops to more hops 
            for(int l=1;l<=val;l++) {
            	  // Downward 
            	  boolean path3=recur(maze,n,i,j+l,path+l); 
            	  // Downward 
              boolean path1=recur(maze,n,i+l,j,path+l); 

            anb=anb||path1||path3;

            if(anb==true) {
            	break;
            }
            }
            
            
            
          visited[i][j]=0;
          
          if(anb){
              return true;
          }
        }
        
        return false;
    }
    
     public static boolean isSafe(int[][] maze, int n,int i,int j,int path){
      if(i<n && i>=0 && j<n && j>=0 && maze[i][j]>0 && path<shortPath){
          return true;
      }
         return false;
     }
}
