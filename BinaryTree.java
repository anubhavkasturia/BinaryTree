

public class BinaryTree{
   
    private class Node{
        int data;
        Node left;
        Node right;

     Node(int data,Node left,Node right){ 
        this.data=data;
        this.left=left;
        this.right=right;
    }
}
    private Node root;
    private int size;

   

    public BinaryTree(int[]arr){
        this.root=construct(arr);
        this.size=size1(this.root);
    }
    public int size(){ 
        return this.size;
    }
    
    static int i=0;
    
    private Node construct(int[] arr){
        if(arr[i]==-1||i>=arr.length ){
            i++;
            return null;
        }
        
        Node node=new Node(arr[i],null,null);
        i++;
        node.left=construct(arr);
        node.right=construct(arr);
        return node;
    }

public void display() {
    display(this.root);
}

private void display(Node node) {
   if (node == null) {
       return;
   }
   String str = " ";
   str += node.left != null ? node.left.data : ".";
   str += "->" + node.data + "<-";
   str += node.right != null ? node.right.data : ".";
   System.out.println(str);

   display(node.left);
   display(node.right);
}

  public int size1(Node node){
        if(node==null){
            return 0;
        }
        int lsize=size1(node.left);
        int rsize=size1(node.right);
        return lsize+rsize+1;


    }

public int max() {
    return this.max(this.root);
}

  public int max(Node node){
    if(node==null){
        return Integer.MIN_VALUE;

    }
  int lmax=max(node.left);
  int rmax=max(node.right);
  return Math.max(node.data, Math.max(lmax, rmax));
}


public int min() {
    return this.min(this.root);
}

  public int min(Node node){
    if(node==null){
        return Integer.MAX_VALUE;

    }
  int lmax=min(node.left);
  int rmax=min(node.right);
  return Math.min(node.data, Math.min(lmax, rmax));
  }
  public int height() {
    return this.height(this.root);
 }

  public int height(Node node){
    if(node==null){
        return 0;
    }
  int lheight=height(node.left);
  int rheight=height(node.right);
  return (Math.max(lheight, rheight)+1);
}

    
    public boolean find(int findelem){
        return find(this.root, findelem);
    }
    private static boolean find (Node node,int finde){
        if(node==null){
            return false;
        }
        if(node.data==finde){
            return true;
        }
        else {
            
            boolean findleft=find(node.left, finde);
            if(findleft==true){
                return true;
            }else{
            boolean findright=find(node.right, finde);
                return findright;
        }
    }
    }
    public void preOrder(){
        preOrder(this.root);
    }
    private static void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
        
    }
    public void inOrder(){
        inOrder(this.root);
    }
    private static void inOrder(Node node){
        if(node==null){
            return;
        }
        
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
        
    }
    public void postOrder(){
        postOrder(this.root);
    }
    private static void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);

    }
    public void printChildAloneSiblings(){
        printChildAloneSiblingsp(root,root.left);
        printChildAloneSiblingsp(root,root.right);

        
    }
    private static void printChildAloneSiblingsp(Node parent,Node child){
        if(child==null){
            return;
        }
        if(parent.left==null && parent.right==child || parent.left==child && parent.right==null ){
            System.out.println(child.data);
        }
    printChildAloneSiblingsp(child, child.left);
    printChildAloneSiblingsp(child, child.right);
}

public void removeLeaves(){
    removeLeaves(root,root.left);
    removeLeaves(root,root.right);

    
}
private static void removeLeaves(Node parent,Node child){
    if(child==null){
        return;
    }
    if(child.left==null && child.right==null){
        if(child==parent.left){
            parent.left=null;
        }else if(child==parent.right){
            parent.right=null;
        }
    }
    removeLeaves(child, child.left);
    removeLeaves(child, child.right);
}
}
