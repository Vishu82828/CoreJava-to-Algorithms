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
    }
}

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
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
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
}