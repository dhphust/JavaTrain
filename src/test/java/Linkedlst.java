import javax.print.attribute.standard.Sides;
import java.util.ArrayList;
import java.util.List;

//循环链表的使用
public class Linkedlst {
    private Node head; //头节点
    private Node tail; //尾节点
    int size;
    //构造器
    public Linkedlst(){
        tail = head = null;
        size = 0;
    }

    //链表头部添加元素
    public void addHead(Node node){
        if(size == 0){
            node.next = node;
            head = tail = node;
            size++;
        }else {
            tail.next = node;
            node.next = head;
            head = node;
            size++;
        }

    }

    //链表尾部添加元素
    public void addTail(Node node){
        if(size == 0){
            node.next = node;
            head = tail = node;
            size++;
        }else {
            tail.next = node;
            node.next = head;
            tail = node;
            size++;
        }
    }

    //删除链表头部元素
    public void delHead(){
        if(size > 1){
            tail.next = head.next;
            head = head.next;
            size--;
        }else if(size == 1){
            head = tail = null;
            size--;
        }else
            return;
    }

    //删除链表尾部元素
    public void delTail(){
        if(size > 1){
            Node cur = head;
            while (cur.next != tail)//head移动到tail前一个位置
                cur = cur.next;
            cur.next = tail.next;
            tail = cur;
            size--;
        }else if(size == 1){
            head = tail = null;
            size--;
        }else
            return;
    }
    //打印链表
    public void print(){
        System.out.println("遍历链表");
        Node cur = head;
        while (cur != null && cur != tail){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println(tail.val);
        System.out.println("head:" + head.val);
        System.out.println("tail" + tail.val);

    }
    public static void main(String[] args) {
        Linkedlst lis = new Linkedlst();
        lis.addHead(new Node(10));
        lis.addHead(new Node(20)); //头部插入
        lis.addTail(new Node(30));
        lis.print();
        //删除头节点
        System.out.println("删除头部：");
        lis.delHead();
        lis.print();
        System.out.println("删除尾部：");
        //删除尾节点
        lis.delTail();
        lis.print();

    }
}

class Node{
    Node next;
    int val;

    public Node(int val) {
        this.val = val;
    }
}
