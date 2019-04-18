package offer66;
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class Second {
    public static String replaceSpace(StringBuffer str) {
        String Ostr = str.toString();
        if(Ostr != null && Ostr.length()>=0){
            char[] Ochar = Ostr.toCharArray();  //将字符串转换为字符数组
            int count = getSpaceNum(Ostr);
            char[] Nchar = new char[Ochar.length+count*2];  //新建字符数组
            int Oindex = Ostr.length()-1;
            int Nindex = Nchar.length -1;
            //将Ochar数组里从索引为0的元素开始, 复制到数组Nchar里的索引为0的位置, 复制的元素个数为Ochar.length
            System.arraycopy(Ochar, 0, Nchar, 0, Ochar.length);
            while(Oindex >= 0 && Oindex != Nindex){
                if(Nchar[Oindex] == ' '){
                    Nchar[Nindex--] = '0';
                    Nchar[Nindex--] = '2';
                    Nchar[Nindex--] = '%';
                }else{
                    Nchar[Nindex--] = Ochar[Oindex];
                }
                Oindex--;
            }

            return String.valueOf(Nchar);
        }
        return null;

    }
    public static int getSpaceNum(String testString){
        int count = 0;
        for(int i=0 ; i<testString.length() ; i++){
            if(testString.charAt(i) == ' '){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        String str = "We Are Happy";
        String result = replaceSpace(new StringBuffer(str));
        System.out.println(result);


    }
}
