package offer66;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 打印栈的所有排列
 * 针对每种作为栈顶的情况，进行展开考虑
 */
public class A211 {

    static Stack<Integer> stack = new Stack<>();
    static List<List<Integer>> lists = new ArrayList<>();
    private static int number = 0;
    static int[] array=new int[10];//保存输出的元素

    //入栈顺序1到n，输出所有的出栈序列
    public static void popOrder(int i,int n){
        List<Integer> list = new ArrayList<>();
        int top;//获取栈顶值
        if(i == n+1)//递归结束条件，输出序列
        {
            ++number;
            //输出数组中的元素
            for(int j = 0;j < n-stack.size();++j)
                list.add(array[j]);
            //输出栈中剩下的元素
            for(int k=stack.size()-1;k>=0;k--)
            {
                list.add(stack.get(k));
            }
            lists.add(list);
        }
        else
        {
            stack.push(i);//入栈
            popOrder(i+1,n);
            stack.pop();//为保持stack不变，出栈

            if(!stack.empty())//将栈顶元素输出
            {
                top=stack.peek();
                array[i-stack.size()-1] = top;//将输出的元素放入array中
                stack.pop();
                popOrder(i,n);//i不变
                stack.push(top);
            }
        }
    }

    public static void main(String[] args) {
        popOrder(1,4);
        System.out.println("一共情况：" + number);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
