# **Assignment 5 for  laboratory work for the Algorithm Data Structure**
![](https://avatars.mds.yandex.net/i?id=40ca56b5c7ffd82a8eb38eece9902350d20bf59c-7757111-images-thumbs&n=13)
### Description:
!(*All students must comply with these criteria. If the student does not comply with these criteria, the score will be lowered.*)!
### In this work, these following criteria had to be done:
* Add size (10%)
* Implement in-order traversal for iterator() (20%)
* Make it possible for both key and value to be accessible during the iteration (10%)
* Github repository (10%)
### BST:
![](https://avatars.mds.yandex.net/i?id=9031d8c7d532e00630f84cc9f86f312ef0808b1d-9203641-images-thumbs&n=13)
#### *Explanation:*

#### *Here is the solution code*:
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)
    
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

### Main:
#### *Explanation:*
In Main class I tested the code with different way, like putting, entering the letters, numbers so on to prove the code. Also we can see the size of tree, values, keys.  
#### *Here is the solution code*:
![](https://cbgd.ask.fm/fd3/71a30/7839/4756/8b72/0d5fc8e2f2c4/original/421914.jpg)
    
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
# Thank you for your attention
![](https://avatars.mds.yandex.net/i?id=105671dd507f4ea050cf9b71a6c1a7e4-5312571-images-thumbs&n=13)

