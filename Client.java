public class Client{
public static void main(String[] args) {
    
    int[] arr={10,20,40,45,-1,-1,-1,50,-1,-1,30,-1,80,-1,-1,-1};
    BinaryTree bt= new BinaryTree(arr);
    // bt.display();
    System.out.println(bt.size());
    System.out.println(bt.max());
    System.out.println(bt.min());
    System.out.println(bt.height());
}
}