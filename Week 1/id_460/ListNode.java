package Question21MergeTwoLists;

public class ListNode {
    ListNode next;
    Integer val;
   ListNode(Integer x){
       val = x;
       next = null;
   }
   ListNode(){}

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return val;
    }

    public void setValue(Integer value) {
        this.val = value;
    }
}
