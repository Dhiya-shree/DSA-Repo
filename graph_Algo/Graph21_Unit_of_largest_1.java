package graph_Algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * Unit Area of largest region of 1's
Difficulty: MediumAccuracy: 50.83%Submissions: 71K+Points: 4Average Time: 20m
Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 

Example 1:

Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
Output: 5
Explanation: The grid is-
1 1 1 0
0 0 1 0
0 0 0 1
The largest region of 1's is colored
in orange.
Example 2:

Input: grid = {{0,1}}
Output: 1
Explanation: The grid is-
0 1
The largest region of 1's is colored in 
orange.

Your Task:
You don't need to read or print anyhting. Your task is to complete the function findMaxArea() which takes grid as input parameter and returns the area of the largest region of 1's.


Expected Time Complexity: O(n*m)
Expected Auxiliary Space: O(n*m)
 

Constraints:
1 ≤ n, m ≤ 500
 * 
 * @author shree
 *
 */
public class Graph21_Unit_of_largest_1 {

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
          int m = Integer.parseInt(s[1]);
          int[][] grid = new int[n][m];
          for(int i = 0; i < n; i++){
              String[] S = br.readLine().trim().split(" ");
              for(int j = 0; j < m; j++){
                  grid[i][j] = Integer.parseInt(S[j]);
              }
          }
          Solution obj = new Solution();
          int ans = obj.findMaxArea(grid);
          System.out.println(ans);
      
System.out.println("~");
}
  }
}
//} Driver Code Ends


class Solution
{
  //Function to find unit area of the largest region of 1s.
  public int findMaxArea(int[][] grid)
  {
      // Code here
      grid2=grid;
       n=grid.length;
       m=grid[0].length;
      checked=new boolean[n][m];
      int ans=0;
      for(int i=0;i<n;i++){
          for(int j=0;j<m;j++){
              if(checked[i][j]==false && grid[i][j]==1 ){
                  ans=Math.max(ans,dfs(i,j));
              }
          }
      }
      return ans;
  }
  int grid2[][];
  boolean checked[][];int n;int m;
  public int dfs(int i,int j){
      if(!checked[i][j]){
          checked[i][j]=true;
          int ans=1;
          if(i-1>=0 && !checked[i-1][j] && grid2[i-1][j]==1){
              ans=ans+dfs(i-1,j);
          }
          if(i+1<n && !checked[i+1][j] && grid2[i+1][j]==1){
              ans=ans+dfs(i+1,j);
          }
          if(j+1<m && !checked[i][j+1] && grid2[i][j+1]==1){
              ans=ans+dfs(i,j+1);
          }
          if(j-1>=0 && !checked[i][j-1] && grid2[i][j-1]==1){
              ans=ans+dfs(i,j-1);
          }
          
          if(i-1>=0&& j-1>=0 && !checked[i-1][j-1] && grid2[i-1][j-1]==1){
              ans=ans+dfs(i-1,j-1);
          }
          if(i-1>=0 && j+1<m && !checked[i-1][j+1] && grid2[i-1][j+1]==1){
              ans=ans+dfs(i-1,j+1);
          }
          if(i+1<n && j-1>=0 &&  !checked[i+1][j-1] && grid2[i+1][j-1]==1){
              ans=ans+dfs(i+1,j-1);
          }
          if(i+1<n && j+1<m && !checked[i+1][j+1]  && grid2[i+1][j+1]==1){
              ans=ans+dfs(i+1,j+1);
          }
          return ans;
      }
      return 0;
  }
}
