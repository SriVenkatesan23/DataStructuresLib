package dat.struc.lib;

public class LinkedList<T> {

	LLNode<T> head;
	public LinkedList(){
		this.head=null;
	}
	public LinkedList(T hd){
		this.head = new LLNode<T>(hd,null);
	}
	public void insertAtHead(T ins){
		this.head = new LLNode<T>(ins, this.head);
	}
	public void insertAtTail(T ins){
		LLNode<T> ptr=this.head;
		if(ptr==null){
			this.head = new LLNode<T>(ins,null);
		}
		while(ptr.next!=null){
			ptr=ptr.next;
		}
		ptr.next = new LLNode<T>(ins,null);
	}
	public void print(){

		LLNode<T> ptr=this.head;
		while(ptr!=null){
			System.out.print(ptr.data + " ");
			ptr=ptr.next;
		}
		System.out.println("");

	}
	public void insertAfter(T ins, T here){

		LLNode<T> ptr=this.head;
		while(ptr!=null && !ptr.data.equals(here)){
			ptr=ptr.next;
		}
		if(ptr==null) //not found
			return;
		else{ //found
			ptr.next = new LLNode<T>(ins,ptr.next);
		}
	}
	public boolean search(T targ){
		LLNode<T> ptr=this.head;
		while(ptr!=null){
			if(ptr.data.equals(targ))
				return true;
			else{
				ptr=ptr.next;
			}
		}
		return false;
	}
	public void removeFirstOcc(T targ){
		LLNode<T> ptr=this.head;
		if(ptr==null){
			return;
		}
		if(ptr.data.equals(targ)){
			this.head=this.head.next;
		}
		while(ptr.next!=null){
			if(ptr.next.data.equals(targ)){
				ptr.next=ptr.next.next;
				return;
			}
			ptr=ptr.next;
		}
	}
	public void removeAllOcc(T targ){
		LLNode<T> ptr=this.head;
		if(ptr==null){
			return;
		}
		if(ptr.data.equals(targ)){
			this.head=this.head.next;
		}
		while(ptr.next!=null){
			if(ptr.next.data.equals(targ)){
				ptr.next=ptr.next.next;
			}
			else{
				ptr=ptr.next;
			}
		}
	}
	public void replaceFirstOcc(T targ, T val){
		LLNode<T> ptr=this.head;
		while(ptr!=null){
			if(ptr.data.equals(targ)){
				ptr.data=val;
				return;
			}
			else{
				ptr=ptr.next;
			}
		}
	}
	public void replaceAllOcc(T targ, T val){
		LLNode<T> ptr=this.head;
		while(ptr!=null){
			if(ptr.data.equals(targ)){
				ptr.data=val;
			}
			ptr=ptr.next;

		}
	}

}
