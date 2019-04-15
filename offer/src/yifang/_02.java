package yifang;

import java.util.Scanner;

public class _02 {

    private static int find(String str){
        int flag = 0;
        int k = 1;
        String[] arr = str.split(",");
        for(int i = 0;i < arr.length - 1;i ++){
            if(Integer.parseInt(arr[i]) < Integer.parseInt(arr[i + 1])){
                k ++;
            }else{
                flag = max(flag,k);
                k = 1;
            }
        }
        flag = max(flag,k);
        return flag;
    }

    public static int max(int a,int b){
        if(a >= b){
            return a;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int a = find(str);
        System.out.println(a);
    }
}




