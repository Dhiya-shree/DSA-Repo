package greedy_Algo;

/**
 * 
 *  *  Thief with 1 knapsack + unbreakable things 
 *  
 *  A thief successfully broke vault 
 *  But has only 1 knapsack where he can hide totally an weight of capacity c
 *  Fill up the knapsack with most value 
 *  
 *  
 *  Given a set of items with weight and values 
 *  And a knapsack with capacity c 
 *  Collect maximum value in knapsack 
 * 
 *  Set = w1,v1 ; w2,v2 ; w3,v3 .....
 *  Capcity c 
 *  
 *  Example :
 *  Set   50,600 20,500 30,400
 *  Capcity = 70 
 *  
 *  Maximum : 1500 ( 20 + 20+ 20)  bu wastage 10 
 *  
 *  Solution 1: 
 *  Convert set to ratio array 
 *  Double ratio = Value/Weight 
 *  
 *  Step 1:
 *  Sort the set by ratio found 
 *     20,500   30,400  50,600
 *  
 *  Step 2:
 *  initialize 
 *  res = capacity 70
 *   ans=0
 *  curr=0;
 *  
 *  Step 3:
 *  For all set  :
 *      curr= res/weight    70/20 - 3 
 *      ans = ans+ curr * value  0 +n500*3  - 1500 
 *      res= res- curr*weight     70-60 = 10
 * 
 * @author shree
 *
 */
public class Greedy02_Activity_Seclection2 {

}
