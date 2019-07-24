package leetcode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode p3 = new ListNode(0);
        ListNode p = p3;

        int carry = 0;
        int sum = 0;
        while (p1 != null || p2 != null) {
            int x = (p1 != null)? p1.val:0;
            int y = (p2 != null)? p2.val:0;
            sum = x + y + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            if(p1 != null) p1 = p1.next;
            if(p2 != null) p2 = p2.next;
        }
        if (carry > 0) {
            p.next = new ListNode(carry);
        }

        return p3.next;

    }
    static ListNode head = null;
    static ListNode tem = null;

    public void addNode(int d) {
        ListNode N = new ListNode(d);
        if (head == null) {
            head = N;
            return;  /*由于每次是增加一个节点，所以对头结点进行初始化之后就要退出函数*/
        }
        tem = head;  /*一般一个链表的头结点是不能动的，因此需要把头结点赋值给一个临时变量
		这样在对链表进行访问的时候，就可以用这个临时变量进行逐个的访问，不对头结点产生影响*/
        while (tem.next != null) {
            tem = tem.next;
        }
        tem.next = N;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        int[] a = {2, 4, 9};
        for (int i = 0; i < 3; i++) {
            addTwoNumbers.addNode(a[i]);
        }
        ListNode l1 = head;
        head = null;
        int[] b = {5, 6, 4};
        for (int i = 0; i < 3; i++) {
            addTwoNumbers.addNode(b[i]);
        }
        ListNode l2 = head;
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
