package backtracking_sums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class BT02_M_Colouring_Problem {

	public static void main(String[] args) {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try {
			int n=Integer.parseInt(br.readLine().trim());
			int m=Integer.parseInt(br.readLine().trim());
			int t=Integer.parseInt(br.readLine().trim());
			String str=br.readLine();
			System.out.println("String : str"+str+" "+n+" "+m+" t "+t);
			String[] s=str.trim().split(" ");
			System.out.println(" String is "+Arrays.toString(s));
			int a=0;
			int b=0;
			int point=0;
			boolean graph[][]=new boolean[n][n];
			ArrayList<ArrayList<Integer>> ari=new ArrayList<>(n);
			for(int i=0;i<n;i++) {
				ari.add(new ArrayList<>());
			}
			while(t-->0) {
				a=Integer.parseInt(s[point].trim());
				b=Integer.parseInt(s[point+1].trim());
				graph[a-1][b-1]=true;// -1 as node val starts  from 0 
				graph[b-1][a-1]=true;
				point=point+2;
				ari.get(a-1).add(b-1);
				ari.get(b-1).add(a-1);
			//	t--;
			}
			
			for(int i=0;i<n;i++) {
				System.out.println(ari.get(i).toString());
			}
			SolutionMcolor sobj=new SolutionMcolor();
			boolean ANS=sobj.graphColoring(graph,m,n);
			System.out.println(" Ans is "+ANS);
			
			System.out.println("--- NO statoic used ");
			System.out.println(" With ansNotSet getting error because of gabage value and refernece also not thread safe ");
			SolveMColour sob=new SolveMColour();
			ANS=sob.graphColoring(graph,m,n);
			System.out.println(" Ans is "+ANS);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
}

class SolveMColour {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
    
    if(m==1 && n==1){
        return true;
    }
    if(m==1 && n>1){
        return false;
    }
        
      // Do simple BFS 
      visited=new int[n];
      for(int i=0;i<n;i++){
          visited[i]=-1;
         System.out.println(Arrays.toString(graph[i]));
      }
      

      System.out.println(" BFS going  ......");
      return BFSAll(graph,n,m);
    
    }
    
     static int visited[];
   //  static boolean ansNotset;
    // static int color;
      boolean BFSAll(boolean graph[][], int n, int m) {
        // dfs
        boolean anb=true;
       for(int i=0;i<n;i++){
    	   
           if(visited[i]<0 ){
        	  System.out.println(" Start with "+i);
           anb=BFSsource(graph,n,m,i);
           System.out.println(" Start with "+i+" Ans "+anb);
           }
           if(anb==false){
               return false;
           }
       }
       return true;
     }
     
       boolean BFSsource(boolean graph[][], int n, int m,int ind) {
          
              Queue<Color> q=new ArrayDeque<Color>();
              q.add(new Color(ind,-1));
              int curr=0;int prevC=-1;int size=0;Color cc=null;int col=0;
              while(!q.isEmpty() ){
                  // has edge
                  size=q.size();
                  for(int j=0;j<size;j++){
                  cc=q.poll();
                  curr=cc.index;
                  prevC=cc.color;
                  System.out.println(curr+"visited "+Arrays.toString(visited));
                  if(visited[curr]<0){
                	  col=isSafe(curr,prevC,graph,n,m,0);
                   if(col!=-1){
                       visited[curr]=col; }
                   else{
                  return false;
                   }
                   for(int i=0;i<n ;i++){
                  if(i!=curr && graph[i][curr]==true  && visited[i]<0){
                        
                      q.add(new Color(i,col));
                  }
                   }
                  }
                  }
              }
              return true;
          }
      
     
      int isSafe(int s,int prev,boolean graph[][],int n,int m,int count){
         
         if(count==m){
        	 System.out.println(" Issue "+s);
             return -1;
         }
         if(prev==-1){
             prev=0;
         }
         else{
         prev=(prev+1)%m;
         }
        System.out.println("color--- "+prev+" index "+s);
         for(int i=0;i<n;i++){
             if(graph[i][s]==true && visited[i]==prev){
                 return isSafe(s,visited[i],graph,n,m,count+1);
             }
         }
         
         
         System.out.println("color Fixed ------- "+prev+" index "+s);
         return prev;
     }
       
}

/*
 * 
 12
4
35
1 3 3 9 7 12 8 9 5 8 6 11 9 12 1 12 11 12 7 9 2 12 10 11 3 10 1 7 6 12 2 4 10 12 4 6 2 11 4 5 6 10 2 10 2 9 7 11 2 5 5 12 7 10 7 8 5 10 4 7 6 9 9 11 1 5 2 3 4 12
 * 
 * 
 */

	class SolutionMcolor{
	 // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public  boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
    
    if(m==1 && n==1){
        return true;
    }
        
      // Do simple BFS 
      visited=new int[n];
      for(int i=0;i<n;i++){
          visited[i]=-1;
   //       System.out.println(Arrays.toString(graph[i]));
      }
      
      ansNotset=true;color=0;
    
      BFSAll(graph,n,m);
      
      return ansNotset;
    
    }
    
     static int visited[];
     static boolean ansNotset;static int color;
     public static void BFSAll(boolean graph[][], int n, int m) {
        // dfs
       for(int i=0;i<n;i++){
           if(visited[i]<0 && ansNotset){
           BFSsource(graph,n,m,i);
           }
       }
     }
     
      public static void BFSsource(boolean graph[][], int n, int m,int ind) {
          
              Queue<Color> q=new ArrayDeque<Color>();
              q.add(new Color(ind,-1));
              int curr=0;int prevC=-1;int size=0;Color cc;
              while(!q.isEmpty() && ansNotset){
                  // has edge
                  size=q.size();
                  for(int j=0;j<size;j++){
                  cc=q.poll();
                  curr=cc.index;
                  prevC=cc.color;
                //  System.out.println(curr+"visited "+Arrays.toString(visited));
                  if(visited[curr]<0){
                   if(isSafe(curr,prevC,graph,n,m,0)){
                       visited[curr]=color;
                    //   prevC=color;
                    
                //   System.out.println("color "+color+" index "+curr);
                   }
   
                   for(int i=0;i<n && ansNotset;i++){
                  if(i!=curr && graph[i][curr]==true && ansNotset && visited[i]<0){
                        
                      q.add(new Color(i,color));
                  }
                   }
                  }
                  }
              }
          }
      
     
     public static boolean isSafe(int s,int prev,boolean graph[][],int n,int m,int count){
         
         if(count==m+1){
        	 ansNotset=false;
             return false;
         }
         if(prev==-1){
             color=0;
         }
         else{
         color=(color+1)%m;
         }
          //          System.out.println("color--- "+color+" index "+s);
         for(int i=0;i<n;i++){
             if(graph[i][s]==true && visited[i]==color){
                 return isSafe(s,visited[i],graph,n,m,count+1);
             }
         }
         return true;
     }
       
	
}//class end

class Color{
    int color;int index;
    Color(int i,int j){
        index=i;
        color=j;
    }
    
}

