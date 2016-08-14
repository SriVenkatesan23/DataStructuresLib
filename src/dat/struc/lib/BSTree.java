package dat.struc.lib;



public class BSTree<T extends Comparable<T>> {

	TreeNode<T> root;
	
	
	public String toString(){
		if (root == null)
			return "(null)";
		else {
			return "("+ root.nodeString(root) + ")";
		}
	}
	public BSTree(){
		this.root=null;
	}

	public BSTree(T rt){
		this.root = new TreeNode<T>(rt);
	}
	public void insert (T data){
		if(!search(data, root)){ //no duplicates. Only insert if not already in tree
			root = insertRec(data, root);	
		}
	}
	private TreeNode<T> insertRec(T data, TreeNode<T> curr){
		if(curr==null){
			return new TreeNode<T>(data);
		}
		if(data.compareTo(curr.data)<0){ //target is less than current

			curr.left= insertRec(data, curr.left);
			return curr;
		}
		else{ //target is more than current
			curr.right = insertRec(data, curr.right);
			return curr;
		}
	}
	public boolean search(T target, TreeNode<T> curr) {

		if(curr==null) return false;
		if(curr.data==target)return true;

		else{
			if(target.compareTo(curr.data) < 0){ 
				return search(target,curr.left);
			}
			if(target.compareTo(curr.data) > 0){
				return search(target,curr.right);
			}
			return false;	
		}
	}

	public void remove(T target){
		TreeNode<T> curr = root;
		TreeNode<T> currParent = null;
		boolean parLeft=false;
		while(curr!=null){
			if(target.compareTo(curr.data)<0){
				currParent=curr;
				curr=curr.left;
				parLeft=true;
			}
			else if(target.compareTo(curr.data)>0){
				currParent=curr;
				curr=curr.right;
				parLeft=false;
			}
			else{ //curr.data == target
				break;
			}
		}

		if(curr==null){ //target not found
			throw new IllegalArgumentException();
		}
		System.out.println(curr.data);

		if(curr.left==null && curr.right==null){
			if(parLeft){
				currParent.left=null;
			}
			else{
				currParent.right=null;
			}
			return;
		}

		TreeNode<T> pred;
		TreeNode<T> prev=curr;
		if(curr.left!=null){ //in order predecessor exists
			prev=curr;
			pred = curr.left;
			while(pred.right!=null){
				prev=pred;
				pred=pred.right;
			}
			curr.data=pred.data;
			prev.left=null;
		}
		else{//find inorder successor
			if(curr.right!=null){
				prev=curr;
				pred=curr.right;
				while(pred.left!=null){
					prev=pred;
					pred=pred.left;
				}
				curr.data=pred.data;
				prev.right=null;	
			}	
		}	
	}

	
	/**
	 * remove all nodes from tree
	 */
	public void clearTree(){
		root=null;
	}
}


