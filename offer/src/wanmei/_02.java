package wanmei;

import java.util.Arrays;
import java.util.Scanner;

public class _02 {

    public static int find(int n,int m,int[][] a){
        int[][] d = new int[n][m];
        for (int i = 0;i < n;i ++){
            for (int j = 0;j < m;j ++){
                if (i == 0 && j == 0){
                    d[i][j] = a[i][j];
                    continue;
                }
                if (j == 0){
                    d[i][j] = d[i - 1][j] + a[i][j];
                    continue;
                }
                if (i == 0){
                    d[i][j] = d[i][j - 1] + a[i][j];
                    continue;
                }
                d[i][j] = min(d[i][j - 1] + a[i][j],d[i - 1][j] + a[i][j]);
            }
        }
        return d[n - 1][m - 1];
    }

    public static int max(int a,int b){
        if (a >= b){
            return a;
        }
        return b;
    }

    public static int min(int a,int b){
        if (a <= b){
            return a;
        }
        return b;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] a = new int[n][m];

        for(int i = 0;i < n;i ++){
            for(int j = 0;j < m;j ++){
                a[i][j] = sc.nextInt();
            }
        }
        System.out.println(find(n,m,a));
    }
}