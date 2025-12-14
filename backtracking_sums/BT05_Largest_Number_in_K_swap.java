package backtracking_sums;

import java.util.Arrays;
import java.util.HashSet;

public class BT05_Largest_Number_in_K_swap {

	public static void main(String[] args) {
		
		String num="59484321567989";
		int K=6;
		String ans=findMaximumNum(num, K);
		System.out.println(" Ans is "+ans);
		System.out.println("Correct: 99988765523441");
	}
	
	 //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
        {
    	    StringBuilder sb=new StringBuilder();
    	    int n=str.length();
    	    if(k==0) {
    	    	return str;
    	    }
    	    
    	  //static   int 
    	    digit=new int[10];
    	    greatest=new int[n];
    	    int numArr[]=new int[n];
    	    int val=0;
    	    int permute[]=new int[k];
    	    int count=0;
    	    int count2=0;
    	    ans=new int[n];
    	    ansSet=false;
    	    int digit2[]=new int[n];
    	   //int permute2[]=new int count
    	    
    	    ////////////////////////////////////////////////////////////////////////////////////// O 3 N get the greatest 
    	    for(int i=0;i<n;i++) {
    	    	val=Character.getNumericValue(str.charAt(i));
    	    	digit[val]++;
    	    	digit2[val]++;
    	    	numArr[i]=val;
    	    	ans[i]=val;
    	    	
    	    }
    	    
    	    greatest=GetTheGreatest(n);                             
    	    
    	    if(IsGreatest(n,numArr)) {
    	    	ansSet=true;
    	    }
    	    
    	    //Special case 
    	    if(k>=n || ansSet) {
    	    	for(int i=0;i<n;i++){
    	    		sb.append(greatest[i]);
    	    		return sb.toString();
    	    	}
    	    }
    	    
    	    
    	    //////////////////////////////////////////////////////////////////////////////////////////////////  O N+10
    	    // get what to permute 
    	    
    	   
    	    count=0;count2=0;
    	    for(int i=0;i<n;i++) {
    	    	
    	    	if(greatest[i]!=numArr[i] && count<k) {
    	    		permute[count]=greatest[i];
    	    		count++;
    	    	}
    	    	
    	    }
    	   
    	    Arrays.sort(permute);
    	    for(int i=0;i<count/2;i++) {
    	    	int swap=permute[i];
    	    	permute[i]=permute[count-1-i];
    	    	permute[count-1-i]=swap;
    	    }
    	    System.out.println(" Permutation digits are "+Arrays.toString(permute));
    	    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    	    
    	    System.out.println("dIGIt "+Arrays.toString(digit));
    	    PermutationToGetAns(numArr,greatest,k,n,permute,0,k-1,numArr);
    	    
    	    System.out.println(" answer is ");
    	    for(int i=0;i<n;i++) {
    	    	sb.append(ans[i]);
    	    }
    	    
    	   return sb.toString();
        }

   

	static int digit[];static int ans[];static boolean ansSet; static int greatest[];
	private static void PermutationToGetAns(int[] numArr, int[] greatest, int k, int n, int[] permute, int left,int right,int ansArr[]) {
		// Normal Permutation 
		
		if(left>=right) {
			System.out.println(" Current permute for "+Arrays.toString(permute));
			
			int oriArr[]=new int[n];
			for(int i=0;i<n;i++) {
				oriArr[i]=numArr[i];
			}
		//	System.out.println(" Array original ----------------"+Arrays.toString(oriArr));
			int ansArrNew[]=new int[n];
			ansArrNew=SwapAndRearrange(k,oriArr,permute,0,0,n,0,ansArr);
			System.out.println(" Ans Arr Old "+Arrays.toString(ansArr));
			System.out.println(" Ans Arr New "+Arrays.toString(ansArrNew));
			
			
			

			
		}
		else {
			
			if(true) {//IsSafeToContinue(numArr,left,n)) {// IS SAFE 
				
				for(int i=left;i<=right;i++) {
					
					permute=swap(permute,i,left);
					
					 PermutationToGetAns(numArr,greatest,k,n,permute,left+1,right,ansArr);
					
				   permute=swap(permute,left,i);
				}
			}
		}
		
	}

	private static boolean IsSafeToContinue(int[] numArr, int left, int n) {
		// safe to continue 
		
		for(int i=0;i<left;i++) {
			if(numArr[i]<ans[i]) {
				return false;
			}
		}
		return true;
	}

	private static int[] SwapAndRearrange(int k, int[] numArr, int[] permute, int permuteCount, int swapCount,int n,int setTill,int[] ansArr) {
		// Swap by permute
		System.out.println(" Ans:-------"+Arrays.toString(numArr));
		if(swapCount>k || permuteCount>=permute.length) {
	//		System.out.println(" Final ===================================================================");
			System.out.println(" Ans 1"+Arrays.toString(numArr));
			
//			System.out.println(" Ans 2"+Arrays.toString(ans));
	//		System.out.println(" NEXT -----------------------------------------------------------------");
			for(int i=0;i<n;i++) {
				if(ansArr[i]<numArr[i]) {
					for(int j=0;j<n;j++) {
						ansArr[j]=numArr[j];
						System.out.print(numArr[i]);
					}
				}
				else if(ansArr[i]>numArr[i]) {
					return ansArr;
				}
			}
			return numArr;
		}
		
		//////////////////////////////////////////////////////////////////////////////////////////////////////////
		for(int i=0;i<n;i++) {
			if(ansArr[i]<numArr[i]) {
				for(int j=0;j<n;j++) {
					ansArr[j]=numArr[j];
					System.out.print(numArr[i]);
				}
			}
			else if(ansArr[i]>numArr[i]) {
				return ansArr;
			}
		}
		System.out.println("  ANSWER..............................................................................");
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		int number=permute[permuteCount];
		int numberCount=digit[number];
		//if(number)
	
		
		int count=0;int count2=0;
		int position[]=new int[numberCount];
		// Able to swap the number n 
		for(int i=n-1;i>0 && count<numberCount;i--) {
			if(numArr[i]==number) {
				position[count]=i;
				count++;
			}
		}
		
		for(int i=setTill;i<n && count2<numberCount;i++) {
			
			if(numArr[i]<number) {
				while(i==position[count2] && count2<count) {
					count2++;
				}
				
				int swap=numArr[i];
				numArr[i]=number;
				numArr[position[count2]]=swap;
				break;
			}
		}
		
		
		return SwapAndRearrange(k,numArr,permute,permuteCount+1,swapCount+1,n,setTill+1,ansArr);
	}



	private static int[] swap(int[] permute, int i, int left) {
		// swap function 
		int sw=permute[i];
		permute[i]=permute[left];
		permute[left]=sw;
		return permute;
	}

	private static int[] GetTheGreatest(int n) {
		//find greatest 
		int digitc[]=new int[10];
		for(int i=0;i<10;i++) {
			digitc[i]=digit[i];
		}
		int num[]=new int[n];int p=0;
		for(int i=9;i>=0 && p<n;i--) {
			while(digitc[i]>0) {
				num[p]=i;
				p++;
				digitc[i]--;
			}
		}
		System.out.println(" Greatest ==>"+Arrays.toString(num));
		return num;
	}
    
	 private static boolean IsGreatest(int n, int[] numArr) {
			// Check if greatest 
		 for(int i=0;i<n;i++) {
			 if(numArr[i]!=greatest[i]) {
				 return false;
			 }
		 }
			return true;
		}
    
}