package offer66;

/**
 * 矩阵覆盖
 */
public class A10 {

    public static int RectCover(int target) {
        int one = 1;
        int two = 2;
        int result = 0;
        if(target == 1){
            return one;
        }
        if(target ==2){
            return two;
        }
        for(int i =3;i<=target;i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(RectCover(5));
    }
}
