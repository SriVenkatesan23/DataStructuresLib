package dat.struc.lib;

public class Queue<T>{

	LLNode<T> tail;
	private int size;

	public Queue(){
		size=0;
		tail=null;
	}
	public Queue(T hd){
		size=1;
		tail=new LLNode<T>(hd, null);
		tail.next=tail;
	}
	public void print(){

		if(this.tail==null){ //empty
			return;
		}
		if(this.tail.next==tail){ //one node
			System.out.println(tail.data);
			return;
		}
		else{
			LLNode<T> ptr = this.tail.next;
			do{
				System.out.print(ptr.data+" ");
				ptr=ptr.next;
			}while(ptr!=this.tail.next);
			System.out.println("");

		}

	}
	public void enqueue(T targ){

		if(this.tail==null){
			tail = new LLNode<T>(targ,null);
			tail.next=tail;
			this.size++;
			return;
		}
		this.size++;
		LLNode<T> ins = new LLNode<T>(targ,null);
		ins.next = tail.next;
		tail.next=ins;
		tail=ins;

	}
	public T dequeue(){

		if(tail==null){ //empty queue
			return null;
		}
		if(tail.next==tail){ //one node queue
			size--;
			LLNode<T> deq = tail;
			tail=null;
			return deq.data;
		}
		size--;
		LLNode<T> deq = tail.next; //front
		tail.next=tail.next.next;
		return deq.data;
	}
	public int size(){
		return this.size;
	}

	public boolean empty(){
		return this.size==0;
	}

}
