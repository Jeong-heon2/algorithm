package twopointer;
/*
Reverse String

 */
public class LC344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

}
