package dynamic_programming;

/**
 * 
 * LCS Variation :
 * 
 * 1) Diff Utility 
 *       Difference between two files 
 *       Used in version control git 
 *       Given two files , find longest common subseqence 
 *       
 * 2) Minimum insertion and deletion to convert s1 to s2 
 *       Given s1=geek s2=efgk 
 *       LCS = gk/ek .
 *       To change geek to efgk with gk as LCS is 
 *       geek -> 2 deletion : gk 
 *       gk -> 2 insertion : efgk 
 *       No of deletion = additional char in s1 other than LCS 
 *       No of insertion = additional char in s2 other than LCS 
 *       
 *       Given s1=geek s2=gfek 
 *       LCS= gek  3 
 *       No of deletion = extra in s1 (e) delete 1 geek -> gek  (4-3=1)
 *       No of isertion = extra in s2 (f) add f gek+f -> gfek  (4-3=1)
 *       ans=1+1=2
 *       
 *       S1 len=m ; S2 len=n ; LCS len=l
 *       
 *       Ans = deletion : M-L + Insertion :N-L 
 *       
 * 3) Shortest common super-sequence 
 *       Given 2 string s1,s2 . Find the third string which has both s1 and s2 as subsequence
 *       
 *       S1=geek s2=gefk 
 *       Simple super sequence s3= s1+s2 = geekgefk 
 *       
 *       Find shortest common super sequence 
 *       
 *       1) Find LCS :  geek + gefk = gek 
 *               LCS = gek 
 *               
 *       2) With LCS traverse first string and insert additional characters 
 *          LCS = gek s1=geek 
 *          Traverse s1 and LCS and find s3 
 *          g=g s3=g  
 *          e=e s3=ge
 *          e!=k (add e in LCS) s3=gee
 *          k=k s3=geek
 *          LCS current : geek 
 *          
 *       3) With LCS traverse second string and insert additional characters 
 *          LCS = gek s2=gefk 
 *          Traverse s2 and LCS and find s3 
 *          g=g s3=geek  
 *          e=e s3=geek
 *          k!=f (add f in LCS) s3=geefk
 *          k=k s3=geefk
 *          
 *          super sequence s3= geefk 
 *          
 *          Length of super sequence = LCS.len +(s1.len - LCS) + (s2.len - LCS.len)
 *          
 *  4) Longest Palindromic SubSequence 
 *        Find the longest subsequence that is also palindrome 
 *        
 *        s=geeksForgeeks
 *        palindrome = ee , eeee , eeSee , eeFee , sFs , sees
 *        
 *        Here create s2 = reverse of s1 
 *        s1=geeksforgeeks
 *        s2=skeegrofskeeg 
 *        
 *        Find the LCS of string and reverse for longest palindrome 
 *        LCS= eefee 
 *        
 *        
 *  5) Longest Repeating Sub sequence 
 *       Given string s , find the longest repeating subsequence 
 *       Must not consider same char at same index in both subsequence 
 *       
 *       S1= AABB 
 *       subsequence : A,AA,AB,ABB,AB
 *       output :2
 *       
 *       S2= AAA
 *       subsequence : AAA,A,AA,AA
 *       output : 2 AA,AA
 *       A1,A2 A2,A3 
 *       
 *       Keep s1=s2 
 *       s1=AABB
 *       s2=AABB
 *       
 *       in LCS additional check along with char matching , the index must not be same 
 *       
 *       O M*N time O m*n space
 *       
 *  6) Space optimized DP solution 
 *      
 *       Value needed at any point is only previous array 
 *       
 *       Linear space instead of quadratic 
 *       Use memo / table of size 2*m or 2*n
 *       
 *       
 *       
 *  7) Printing LCS 
 *       Use start and end char and keep on update it 
 *  
 *      
 *        
 *       
 *       
 *       
 *       
 *   
 * 
 * 
 * 
 * 
 * 
 * @author shree
 *
 */
public class DP10_LCS_Variation {

}
