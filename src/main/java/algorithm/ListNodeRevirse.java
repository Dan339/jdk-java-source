package algorithm;


/**
 * 链表反转
 * @author Dan.L
 * @date 2022年06月19日22:17
 */
public class ListNodeRevirse {
    public static void main(String[] args) {
        ListNode header = new ListNode();
        ListNode tmp = header;
        for (int i = 0; i < 5; i++) {
            ListNode next = new ListNode();
            tmp.next = next;
            tmp = next;
        }


        printmd(header);

        System.out.println("===========");
        header = rev(header);
        printmd(header);
    }

    private static void printmd(ListNode header) {
        System.out.println(header);
        while (header.next != null) {
            header = header.next;
            System.out.println(header);
        }
    }

    private static ListNode rev(ListNode header) {
        if (header == null) {
            return null;
        }

        ListNode pre = null;
        ListNode next = null;
        while (header != null) {
            next = header.next;
            header.next = pre;

            pre = header; 
            if (next != null) {
                header = next;
            } else {
                break;
            }
        }

        return next;
    }
}
