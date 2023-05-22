public class Main {
public static void main(String[] args){
  BST<Integer, String> bst = new BST<>();
 // Insert elements into the bst
  bst.put(0, "P");
  bst.put(3, "R");
  bst.put(4, "O");
  bst.put(1, "M");
  bst.put(7, "I");
  bst.put(2, "S");
  bst.put(5, "E");

  //print the all elements
  System.out.println("Elements in the BST class:");
  for (BST.KeyValue<Integer, String> entry: bst){
   System.out.println("Keys: " + entry.getKey() + "; " + "Values: " + entry.getValue() + ";");//print the element with deleting on keys and values
  }

  bst.delete(0);
  bst.delete(6);//delete a key from the BST
  System.out.println("After the deletion method:");
  for (BST.KeyValue<Integer, String> entry: bst){
   System.out.println("Keys: " + entry.getKey() + "; " + "Values: " + entry.getValue() + ";");//print the elements after the deleting
  }


  System.out.println("After the getting method:");
  int key = 2;
  String value = bst.get(key);//retrieve the value associated with a key
  System.out.println("Value for key " + key + ": " + value);//print the elements after the getting


  System.out.println("After the size method:");
  System.out.println("Size of tree is "+ bst.size() + ".");//print the size of the bst class
 }
}