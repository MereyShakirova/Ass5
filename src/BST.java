import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
public class BST<K extends Comparable<K>, V> implements Iterable<BST.KeyValue<K,V>>{
private Node root;
private int size;
private class Node{
    private K key;
    private V val;
    private Node left, right;
    public Node(K key, V val){
        this.key = key;
        this.val = val;
    }
}
public void put(K key, V val){
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
public V get(K key){
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
public void delete(K key){
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
private Node findMin(Node node){
    if(node.left == null){
        return node;
    }
    return findMin(node.left);
}
public int size() {
    return size;
}

public Iterator<KeyValue<K, V>> iterator(){
    return new BSTIterator();
}
public static class KeyValue<K,V>{
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
private class BSTIterator implements Iterator<KeyValue<K,V>>{
private Node current;
private Stack<Node> stack;
public BSTIterator(){
    stack = new Stack<>();
    current = root;
}
public boolean hasNext(){
    return !stack.isEmpty() || current!= null;
}
public KeyValue<K,V> next(){
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
