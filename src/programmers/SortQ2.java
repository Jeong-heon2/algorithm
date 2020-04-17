package programmers;

public class SortQ2 {

	public static void main(String[] args) {
		int[] numbers = {141,151,101,102,101};
		int size = numbers.length;
        String[] strArr = new String[size];
        for(int i = 0 ; i< size; i++){
            strArr[i] = Integer.toString(numbers[i]);
        }
        quick_Sort(strArr, 0, size-1);
        StringBuilder sb = new StringBuilder("");
        for(int i = size-1 ; i >=0 ; i-- ){
            sb.append(strArr[i]);
        }
		System.out.println(sb.toString());

	}
	
    public static void quick_Sort(String[] arr, int start, int end) {
        
        int left = start;
        int right = end;
        
        String pivot = arr[(left + right) / 2];
 
        do {
            
            while (compare(arr[left], pivot).equals(pivot)) {
                left++;
            }
            while (compare(arr[right], pivot).equals(arr[right])) {
                right--;
            }
 
            if (left <= right) {
                String temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
 
        } while (left <= right);
 
        if (start < right) {
            quick_Sort(arr, start, right);
 
        }
        if (end > left) {
            quick_Sort(arr, left, end);
        }
    }
    public static String compare(String a, String b){
        int i = 0;
        int j = 0;
        int aSize = a.length();
        int bSize = b.length();
        do{
            if(a.charAt(i) > b.charAt(j)){
                return a;
            }else if(a.charAt(i) < b.charAt(j)){
                return b;
            }else{
            	if((i == aSize-1) && (j == bSize-1)) break;
                if(aSize-1 != i){
                    i++;
                }
                if(bSize-1 != j){
                    j++;
                }
            }
        }while(true);
        return "";
    }

}
