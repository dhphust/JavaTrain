package offer66;

public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        char[] list = str.toCharArray();
        int index = 0;
        for(int i=0;i<list.length;i++){
            boolean rag = false;
            for(int j=0; j < list.length; j++){
                if(list[j] == list[i] && j != i){
                    rag = true;
                    break;
                }
            }
            if(!rag){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int result = firstNotRepeatingChar("goolgleda");
        System.out.println(result);
    }
}
