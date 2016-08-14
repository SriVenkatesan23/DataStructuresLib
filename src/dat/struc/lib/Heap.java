package dat.struc.lib;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Heap <T extends Comparable<T>>{

	private ArrayList<T> arr;

	public Heap(){
		this.arr = new ArrayList<T>();
	}

	public Heap(int size){
		this.arr = new ArrayList<T>(size);
	}

	public void insert(T ins){

		this.arr.add(ins);
		siftUp();

	}

	public T delete(){

		if(arr.size()==0){
			throw new NoSuchElementException();
		}
		if(arr.size()==1){
			return arr.remove(0);
		}

		T hold = arr.get(0);
		arr.set(0, arr.remove(arr.size()-1));
		siftDown();
		return hold;
	}

	public void siftUp(){
		int k = arr.size()-1;

		while(k>0){
			int p = (k-1)/2;
			T curr = arr.get(k);
			T parent = arr.get(p);

			int comp = curr.compareTo(parent);

			if(comp>0){ //curr is greater than parent
				T hold = parent;
				arr.set(p, curr); //swap parent and curr
				arr.set(k, hold);
			}
			else{
				return;
			}
			k=p;
		}	
	}

	public void siftDown(){

		int k=0;
		int left = 2*k+1;
		
		while(left<arr.size()){
			int max = 2*k+1;
			int right = max+1;
			if(right<arr.size()){
				if(arr.get(max).compareTo(arr.get(right))<0){ //if right child is greater than left child
					max=right;
				}
			}
			if(arr.get(max).compareTo(arr.get(k)) > 0   ){ //if this is smaller than max child

				T hold = arr.get(k);
				arr.set(k, arr.get(max));
				arr.set(max, hold);
				k=max;
				left=2*k+1;
			}
			else{
				return;
			}
		}
	}

	public void print(){
		System.out.println(this.arr.toString());
	}
	public int size() {
		return arr.size();
	}
	
	public boolean isEmpty() {
		return arr.isEmpty();
		
	}
	
	

}
