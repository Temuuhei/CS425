
public class Main {
    public static void main(String[] args) {
        LinkedList myLinkedList = new LinkedList();
        // LinkedList.Node head = myLinkedList.head();
        myLinkedList.add(new LinkedList.Node("1"));
        myLinkedList.add(new LinkedList.Node("2"));
        myLinkedList.add(new LinkedList.Node("3"));
        myLinkedList.add(new LinkedList.Node("4"));
        myLinkedList.add(new LinkedList.Node("5"));
        myLinkedList.add(new LinkedList.Node("6"));
        LinkedList.Node head = myLinkedList.head();

        LinkedList.Node current = head;
        LinkedList.Node middle = head;
        int length = 0;
        while (current != null) {
            if (length % 2 == 0 && length > 0) {
                middle = middle.next();
                System.out.println("sssss" + middle);
            }
            length++;
            current = current.next();
        }

        System.out.println(myLinkedList.toString());
        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Node head() {
        return head;
    }

    public void add(Node node) {
        if (head != null && tail != null) {
            tail.next = node;
            tail = node;
        } else {
            head = node;
            tail = node;
        }
    }

    public String toString() {
        String result = "";
        Node current = head;
        while(current != null) {
            result +=  current.getData()  + ", ";
            current = current.next();
        }
        return result;
    }

    static class Node {
        private Node next;
        private String data;

        public Node(String data) {
            this.data = data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getData() {
            return data;
        }

        public Node next() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public String toString() {
            return data;
        }
    }
}
