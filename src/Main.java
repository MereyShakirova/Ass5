public class Main {
public static void main(String[] args){
 BST<String, Integer>tree = new BST<>();
 tree.put("P", 0);
 tree.put("R", 3);
 tree.put("O", 4);
 tree.put("M", 1);
 tree.put("I", 8);
 tree.put("S", 2);
 tree.put("E", 5);
 for (BST.KeyValue<String, Integer> entry: tree){
  System.out.println("key iss " + entry.getKey() + ", " + "value is " + entry.getValue() + ".");
 }
 System.out.println("Size of tree is "+ tree.size() + ".");
}
}