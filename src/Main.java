public class Main {
public static void main(String[] args){
 BST<Integer, String>tree = new BST<>();
 tree.put(0, "P");
 tree.put(3, "R");
 tree.put(4, "O");
 tree.put(1, "M");
 tree.put(7, "I");
 tree.put(2, "S");
 tree.put(5, "E");
 tree.delete(0);
 for (BST.KeyValue<Integer, String> entry: tree){
  System.out.println("key iss " + entry.getKey() + ", " + "value is " + entry.getValue() + ".");
 }
 System.out.println("after the deletion:");

 for (BST.KeyValue<Integer, String> entry: tree){
  System.out.println("key iss " + entry.getKey() + ", " + "value is " + entry.getValue() + ".");
 }
 System.out.println("Size of tree is "+ tree.size() + ".");
}
}