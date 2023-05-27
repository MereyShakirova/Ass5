//put: This method inserts a key-value pair into the binary search tree. It uses recursion to traverse the tree and find the appropriate position for the new node.
//get: This method retrieves the value associated with a given key from the binary search tree.
//delete: This method removes a key-value pair from the binary search tree.
//findMin: This method finds the node with the minimum key in a subtree. It is used to find the replacement node during deletion.
//size: This method returns the number of elements in the binary search tree.
//iterator: This method returns an iterator over the elements of the binary search tree in ascending order of keys.
//hasNext: This method checks if there are more elements to iterate.
//next: This method returns the next key-value pair in the iteration.

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
public class BST<K extends Comparable<K>, V> implements Iterable<BST.KeyValue<K,V>>{//represents a binary search tree where each node contains a key-value pair
private Node root;
private int size;
private class Node{//represents a node in the binary search tree, holding a key-value pair along with references to its left and right child nodes.
    private K key;
    private V val;
    private Node left, right;
    public Node(K key, V val){
        this.key = key;
        this.val = val;
    }
}
public void put(K key, V val){//inserts a key-value pair into the binary search tree
    root = put(root, key, val);
}
private Node put(Node node, K key, V val){
    if(node==null){
        size++;
        return new Node(key, val);
    }
    int cmp = key.compareTo(node.key);
    if(cmp < 0){
        node.left = put(node.left, key, val);
    }
    else if(cmp > 0){
        node.right = put(node.right, key, val);
    }
    else{
        node.val = val;
    }
    return node;
}
public V get(K key){//retrieves the value associated with a given key from the binary search tree
    Node node = get(root,key);
    return node != null?node.val:null;
}
private Node get(Node node, K key){
    if(node == null){
        return null;
    }
    int cmp = key.compareTo(node.key);
    if(cmp < 0){
        return get(node.left, key);
    }
    else if(cmp > 0){
        return get(node.right, key);
    }
    else{
        return node;
    }
}


private Node<K, V> consist(K key, Node current) {
    if(current == null)&&(key.compareTo((K)current.key)==0{
        return current;}
        if(key.compareTo(K)current.key) < 0){
        return getNode(current.left, key);}
        else
            return getNode(current.right, key);
    }
    public boolean consist(K key){
    Node node = consist(key, root);
    if(node == null){
        return false;
                }
    else{
        return true;
    }

    public void delete(K key){//removes a key-value pair from the binary search tree
    root = delete(root,key);
}
private Node delete(Node node, K key){
    if(node == null){
        return null;
    }
    int cmp =key.compareTo(node.key);
    if(cmp < 0){
        node.left = delete(node.left,key);
    }
    else if(cmp > 0){
        node.right = delete(node.right,key);
    }
    else{
        if(node.left ==  null){
            return node.right;
        }
        else if(node.right == null){
            return node.left;
        }
        else{
       Node replacement = findMin(node.right);
       node.key = replacement.key;
       node.val = replacement.val;
       node.right = delete(node.right, replacement.key);
        }
    }
    return node;
}


    private Node findMin(Node node){//finds the node with the minimum key in a subtree
    if(node.left == null){
        return node;
    }
    return findMin(node.left);
}
public int size() {//returns the number of elements in the binary search tree
    return size;
}

public Iterator<KeyValue<K, V>> iterator(){//returns an iterator over the elements of the binary search tree in ascending order of keys
    return new BSTIterator();//implements the Iterator interface and provides the logic for iterating over the elements of the binary search tree
}
public static class KeyValue<K,V>{//represents a key-value pair in the binary search tree
    private K key;
    private V value;
    public KeyValue(K key, V value){
        this.key = key;
        this.value = value;
    }
    public K getKey(){
        return key;
    }
    public V getValue(){
        return value;
    }
}
private class BSTIterator implements Iterator<KeyValue<K,V>>{//implements the Iterator interface and provides the logic for iterating over the elements of the binary search tree
private Node current;
private Stack<Node> stack;
public BSTIterator(){
    stack = new Stack<>();
    current = root;
}
public boolean hasNext(){//checks if there are more elements to iterate
    return !stack.isEmpty() || current!= null;
}
public KeyValue<K,V> next(){//returns the next key-value pair in the iteration
    while(current!=null){
        stack.push(current);
        current = current.left;
    }
    if(stack.isEmpty()){
        throw new NoSuchElementException("not possible to iterate<<<");
    }
    Node node = stack.pop();
    current =node.right;
    return new KeyValue<>(node.key,node.val);
}
}
}
//implement method public consist and private consist one of them recursively

