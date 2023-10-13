public class DoublyLinkedList {

    public class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    public void swapWithSuccessor(int x) {
        Node current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }
        if (current == null || current.next == null) {
            return;
        }

        Node A = current.prev;
        Node B = current;
        Node C = current.next;
        Node D = (current.next != null) ? current.next.next : null;

        if (A != null) {
            A.next = C;
        } else {
            head = C;
        }
        C.prev = A;
        C.next = B;
        B.prev = C;
        B.next = D;
        if (D != null) {
            D.prev = B;
        }
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        Node current = head;
        while (current != null) {
            output.append(current.data + " <-> ");
            current = current.next;
        }
        return output + "null";
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        System.out.println(list);

        list.swapWithSuccessor(3);
        System.out.println(list);
    }
}

/*
2. Major Concept of the Algorithm:

The algorithm first searches for node X in the doubly linked list. Once it finds X, it checks whether X has a
successor. If X doesn't have a successor, we return without making any changes.

If X has a successor, we identify four nodes around X:

A is the predecessor of X.
B is X itself.
C is the successor of X.
D is the node after the successor of X.
We then adjust the pointers of A, B, C, and D to swap B and C.

3. Example of Running the Algorithm:

In the provided main function, we first create a doubly linked list with the nodes 1 <-> 2 <-> 3 <-> 4.
Then, we swap the node 3 with its successor 4.
After the swap, the list is printed as 1 <-> 2 <-> 4 <-> 3 <-> null.

4. Justification of Runtime:

The algorithm runs in O(n) time, where n is the number of nodes in the doubly linked list. This is because in
the worst case, we traverse the entire list to find node X. The actual swapping operation takes constant
time O(1). Thus, the overall complexity is dominated by the search operation, which is O(n).
 */