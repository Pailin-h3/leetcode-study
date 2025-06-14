package Stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        // String s = "1-(2+3-(4+(5-(1-(2+4-(5+6))))))";

        basicCal("4--1");

        // func(s);
    }

    public static int func(String s) {
        Stack<Integer> nextCal = new Stack<>();
        // if(s.charAt(0) != '(') 
        nextCal.push(0);

        int j = 0;
        while(!nextCal.isEmpty()){
            if(j < s.length() && s.charAt(j) == '('){
                nextCal.push(j+1);
            }else if(j == s.length() || s.charAt(j) == ')'){
                int begin = nextCal.pop();
                
                System.out.println(s.substring(begin, j));

                int result = basicCal(s.substring(begin, j).trim());
                if(j == s.length()) return result;

                s = s.substring(0, begin-1) + result + s.substring(j+1);
                System.out.println(s);
                j = begin-1;
            }
            j++;
        }

        return 0;
    }

    private static int basicCal(String s){
        int i = 0;
        int result = 0;

        s = s.replaceAll("\\s", "");
        System.out.println(s);

        for(int j = 1 ; j<=s.length() ; j++){
            if(j == s.length()){
                try{
                    System.out.println(s.substring(i));
                    result += Integer.parseInt(s.substring(i));
                }catch(Exception e){

                }
                break;
            }

            if(s.charAt(j) == '+'){
                try{
                    System.out.println(s.substring(i, j));
                    result += Integer.parseInt(s.substring(i, j));
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }

                i = j;
            }
            
            if(s.charAt(j) == '-'){
                try{
                    System.out.println(s.substring(i, j));
                    result += Integer.parseInt(s.substring(i, j));
                    i = j;
                }catch(Exception e){
                    System.out.println("ERROR parse int: " + s.substring(i, j));
                    if(s.substring(i, j).equals("-")){
                        s = s.substring(0, i) + "+" + s.substring(j+1);
                        i = j;
                    }else if(s.substring(i, j).equals("+")){
                        s = s.substring(0, i) + "-" + s.substring(j+1);
                        i = j-1;
                        j--;
                    }
                    System.out.println(s);
                }
                
            }
        }

        System.out.println();
        System.out.println(result);

        return result;
    }
    
}
