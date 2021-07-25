// https://leetcode.com/problems/guess-number-higher-or-lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i=1;
        int j=n;
        int number=0;
        while(i<j){
            int mid=i+(j-i)/2;
            if(guess(mid)==-1){
                j=mid-1;
            }else if(guess(mid)==1){
                i=mid+1;
            }else{
                number=mid;break;
            }
        }
        
        return number;
        
    }
}