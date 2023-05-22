public class Main {
public static void main(String[] args){
 BST<Integer, String> bst = new BST<>();
 bst.put(0, "P");
 bst.put(3, "R");
 bst.put(4, "O");
 bst.put(1, "M");
 bst.put(7, "I");
 bst.put(2, "S");
 bst.put(5, "E");
 System.out.println("Elements in the BST class:");
 for (BST.KeyValue<Integer, String> entry: bst){
  System.out.println("Keys: " + entry.getKey() + "; " + "Values: " + entry.getValue() + ";");
 }

 bst.delete(0);
 bst.delete(6);
 System.out.println("After the deletion method:");
 for (BST.KeyValue<Integer, String> entry: bst){
  System.out.println("Keys: " + entry.getKey() + "; " + "Values: " + entry.getValue() + ";");
 }

 int key = 2;
 String value = bst.get(key);
 System.out.println("Value for key " + key + ": " + value);


 System.out.println("Size of tree is "+ bst.size() + ".");
}
}