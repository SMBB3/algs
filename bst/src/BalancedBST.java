import java.lang.reflect.Array;
import java.util.concurrent.BlockingDeque;

public class BalancedBST {
    BST root;
    
    public void buildFromArray(int[] arr){
        Array.sort(arr);
        root = build(arr, 0, arr.length - 1);
    }
    
    private BST build(int[] arr, int left, int right){
        if (left > right) {
            return null;
        }
        
        int mid = (left + right) / 2;
        BST node = new BST(arr[mid]);
        
        node.left = build(arr, left, mid - 1);
        node.right = build(arr, mid + 1, right);
        
        return node;
    }
    
    public BST search(int val){
        return searchRec(root, val);
    }
    
    private BST searchRec(BST, int val){
        if (node == null || node.val == val){
            return node;
        }
        if (val < node.val){
            return searchRec(node.left, val);
        }
        return searchRec(node.right, val);
    }
    
    public void insert(int val){
        root = insertRec(root, val);
    }
    
    private BST insertRec(BST node, int val){
        if (node == null){
            return new BST(val);
        }
        if (val < node.val){
            node.left = insertRec(node.left, val);
        } else if (val > node.val) {
            node.right = insertRec(node.right, val);
        }
        return node;
    }

    public void remove(int val){
        root = removeRec(root, val);
    }

    private BST removeRec(BST node, int val){
        if (node == null){
            return null;
        }

        if (val < node.val){
            node.left = removeRec(node.left, val);
        } else if (val > node.val) {
            node.right = removeRec(node.right, val);
        } else {

        }
    }
}
