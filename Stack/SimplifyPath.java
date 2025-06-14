package Stack;

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String s = "/.../a/../b/c/../d/./";
        String result = func(s);

        System.out.println(result);
    }

    public static String func(String path) {
        String[] splitPath = path.split("/");
        Stack<String> simplePath = new Stack<>();
        
        for(String p : splitPath){
            if("".equals(p) || ".".equals(p)){

            }else if("..".equals(p)){
                if(!simplePath.isEmpty()){
                    simplePath.pop();
                    if(!simplePath.isEmpty()){
                        simplePath.pop();
                    }
                }
            }else {
                simplePath.push("/");
                simplePath.push(p);
            }
        }
        if(simplePath.isEmpty()){
            simplePath.push("/");
        }

        path = "";
        while (!simplePath.isEmpty()) {
            path += simplePath.remove(0);
        }
        return path;
    }
}
