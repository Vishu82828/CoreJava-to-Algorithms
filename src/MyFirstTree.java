class TreeNode {
    protected int data;
    TreeNode right;
    TreeNode left;
    public TreeNode(int data){
        this.data = data;
        this.right = null;
        this.left = null;
    }
}

class BinarSearchTree {
    TreeNode root;
//    ok i write comments from this recursion start
    public void insert(int data){
        root = insertRecursive(root, data);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        //Recursive Steps, go far left as possible
        inOrder(root.left);
        System.out.print(root.data + " ");
        //Recursive Steps, go far Right as possible
        inOrder(root.right);
    }

    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

//    the login to find the right side branch to store data
    private TreeNode insertRecursive(TreeNode root, int data){
        if(root == null){
//            if find it empty spot, plant the node
            return new TreeNode(data);
        }
//        otherwise, decide: left or right : ok
        if(data<root.data){
            root.left = insertRecursive(root.left, data);
        }else if(data > root.data){
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    public boolean search(TreeNode root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){return true;}
        if(root.data > key){return search(root.left, key);}
        else {return search(root.right, key);}
    }
}

public class MyFirstTree {
    public static void main(String[] args) {
        BinarSearchTree tree = new BinarSearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(10);
        System.out.print("Shorted Tree(In Order) : ");
        tree.inOrder(tree.root);
        System.out.println(" ");
        System.out.print("Shorted Tree(Pre Order) : ");
        tree.preOrder(tree.root);
        System.out.println(" ");
        System.out.print("Shorted Tree(Post Order) : ");
        tree.postOrder(tree.root);
        System.out.println(" ");

        int key = 20;
        if(tree.search(tree.root, key)){
            System.out.println(" Key found in Tree ");
        }
        else {System.out.println(key + " is not there. ❌");}
    }
}