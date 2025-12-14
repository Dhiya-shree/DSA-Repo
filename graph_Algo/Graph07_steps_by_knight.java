package graph_Algo;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 
 * Steps by Knight
Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.

 

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the initial position of Knight (KnightPos), the target position of Knight (TargetPos), and the size of the chessboard (N) as input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position or return -1 if its not possible.

 

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

 // 8 combo for a knight 
// in 6x6 
// k = 3 , 3 
// 1st 1,2   -2,-1
// 4th 5,2   +2,-1
// 5 1,4   -2,+1
// 6 5,4   +2,+1

// 2nd 2,1   -1,-2
// 3rd 4,1   +1,-2
// 7 2,5   -1,+2
// 8 4,5   +1,+2

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N
 * 
 * @author shree
 *
 */
class PairKmove{
    int i,j;
    PairKmove(int u,int v){
        i=u;
        j=v;
    }
}
public class Graph07_steps_by_knight {

	public static void main(String[] args) {
		// Kntight steps 
		int N=6;
		int k[]= {4,5};
		int t[]= {1,1};
		//Best solution throug Dynamic programming 
		
		// MUST to give corner case 
		// when knight and target in corner 
		// 1,1 knight 2,2 target -> steps 4 needed
       int minSteps=minStepToReachTargetAddCondition(k,t,N);
       System.out.println(" Min steps for knight "+minSteps);
	
       // dynamic 0.13 sec
	   minSteps=minStepToReachTarget(k,t,N);
       System.out.println(" Min steps for knight "+minSteps);

	}

	//0.37 time  //Function to find out minimum steps Knight needs to reach target position.
    public static int minStepToReachTargetAddCondition(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        int i=KnightPos[0];
        int j=KnightPos[1];
       x=TargetPos[0];
       y=TargetPos[1];
        int ix=0;int jy=0;
        if(Math.abs(x-i)==1 && Math.abs(y-j)==1){
            return 4;
        }
        

        //Lets use BFS 
        int ans=0;
        boolean visited[][]=new boolean[N][N];
        Queue<PairKmove> q=new ArrayDeque<>();
        q.add(new PairKmove(i,j));int size=0;PairKmove curr=null;
        while(!q.isEmpty()){
            size=q.size();
         //   System.out.println(size);
            for(int k=0;k<size;k++){
                curr=q.poll();
                i=curr.i;j=curr.j;
                if(visited[i-1][j-1]==false){
                visited[i-1][j-1]=true;
                if(i==x && j==y){
                    return ans;
                }
               
               // diff between curr and target  
                ix=Math.abs(i-x);
                jy=Math.abs(j-y);
                {// Put others in  8 possible combo ee
               if(i-2>0 && j-1>0 && visited[i-2-1][j-1-1]==false&&isCloser(i-2,j-1,ix,jy)){
                   q.offer(new PairKmove(i-2,j-1));
               }
               if(i+2<=N && j-1>0 && visited[i+2-1][j-1-1]==false&&isCloser(i+2,j-1,ix,jy)){
                   q.offer(new PairKmove(i+2,j-1));
               }
               if(i-2>0 && j+1<=N && visited[i-2-1][j+1-1]==false
               &&isCloser(i-2,j+1,ix,jy)){
                   q.offer(new PairKmove(i-2,j+1));
               }
               if(i+2<=N && j+1<=N && visited[i+2-1][j+1-1]==false&&isCloser(i+2,j+1,ix,jy)){
                   q.offer(new PairKmove(i+2,j+1));
               }
               //next 4 
               if(i-1>0 && j-2>0 && visited[i-1-1][j-2-1]==false&&isCloser(i-1,j-2,ix,jy)){
                   q.offer(new PairKmove(i-1,j-2));
               }
               if(i+1<=N && j-2>0 && visited[i+1-1][j-2-1]==false&&isCloser(i+1,j-2,ix,jy)){
                   q.offer(new PairKmove(i+1,j-2));
               }
               if(i-1>0 && j+2<=N && visited[i-1-1][j+2-1]==false&&isCloser(i-1,j+2,ix,jy)){
                   q.offer(new PairKmove(i-1,j+2));
               }
               if(i+1<=N && j+2<=N && visited[i+1-1][j+2-1]==false&&isCloser(i+1,j+2,ix,jy)){
                   q.offer(new PairKmove(i+1,j+2));
               }
                }//Adding in Queue ends 
                
            }
         
              
        }ans=ans+1;//Counting steps  
        }
        return -1;
    }
    
    static int x,y;
    static boolean isCloser(int a,int b,int previ,int prevj){
        if((Math.abs(a-x)<=previ)  || (Math.abs(b-y)<=prevj)){
            return true;
        }
        return false;
        //Without this q -> 1 6 23 41 
        //With check q ->1 5 19 24 
    }
    
    private static int minStepsHelper(int KnightPos[], int TargetPos[], int[][] dp) {
		// If knight is on the target position return 0.
		if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
			return 0;
		} else {
			// If already calculated then return that value.
			if (dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
					.abs(KnightPos[1] - TargetPos[1])] != 0) {
				return dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])];
			} else {
				int x1, y1, x2, y2;
				// (x1, y1) and (x2, y2) are the two positions which will be considered.
				if (KnightPos[0] <= TargetPos[0]) {
					if (KnightPos[1] <= TargetPos[1]) {
						x1 = KnightPos[0] + 2;
						y1 = KnightPos[1] + 1;
						x2 = KnightPos[0] + 1;
						y2 = KnightPos[1] + 2;
					} else {
						x1 = KnightPos[0] + 2;
						y1 = KnightPos[1] - 1;
						x2 = KnightPos[0] + 1;
						y2 = KnightPos[1] - 2;
					}
				} else {
					if (KnightPos[1] <= TargetPos[1]) {
						x1 = KnightPos[0] - 2;
						y1 = KnightPos[1] + 1;
						x2 = KnightPos[0] - 1;
						y2 = KnightPos[1] + 2;
					} else {
						x1 = KnightPos[0] - 2;
						y1 = KnightPos[1] - 1;
						x2 = KnightPos[0] - 1;
						y2 = KnightPos[1] - 2;
					}
				}

				dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])] = Math.min(
								minStepsHelper(new int[]{x1, y1}, TargetPos, dp),
								minStepsHelper(new int[]{x2, y2}, TargetPos, dp)) + 1;

				/*
					Exchanging the coordinates x with y of both knight and target will result in
				 	same ans.
				*/
				dp[Math.abs(KnightPos[1] - TargetPos[1])][Math.abs(KnightPos[0]
						- TargetPos[0])] = dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
								.abs(KnightPos[1] - TargetPos[1])];
				return dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])];
			}
		}
	}

	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int size) {
		int dp[][] = new int[size + 2][size + 2];
		
		// There are 4 corner cases for which the minimum steps is 4.
		if ((KnightPos[0] == 1 && KnightPos[1] == 1 && TargetPos[0] == 2
				&& TargetPos[1] == 2)
				|| (KnightPos[0] == 2 && KnightPos[1] == 2 && TargetPos[0] == 1
						&& TargetPos[1] == 1)) {
			return 4;
		} else if ((KnightPos[0] == 1 && KnightPos[1] == size && TargetPos[0] == 2
				&& TargetPos[1] == size - 1)
				|| (KnightPos[0] == 2 && KnightPos[1] == size - 1 && TargetPos[0] == 1
						&& TargetPos[1] == size)) {
			return 4;
		} else if ((KnightPos[0] == size && KnightPos[1] == 1 && TargetPos[0] == size - 1
				&& TargetPos[1] == 2)
				|| (KnightPos[0] == size - 1 && KnightPos[1] == 2 && TargetPos[0] == size
						&& TargetPos[1] == 1)) {
			return 4;
		} else if ((KnightPos[0] == size &&KnightPos[1] == size && TargetPos[0] == size - 1
				&& TargetPos[1] == size - 1)
				|| (KnightPos[0] == size - 1 && KnightPos[1] == size - 1
						&& TargetPos[0] == size && TargetPos[1] == size)) {
			return 4;
		} else {
			dp[1][0] = 3;
			dp[0][1] = 3;
			dp[1][1] = 2;
			dp[2][0] = 2;
			dp[0][2] = 2;
			dp[2][1] = 1;
			dp[1][2] = 1;
			return minStepsHelper(KnightPos, TargetPos, dp);
		}
	}
	
	 public int minStepToReachTarget_Efficient(int KnightPos[], int TargetPos[], int N)
	    {
	        // Code here
	        int i=KnightPos[0];
	        int j=KnightPos[1];
	        int x=TargetPos[0];
	        int y=TargetPos[1];
	        
	        //Lets use BFS 
	        int ans=0;
	        boolean visited[][]=new boolean[N][N];
	        Queue<PairKmove> q=new ArrayDeque<>();
	        q.add(new PairKmove(i,j));int size=0;PairKmove curr=null;
	        while(!q.isEmpty()){
	            size=q.size();
	            for(int k=0;k<size;k++){
	                curr=q.poll();
	                i=curr.i;j=curr.j;
	                if(visited[i-1][j-1]==false){
	                visited[i-1][j-1]=true;
	                if(i==x && j==y){
	                    return ans;
	                }
	                
	                {// Put others in  8 possible combo ee
	               if(i-2>0 && j-1>0 && visited[i-2-1][j-1-1]==false){
	                   q.offer(new PairKmove(i-2,j-1));
	               }
	               if(i+2<=N && j-1>0 && visited[i+2-1][j-1-1]==false){
	                   q.offer(new PairKmove(i+2,j-1));
	               }
	               if(i-2>0 && j+1<=N && visited[i-2-1][j+1-1]==false){
	                   q.offer(new PairKmove(i-2,j+1));
	               }
	               if(i+2<=N && j+1<=N && visited[i+2-1][j+1-1]==false){
	                   q.offer(new PairKmove(i+2,j+1));
	               }
	               //next 4 
	               if(i-1>0 && j-2>0 && visited[i-1-1][j-2-1]==false){
	                   q.offer(new PairKmove(i-1,j-2));
	               }
	               if(i+1<=N && j-2>0 && visited[i+1-1][j-2-1]==false){
	                   q.offer(new PairKmove(i+1,j-2));
	               }
	               if(i-1>0 && j+2<=N && visited[i-1-1][j+2-1]==false){
	                   q.offer(new PairKmove(i-1,j+2));
	               }
	               if(i+1<=N && j+2<=N && visited[i+1-1][j+2-1]==false){
	                   q.offer(new PairKmove(i+1,j+2));
	               }
	                }//Adding in Queue ends 
	                
	            }
	         
	              
	        }ans=ans+1;//Counting steps  
	        }
	        return -1;
	    }
	

	
}


/**

Given a square chessboard, the initial position of the Knight and the position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.

Example:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:3

Expected Approach:
Intuition
This problem can be seen as the shortest path in an unweighted graph. Therefore we use BFS to solve this problem.

We try all 8 possible positions where a Knight can reach from its position. If the reachable position is not already visited and is inside the board, we push this state into the queue with a distance 1 more than its parent state. Finally, we return the distance of the target position, when it gets pop out from the queue

Implementation:
Steps:-

Create a queue for storing states of knight in board
push starting position of knight with 0 distance
Now run a loop till queue is not empty
Pop front element(position of night at that point) of the queue
Try all 8 possible positions where a Knight can reach from its position
If the reachable position is not already visited and is inside the board, we push this state into the queue with a distance 1 more than its parent state.
Finally, we return the distance of the target position, when it gets pop out from the queue.
1
2
3
4
5
Code:
// Back-end Complete function Template for JAVA

class Solution
{
    //Function to check if cell indexes are within bounds.
    boolean isValid(int x, int y, int N){
		return (x >=0 && x < N && y >=0 && y < N);
	}
	
	//Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        KnightPos[0]--;
		KnightPos[1]--;
		TargetPos[0]--;
		TargetPos[1]--;
		
        int dx[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int dy[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
        
        //using boolean list to mark visited cells and currently 
        //marking all the cells as false.
		boolean vis[][] = new boolean[N][N];
		
		//queue for storing visited cells by knight in board and steps taken.
		Queue<ArrayList<Integer>> q = new LinkedList<>(); 
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(KnightPos[0]);
		temp.add(KnightPos[1]);
		temp.add(0);
		
		//pushing starting position of knight with 0 distance.
		q.add(temp);
		//marking starting cell as visited.
		vis[KnightPos[0]][KnightPos[1]] = true;
		
		while(!q.isEmpty())
		{
		    //storing cell indexes and steps of front element and popping them.
		    ArrayList<Integer> temp2 = q.poll();
			int x = temp2.get(0);
			int y = temp2.get(1);
			int steps = temp2.get(2);
			
			//if we reach the required cell, we return true.
			if(x == TargetPos[0] && y == TargetPos[1])
				return steps;
			
			//using loop to reach all the cells that can be reached by knight.
			for(int i=0; i<8; i++)
			{
				int n_x = x + dx[i];
				int n_y = y + dy[i];
				
				//if cell indexes are valid and cell is not visited, we push  
				//the indexes in queue with steps and mark cell as visited.
				if(isValid(n_x, n_y, N) && !vis[n_x][n_y])
				{
				    ArrayList<Integer> temp1 = new ArrayList<>();
            		temp1.add(n_x);
            		temp1.add(n_y);
            		temp1.add(steps+1);
					q.add(temp1);
					vis[n_x][n_y] = true;
				}
			}
		}
		return -1;
    }
}
Complexity:
Time Complexity: O(N2), As in the worst case we have to check/Traverse all N2 positions/state of board.
Space Complexity: O(N2), Maintaining visited array takes O(N2) space.
Alternate Approach :
Intuition
We can use dynamic programming to solve this problem. Let us consider various cases:

2
3
4
Implementation
Initialize a 'dp' array to store the subpaths to -1.
We’ll have the following base cases:
    dp[a][b] where ‘a’ and ‘b’ is the difference between ‘KNIGHT_X’ and ‘TARGET_X’ and ‘KNIGHT_Y’ and ‘KNIGHT_Y’ respectively.
    dp[1][0] = 3, dp[0][1] = 3, dp[1][1] = 2, dp[2][0] = 2, dp[0][2] =2,  dp[2][1] =1, dp[1][2] =1.
Add all base cases which satisfies the case 3 given above.
If the target is reached by the knight, return 0.
If the cell is revisited, return the stored answer in the ‘DP’ array.
Else, select the coordinates which satisfy cases 1 and 2 given above.
Store 1 plus a minimum of the paths obtained by two coordinates in the ‘DP’ array and recur till the target is not reached.
Exchanging the coordinates x with y of both knight and target will result in the same answer. So, we’ll update the ‘DP’ array accordingly.
Return DP[ abs(KNIGHT_X - TARGET_X)] [ abs(KNIGNT_Y - TARGET_Y)] as the minimum steps a Knight will take to reach the target position.
Code
class Solution
{
    private static int minStepsHelper(int KnightPos[], int TargetPos[], int[][] dp) {
		// If knight is on the target position return 0.
		if (KnightPos[0] == TargetPos[0] && KnightPos[1] == TargetPos[1]) {
			return 0;
		} else {
			// If already calculated then return that value.
			if (dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
					.abs(KnightPos[1] - TargetPos[1])] != 0) {
				return dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])];
			} else {
				int x1, y1, x2, y2;
				// (x1, y1) and (x2, y2) are the two positions which will be considered.
				if (KnightPos[0] <= TargetPos[0]) {
					if (KnightPos[1] <= TargetPos[1]) {
						x1 = KnightPos[0] + 2;
						y1 = KnightPos[1] + 1;
						x2 = KnightPos[0] + 1;
						y2 = KnightPos[1] + 2;
					} else {
						x1 = KnightPos[0] + 2;
						y1 = KnightPos[1] - 1;
						x2 = KnightPos[0] + 1;
						y2 = KnightPos[1] - 2;
					}
				} else {
					if (KnightPos[1] <= TargetPos[1]) {
						x1 = KnightPos[0] - 2;
						y1 = KnightPos[1] + 1;
						x2 = KnightPos[0] - 1;
						y2 = KnightPos[1] + 2;
					} else {
						x1 = KnightPos[0] - 2;
						y1 = KnightPos[1] - 1;
						x2 = KnightPos[0] - 1;
						y2 = KnightPos[1] - 2;
					}
				}

				dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])] = Math.min(
								minStepsHelper(new int[]{x1, y1}, TargetPos, dp),
								minStepsHelper(new int[]{x2, y2}, TargetPos, dp)) + 1;

				//*
				//	Exchanging the coordinates x with y of both knight and target will result in
				 //	same ans.
				
				dp[Math.abs(KnightPos[1] - TargetPos[1])][Math.abs(KnightPos[0]
						- TargetPos[0])] = dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
								.abs(KnightPos[1] - TargetPos[1])];
				return dp[Math.abs(KnightPos[0] - TargetPos[0])][Math
						.abs(KnightPos[1] - TargetPos[1])];
			}
		}
	}

	public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int size) {
		int dp[][] = new int[size + 2][size + 2];
		
		// There are 4 corner cases for which the minimum steps is 4.
		if ((KnightPos[0] == 1 && KnightPos[1] == 1 && TargetPos[0] == 2
				&& TargetPos[1] == 2)
				|| (KnightPos[0] == 2 && KnightPos[1] == 2 && TargetPos[0] == 1
						&& TargetPos[1] == 1)) {
			return 4;
		} else if ((KnightPos[0] == 1 && KnightPos[1] == size && TargetPos[0] == 2
				&& TargetPos[1] == size - 1)
				|| (KnightPos[0] == 2 && KnightPos[1] == size - 1 && TargetPos[0] == 1
						&& TargetPos[1] == size)) {
			return 4;
		} else if ((KnightPos[0] == size && KnightPos[1] == 1 && TargetPos[0] == size - 1
				&& TargetPos[1] == 2)
				|| (KnightPos[0] == size - 1 && KnightPos[1] == 2 && TargetPos[0] == size
						&& TargetPos[1] == 1)) {
			return 4;
		} else if ((KnightPos[0] == size &&KnightPos[1] == size && TargetPos[0] == size - 1
				&& TargetPos[1] == size - 1)
				|| (KnightPos[0] == size - 1 && KnightPos[1] == size - 1
						&& TargetPos[0] == size && TargetPos[1] == size)) {
			return 4;
		} else {
			dp[1][0] = 3;
			dp[0][1] = 3;
			dp[1][1] = 2;
			dp[2][0] = 2;
			dp[0][2] = 2;
			dp[2][1] = 1;
			dp[1][2] = 1;
			return minStepsHelper(KnightPos, TargetPos, dp);
		}
	}
}
Complexity
Time Complexity: O(abs( KX - TX ) * ( KY - TY ) ), where ‘KX’ denotes x-coordinate of the knight, ‘TX’ denotes x-coordinate of the target, ‘KY’ denotes y-coordinate of the knight and ‘TY’ denotes y-coordinate of the target. We are dealing with the cells which come in the submatrix formed by the starting and destination cell.
Space Complexity : O(abs( KX - TX ) * ( KY - TY ) ), where ‘KX’ denotes x-coordinate of knight, ‘TX’ denotes x-coordinate of the target, ‘KY’ denotes y-coordinate of the knight and ‘TY’ denotes y-coordinate of the target. A ‘DP’ array is used to store the subpaths within the submatrix formed by the starting and destination cell.
 

Useful links to help you understand the concepts of this problem:

https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/

*/