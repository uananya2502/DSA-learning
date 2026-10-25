
public class LinkedList {

    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    // Add at beginning
    public void addFirst(int data) {
        Node n1 = new Node(data);
        size++;

        if (head == null) {
            head = tail = n1;
            return;
        }

        n1.next = head;
        head = n1;
    }

    // Add at end
    public void addLast(int data) {
        Node n1 = new Node(data);
        size++;

        if (head == null) {
            head = tail = n1;
            return;
        }

        tail.next = n1;
        tail = n1;
    }

    // Add at a given index (0-based)
    public void addMid(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node n1 = new Node(data);
        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        n1.next = temp.next;
        temp.next = n1;
        size++;
    }

    // Print the linked list
    public void print() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Remove from beginning
    public int removeFirst() {
        if (head == null) {
            System.out.println("List is Empty");
            return -1;
        }

        int data = head.data;
        size--;

        if (head == tail) {
            head = tail = null;
            return data;
        }

        head = head.next;
        return data;
    }

    // Remove from end
    public int removeLast() {
        if (head == null) {
            System.out.println("List is Empty");
            return -1;
        }

        int data = tail.data;
        size--;

        if (head == tail) {
            head = tail = null;
            return data;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;

        return data;
    }

    // Iterative search
    public boolean searchI(int key) {
        Node temp = head;

        while (temp != null) {
            if (temp.data == key) {
                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    // Recursive search
    public boolean searchRec(int key) {
        return rec(key, head) == 1;
    }

    public int rec(int key, Node temp) {
        if (temp == null) {
            return -1;
        }

        if (temp.data == key) {
            return 1;
        }

        return rec(key, temp.next);
    }

    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        tail = head;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addLast(2);
        ll.addLast(4);
        ll.addLast(5);
        ll.addFirst(1);
        ll.addMid(2, 3);

        ll.print();
        System.out.println("Size: " + ll.size);

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();

        System.out.println("Size: " + ll.size);

        ll.addLast(5);
        ll.addFirst(1);

        System.out.println(ll.searchRec(5));
        System.out.println(ll.searchRec(9));
        System.out.println(ll.searchI(3));
        System.out.println(ll.searchI(11));

        ll.reverse();
        ll.print();

        ll.reverse();
        ll.print();
    }
}
