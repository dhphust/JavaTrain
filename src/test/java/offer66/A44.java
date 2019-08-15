package offer66;

/**
 * 翻转单词序列
 */
public class A44 {
    public static String ReverseSentence(String str) {
        if(str.trim().equals(""))
            return str;
        String[] list = str.split(" ");
        //StringBuilder在原有对象的基础上追加，不会新new对象
        StringBuilder sb = new StringBuilder();
        for(int i =list.length-1; i>=0; i--){
            sb.append(list[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "happy very am I";
        System.out.println(ReverseSentence(str));
    }
}
