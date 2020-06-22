package string;
/*
Add Strings
 */
//더 효율적인 방법 생각해 볼 것. 
public class LC415 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String addStrings(String num1, String num2) {
        int ten = 0;
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(idx1 != -1 || idx2 != -1){
            int val1;
            int val2;
            if(idx1 == -1){
                val1 = 0;
            }else val1 = num1.charAt(idx1--) - '0';
            if(idx2 == -1){
                val2 = 0;
            }else val2 = num2.charAt(idx2--) - '0';
            
            if(val1 + val2 + ten >= 10) {
                sb.append(val1+val2+ten - 10);
                ten = 1;
            }else{
                sb.append(val1+val2+ten);
                ten = 0;
            }
            
        }
        if(ten == 1) sb.append(1);
        return sb.reverse().toString();
    }

}
