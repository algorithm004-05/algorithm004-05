package Question641CircluarDeque;

public class TestMyCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(3);
        boolean param_1 = obj.insertFront(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.deleteFront();
        boolean param_4 = obj.deleteLast();
        int param_5 = obj.getFront();
        int param_6 = obj.getRear();
        boolean param_7 = obj.isEmpty();
        boolean param_8 = obj.isFull();


        System.out.println("param_1 " + param_1);
        System.out.println("param_2 " + param_2);
        System.out.println("param_3 " + param_3);
        System.out.println("param_4 " + param_4);
        System.out.println("param_5 " + param_5);
        System.out.println("param_6 " + param_6);
        System.out.println("param_7 " + param_7);
        System.out.println("param_8 " + param_8);
    }

}
