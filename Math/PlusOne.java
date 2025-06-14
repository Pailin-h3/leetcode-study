package Math;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        plusOne(new int[]{9});
    }

    public static int[] plusOne(int[] digits) {

        for(int i = digits.length -1 ; i>=0 ; i--){
            if(digits[i] < 9){
                digits[i] = digits[i]+1;
                break;
            }else if(digits[i] == 9 && i == 0){
                digits[i] = 0;
                digits =  plusFront(digits);
            }else{
                digits[i] = 0;
            }
        }

        System.out.println(Arrays.toString(digits));

        return digits;
    }

    public static int[] plusFront(int[] digits) {
        int[] pls = new int[digits.length+1];
        pls[0] = 1;

        for (int i = 0; i < digits.length; i++) {
            pls[i+1] = digits[i];
        }

        return pls;
    }
}
