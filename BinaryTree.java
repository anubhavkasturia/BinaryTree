

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






}