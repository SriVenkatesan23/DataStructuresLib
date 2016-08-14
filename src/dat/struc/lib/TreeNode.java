package dat.struc.lib;


public class TreeNode<T extends Comparable<T>> {

	T data;
	TreeNode<T> left;
	TreeNode<T> right;
	
	public TreeNode(T dat){
		this.data = dat;
		left=null;
		right=null;
	}
	/**
	 * converts node to the following format
	 * ([left subtree] node.data [right subtree]
	 */
	public String nodeString(TreeNode<T> node){

		if(node==null){
			return "null";
		}
		return "[" +nodeString(node.left) +" "+ node.data+" "+nodeString(node.right)+"]";

	}
	

	
}
