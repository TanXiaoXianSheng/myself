package yifang;

import java.util.Scanner;

public class _03 {

    private static boolean func(String str){
        String[] arr = str.split(",");
        String a = arr[0];
        String b = arr[1];
        if(a.length() != b.length())
            return false;
        for(int i = 0;i < a.length();i ++){
            if(b.charAt(i) == a.charAt(0)){
                for(int j = 0;j <= b.length();j ++){
                    if(j == b.length())
                        return true;
                    if(j >= b.length() - i){
                        if(b.charAt(i + j -a.length()) == a.charAt(0 + j)){
                            continue;
                        }
                    }else if(b.charAt(i + j) == a.charAt(0 + j)){
                        continue;
                    }else{
                        break;
                    }
                }
                continue;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(func(str));
    }
}