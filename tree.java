import java.util.*;

class Node {
    public Integer data;
    public Node up;
    public Node left;
    public Node right;
    
    public Node(Integer data) {
        this.data = data;
    }
    
    public String toString(){
        return String.valueOf(data);
    }
}

class BinaryTree {
    public Node root;
    public int size = 0;
    public Node[] repArr;
    
    public BinaryTree(int rootData) {
        root = new Node(rootData);
        this.printTree(root);
        System.out.println("==========================================================================================");
        size++;
    }
    
    public void insert(int data) {
        Node current = root;
        while (true) {
            if (data > current.data) {
                if (current.right == null) {
                    //System.out.println("Inserted as the right child of " + current);
                    current.right = new Node(data);
                    size++;
                    this.printTree(root);
                    System.out.println("==========================================================================================");
                    return;
                }
                current = current.right;
            } else {
                if (current.left == null) {
                    //System.out.println("Inserted as the left child of " + current);
                    current.left = new Node(data);
                    size++;
                    this.printTree(root);
                    System.out.println("==========================================================================================");
                    return;
                }
                current = current.left;
            }
        }
    }
    
    public Node search(int data) {
        Node current = root;
        while (true) {
            if (data == current.data) {
                return current;
            }
            else if (data > current.data) {
                if (current.right == null) {
                    return null;
                }
                current = current.right;
            } else {
                if (current.left == null) {
                    return null;
                }
                current = current.left;
            }
        }
    }
    
    public void makeArrSize() {
        int arrSize = (int) Math.pow(2, size);
        repArr = new Node[arrSize];
    }
    
    public void makeArr() {
        makeArrSize();
        
        repArr[0] = root;
        
        for (int i = 0; i < repArr.length; i++) {
            if (repArr[i] != null) {
                if (2 * i + 1 < repArr.length) { repArr[2 * i + 1] = repArr[i].left;}
                if (2 * i + 2 < repArr.length) { repArr[2 * i + 2] = repArr[i].right;}
                //repArr[2 * i + 2] = repArr[i].right;
            }
        }
    }
    
    // taken from www.geeksforgeeks.org/print-binary-tree-2-dimensions/ 
    static void printTreeHelper(Node root, int space) {
        if (root == null)
            return;
     
        space += 10;
     
        printTreeHelper(root.right, space);
     
        System.out.print("\n");
        for (int i = 10; i < space; i++)
            System.out.print(" ");
            System.out.print(root.data + "\n");
     
            printTreeHelper(root.left, space);
    }
    
    static void printTree(Node root) {
        printTreeHelper(root, 0);
    }
    
    public String toString() {
        makeArr();
        String[] out = new String[repArr.length];
        int outind = 0;
        
        for (int i = 0; i < repArr.length; i++) {
            if (repArr[i] != null) {
                out[outind] = String.valueOf(repArr[i].data);
                outind++;
            }
        }
        
        //return Arrays.toString(out);
        return Arrays.toString(repArr);
    }
}

public class tree {
    public static void main(String[] args) {
        BinaryTree oak = new BinaryTree(5);
        oak.insert(3);
        oak.insert(7);
        oak.insert(2);
        oak.insert(4);
        oak.insert(6);
        oak.insert(8);
        oak.insert(11);
        oak.insert(14);
        oak.insert(16);
        oak.insert(1);
        oak.insert(19);
        //System.out.println(oak.size);
        //System.out.println(oak);
        //oak.printTree(oak.root);
    }
}
