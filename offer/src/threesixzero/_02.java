package threesixzero;

import java.util.Scanner;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/16 19:54
 **/
public class _02 {

    public static String forward(String str){
        String result = null;
        String[] arr = null;
        arr = forwardJinzhi(str,arr);
        int a = yanma(str.split("/")[1]);
        if (arr != null){
            if (!check(arr)){
                return "error";
            }
        }else {
            for (int i = 0;i < arr.length;i ++){
                if (i != arr.length - 1){
                    result = result + arr[i] + ".";
                }else
                    result = result + arr[i];
            }
        }
        result = result + "/" +  a;
        return result;
    }

    public static String[] forwardJinzhi(String str,String[] arrIp){
        String[] arr = str.split("/");
        String ip = arr[0];
        String add = arr[1];
        arrIp = parseIp(ip);
        int number = yanma(add);
        return arrIp;
    }

    public static String[] parseIp(String ip){
        String[] arr = ip.split("\\.");
        for (int i = 0;i < arr.length;i ++){
            if (arr[i].charAt(0) == '0'){
                if (arr[i].charAt(1) == 'x'){
                    //十六进制
                    arr[i] = String.valueOf(Integer.parseInt(arr[i].substring(2,arr[i].length()),16));
                }else {
                    //八进制
                    arr[i] = String.valueOf(Integer.parseInt(arr[i].substring(1,arr[i].length()),8));
                }
            }else {
                //十进制

            }
        }
        return arr;
    }

    public static int yanma(String yanma){
        int total = 0;
        String[] arr = yanma.split("\\.");
        for (int i = 0;i < arr.length;i ++){
            if (Integer.parseInt(arr[i]) == 255){
                total = total + 8;
            }else if (Integer.parseInt(arr[i]) == 0){
                break;
            }else {
                total = total + Integer.bitCount(Integer.parseInt(arr[i]));
                break;
            }
        }
        return total;
    }

    public static boolean check(String[] arr){
        if (arr[0].equalsIgnoreCase("0"))
            return false;
        else if(arr[3].equalsIgnoreCase("255"))
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(forward(str));
    }
}
