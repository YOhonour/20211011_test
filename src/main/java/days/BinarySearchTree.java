package days;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

/**
 * 二叉搜索树
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    /**
     * 节点
     *
     * @param <AnyType>
     */
    private static class BinaryNode<AnyType> {
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> left, BinaryNode<AnyType> right) {
            element = theElement;
            left = left;
            right = right;
        }

        AnyType element; // the data in the node
        BinaryNode<AnyType> left; // Left child
        BinaryNode<AnyType> right; // Right child
    }
    public List<AnyType> nodeList = new ArrayList<>();
    public void midSearch(BinaryNode<AnyType> root){
        if (root == null ) return;
        if (root.left != null) midSearch(root.left);
        if (root.right != null) midSearch(root.right);
        nodeList.add(root.element);
    }
    @Override
    public String toString(){
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        midSearch(root);
        return nodeList.toString();
    }
    private BinaryNode<AnyType> root;
    private Comparator<? super AnyType> cmp;

    /**
     * 无参构造器
     */
    public BinarySearchTree() {
        this(null);
    }

    /**
     * 带参构造器，比较器
     *
     * @param c 比较器
     */
    public BinarySearchTree(Comparator<? super AnyType> c) {
        root = null;
        cmp = c;
    }

    /**
     * 清空树
     */
    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x){
        return contains(x,root);
    }

    public AnyType findMin(){
        if (isEmpty()) throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public AnyType findMax(){
        if (isEmpty()) throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(AnyType x){
        root = insert(x, root);
    }

    public void remove(AnyType x){
        root = remove(x,root);
    }




    private int myCompare(AnyType lhs, AnyType rhs) {
        if (cmp != null) {
            return cmp.compare(lhs, rhs);
        } else {
            return lhs.compareTo(rhs);
        }
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return false;
        }

        int compareResult = myCompare(x, t.element);
        if (compareResult < 0) {
            return contains(x, t.left);
        } else if (compareResult > 0) {
            return contains(x, t.right);
        } else {
            return true;
        }
    }

    /**
     * Internal method to find the smallest item in a subtree
     * @param t the node that roots the subtree
     * @return node containing the smallest item
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null) {
            return null;
        }
        if (t.left == null) {
            return t;
        }
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree
     * @param t the node that roots the subtree
     * @return the node containing the largest item
     */
    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if (t == null){
            return null;
        }
        if (t.right == null){
            return t;
        }
        return findMax(t.right);
    }

    /**
     * Internal method to remove from a subtree
     * @param x the item to remove
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if (t == null){
            return t; // Item not found ,do nothing
        }
        int compareResult = myCompare(x,t.element);

        if (compareResult < 0){
            t.left = remove(x,t.left);
        }
        else if (compareResult > 0){
            t.right = remove(x,t.right);
        }
        else if (t.left !=null && t.right!=null){
            //Two children
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }
        else
            t = (t.left !=null) ? t.left:t.right;
        return t;
    }

    /**
     * Internal method to insert into a subtree
     * @param x the item to insert
     * @param t the node that roots the subtree
     * @return the new root of the subtree
     */
    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t){
        if (t == null){
            return new BinaryNode<>(x,null,null);
        }
        int compareResult = myCompare(x,t.element);

        if (compareResult < 0){
            t.left = insert(x,t.left);
        }
        else if (compareResult > 0){
            t.right = insert(x,t.right);
        }
        else{
            //Duplicate; do nothing
        }

        return t;
    }

}
