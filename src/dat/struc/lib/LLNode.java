package dat.struc.lib;

public class LLNode<T>{

	
	T data;
	LLNode<T> next;
	
	public LLNode(T dat, LLNode<T> n){
		this.data=dat;
		this.next=n;
	}
	
}
