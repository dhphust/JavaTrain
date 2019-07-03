import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()){
            String ip1 = input.nextLine();
            String ip2 = input.nextLine();
            String mask = input.nextLine();
            if(ip1 == null || ip1.length() == 0 || ip2 == null || ip2.length() == 0 || mask == null || mask.length() == 0){
                System.out.println(1);
                break;
            }
            boolean flag = false;
            //取数字
            String sip1[] = ip1.split("\\.");
            String sip2[] = ip2.split("\\.");
            String smask[] = mask.split("\\.");
            StringBuilder result = new StringBuilder();
            //判断越界
            for (int i = 0; i < sip1.length; i++) {
                if(Integer.valueOf(sip1[i]) < 0 || Integer.valueOf(sip1[i]) > 255 || Integer.valueOf(sip2[i]) < 0 || Integer.valueOf(sip2[i]) > 255
                        || Integer.valueOf(smask[i]) < 0 || Integer.valueOf(smask[i]) > 255){
                    System.out.println(1);
                    break;
                }
            }

            //按位与运算
            for (int i = 0; i < sip1.length; i++) {
                Integer result1 = Integer.valueOf(sip1[i]) & Integer.valueOf(smask[i]);
                Integer result2 = Integer.valueOf(sip2[i]) & Integer.valueOf(smask[i]);
                if(result1 == result2){
                    flag = true;
                }
                else {

                    flag = false;
                    break;
                }
            }
            for (int i = 0; i < sip1.length; i++) {
                Integer result1 = Integer.valueOf(sip1[i]) & Integer.valueOf(smask[i]);
                result.append(result1).append(".");
            }

            if(flag){
                System.out.println(0 + " " + result.substring(0,result.length()-1));
                break;
            }else {
                System.out.println(1 + " " + result.substring(0,result.length()-1));
                break;
            }
        }

    }
}
