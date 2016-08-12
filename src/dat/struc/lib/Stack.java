package dat.struc.lib;
import java.util.NoSuchElementException;

public class Stack<T>{

	LLNode<T> head;
	int size;

	public Stack(){
		head=null;
	}

	public Stack(T dat){
		head=new LLNode<T>(dat,null);
	}

	public void push(T ins){
		this.size++;
		if(head==null){ //empty stack
			head = new LLNode<T>(ins, null);
			return;
		}
		head = new LLNode<T>(ins, head);	
	}

	public T pop() throws NoSuchElementException{
		if(head==null){
			throw new NoSuchElementException();
		}
		T dat = head.data;
		head=head.next;
		this.size--;
		return dat;
	}
	public T peek(){
		T dat = this.head.data;
		return dat;
	}
	public void print(){
		LLNode<T> ptr=this.head;
		while(ptr!=null){
			System.out.print(ptr.data + " ");
			ptr=ptr.next;
		}
		System.out.println("");

	}
	public boolean empty(){
		return this.size==0;
	}
}
