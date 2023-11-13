public class BinarySearchTree {

    public class Node {
        public int key;
        public Node left;
        public Node right;

        public Node(int item) {
            key = item;
            left = null;
            right = null;
        }
    }

    public Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(Node node, int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }

        Node currentNode = node;
        Node parentNode = null;
        while (currentNode != null) {
            parentNode = currentNode;
            if (key < currentNode.key) {
                currentNode = currentNode.left;
            } else if (key > currentNode.key) {
                currentNode = currentNode.right;
            } else {
                return;
            }
        }

        if (key < parentNode.key) {
            parentNode.left = new Node(key);
        } else {
            parentNode.right = new Node(key);
        }
    }

    public void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    public int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.key + sum(node.left) + sum(node.right);
    }

    int count = 0;

    public Node kthBiggest(Node root, int k) {
        if (root == null) {
            return null;
        }

        Node node = kthBiggest(root.right, k);

        if (node == null) {
            count++;
            if (count == k) {
                return root;
            }

            node = kthBiggest(root.left, k);
        }

        return node;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(bst.root, 50);
        bst.insert(bst.root, 30);
        bst.insert(bst.root, 20);
        bst.insert(bst.root, 40);
        bst.insert(bst.root, 70);
        bst.insert(bst.root, 60);
        bst.insert(bst.root, 80);

        System.out.print("Preorder Traversal: ");
        bst.preorderRec(bst.root);
        System.out.println();

        System.out.println("Sum of all keys: " + bst.sum(bst.root));

        Node kthBiggestNode = bst.kthBiggest(bst.root, 3);
        System.out.println("3rd biggest key: " + (kthBiggestNode != null ? kthBiggestNode.key : "Not found"));
    }
}

/*
Preorder Traversal: 50 30 20 40 70 60 80 
Sum of all keys: 350
3rd biggest key: 60
*/
