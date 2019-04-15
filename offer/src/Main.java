import java.util.Scanner;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/15 11:54
 **/
/*public class Main {

    public static int total(int n,int[] a){
        int total = 0;
        total = total(n,a,0,n - 1,0);
        return total;
    }

    public static int total(int n,int[] a,int left,int right,int i){
        i ++;
        if (left == right){
            return a[left] * i;
        }
        int total = 0;
        int flag = compare(n,a,left,right);
        if (flag == 1){
            total = a[left] * i + total(n,a,left + 1,right,i);
        }
        if (flag == -1){
            total = a[right] * i + total(n,a,left,right - 1,i);
        }
        if (flag == 0){
            if (right - left == 2){
                total = a[right] * i + total(n,a,left,right - 1,i);
            }
            *//*int flag02 = compare(n,a,left - 1,right - 1);
            if (flag02 == 1){
                total = a[left] * i + total(n,a,left + 1,right,i);
            }
            if (flag02 == -1){
                total = a[right] * i + total(n,a,left,right - 1,i);
            }
            if (flag02 == 0){

            }*//*
        }
        return total;
    }

    //-1 左大，0 相等，1 右大
    public static int compare(int n,int [] a,int i,int j){
        if (a[i] == a[j])
            return 0;
        if (a[i] < a[j])
            return 1;
        if (a[i] > a[j])
            return -1;
        return 2;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0;i < n;i ++){
            a[i] = sc.nextInt();
        }
        System.out.println(total(n,a));
    }
}*/



