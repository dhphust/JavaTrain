package offer66;

/**
 * 字符串中第一个不重复的字符
 */
public class A54 {

    private static int count[]=new int[256];//辅助数组，标记字符出现的次数
    private static int index=1; //标记字符出现的顺序
    //插入一个字符，标记出现的顺序
    public static void Insert(char ch)
    {
        if(count[ch]==0){
            count[ch]=index++;
        }
        else{
            count[ch]=-1;
        }
    }

    //遍历数组，找出下标最小的index
    public static char FirstAppearingOnce()
    {
        int temp=Integer.MAX_VALUE;
        char ch='#';
        for(int i=0;i<256;i++){
            if(count[i]!=0&&count[i]!=-1&&count[i]<temp){
                temp=count[i];
                ch=(char)i;
            }
        }
        return ch;
    }

    public static void main(String[] args) {
        String str = "google";
        char[] chars = str.toCharArray();
        //插入元素
        for(int i = 0; i < chars.length; i++){
            Insert(chars[i]);
        }
        char result = FirstAppearingOnce();
        System.out.println(result);
    }
}
