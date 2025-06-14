package BitManipulation;

public class AddBinary {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";  // 110

        System.out.println(func(a,b));
    }

    public static String func(String a, String b) {
        int ia = a.length()-1;
        int ib = b.length()-1;

        int tod = 0;

        String sb = "";
        while (ia >= 0 || ib >= 0) {
            System.out.println("[ia: " + ia + "]  [ib: " + ib + "]");
            if(ia >= 0 && ib >= 0){
                if(a.charAt(ia) == '1' && b.charAt(ib) == '1'){
                    if(tod == 1){
                        sb = "1" + sb;
                    }else{
                        sb = "0" + sb;
                    }
                    tod = 1;
                }else if(a.charAt(ia) == '1' || b.charAt(ib) == '1'){
                    if(tod == 1){
                        sb = "0" + sb;
                    }else{
                        sb = "1" + sb;
                    }
                }else {
                    if(tod == 1){
                        sb = "1" + sb;
                    }else{
                        sb = "0" + sb;
                    }
                    tod = 0;
                }

                ia--;
                ib--;
            }else if(ia >= 0){
                if(a.charAt(ia) == '1'){
                    if(tod == 1){
                        sb = "0" + sb;
                        tod = 1;
                    }else{
                        sb = "1" + sb;
                        tod = 0;
                    }
                }else {
                    if(tod == 1){
                        sb = "1" + sb;
                    }else{
                        sb = "0" + sb;
                    }
                    tod = 0;
                }
                ia--;
            }else if(ib >= 0){
                if(b.charAt(ib) == '1'){
                    if(tod == 1){
                        sb = "0" + sb;
                        tod = 1;
                    }else{
                        sb = "1" + sb;
                        tod = 0;
                    }
                }else {
                    if(tod == 1){
                        sb = "1" + sb;
                    }else{
                        sb = "0" + sb;
                    }
                    tod = 0;
                }
                ib--;
            }
            System.out.println(tod);
        }

        if(tod == 1) sb = "1" + sb;

        return sb;
    }
}
