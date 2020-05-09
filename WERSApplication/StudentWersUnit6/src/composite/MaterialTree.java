package composite;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

// CHANGED for ITERATOR AND COMPOSITE IMPLEMENTATION
// Entire class added

/**
 *  The MaterialTree class provides the location for the tree data structure.  
 *  Objects of MaterialTree represent points in the tree, all of which have  
 *  parents except the root object. 
 * 
 *  Portions of the code below were modeled after a tutorial by javagists.com
 *  which can be found at the following website address.
 * 
 *  https://www.javagists.com/java-tree-data-structure
 * 
 * @author Martin Dwyer
 * @date 2019.10.4
 * 
 */
public class MaterialTree<T> {

    /**
     * Determines data type and data to be stored
     */
    public T data = null;
    
    /**
     * List of children for each tree node
     */
    public List<MaterialTree<T>> children = new ArrayList<>();
    
    /**
     * Specifying the parent node, default to none (root)
     */
    public MaterialTree<T> parent = null;
    
    /**
     * Specifies the identity of the tree root
     */
    public MaterialTree<String> root = null;
    
    /**
     * Identifies whether or not the node is terminal (leaf)
     */
    public boolean isLeaf = false;
    
    /**
     * A static class component to track materials in the database
     */
    public static TreeSet<String> materials = new TreeSet<>();

    /**
     * Default constructor to create null object
     */
    public MaterialTree() {
        
    }
    
    /**
     * Constructor to add data node
     * @param data to be stored
     */
    public MaterialTree(T data) {
        this.data = data;
    }
    
    /**
     * For adding children to a data point
     * @param child node to be added
     * @return the updated node with child added
     */
    public MaterialTree<T> addChild(MaterialTree<T> child) {
        child.setParent(this);
        this.children.add(child);
        return child;
    }

    /**
     * Method provides for adding more than one child at a time
     * @param children a list of children to be added
     */
    public void addChildren(List<MaterialTree<T>> children) {
        children.forEach(each -> each.setParent(this));
        this.children.addAll(children);
    }

    /**
     * Method returns list of children for data point
     * @return list of child data points
     */
    public List<MaterialTree<T>> getChildren() {
        return children;
    }

    /**
     * Method to object child data 
     * @return child data 
     */
    public TreeSet getChildData() {
        TreeSet childData = new TreeSet<>();
        List<MaterialTree<T>> children = this.getChildren();
        for (MaterialTree<T> child : children) {
            childData.add(child.getData());
        }
        return childData;
    }

    /**
     * Method returns node specified by the user
     * @param t the data stored in the data point
     * @return a MaterialTree object
     */
    public MaterialTree<T> getChild(T t) {
        MaterialTree<T> itemFound = new MaterialTree<>(t);
        for (MaterialTree<T> kid : this.getChildren()) {
            if (kid.getData().equals(t)) {
                itemFound = kid;
            }
        }
        return itemFound;
    }

    /**
     * Method to obtain node data stored
     * @return data stored in node
     */
    public T getData() {
        return data;
    }

    /**
     * Method to set data stored in a data point
     * @param data the data to be stored
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * Method sets parent for the data point
     * @param parent the MaterialTree object 
     */
    private void setParent(MaterialTree<T> parent) {
        this.parent = parent;
    }

    /**
     * Method to retrieve information about parent data point
     * @return a MaterialTree object for the parent data point
     */
    public MaterialTree<T> getParent() {
        return parent;
    }

    /**
     * Method allows terminal data points to be identified
     * @param y either true or false
     */
    public void setIsLeaf(boolean y) {
        this.isLeaf = y;
    }

    /**
     * Method to convert data points to String for display
     * @return 
     */
    public String toString() {
        String s = (String) this.getData();
        return s;
    } 
}