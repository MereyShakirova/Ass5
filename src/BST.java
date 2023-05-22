import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
public class BST <K extends Comparable<K>, V> implements Iterable<BST.KeyValue<K,V>> {
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

}
