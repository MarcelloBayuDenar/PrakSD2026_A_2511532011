package pekan4_2511532011;

import java.util.Queue;

public class QueueArray_2511532011 {
	int front_2011, rear_2011, size_2011;
	int capacity_2011;
	int array_2011[];
	
	public QueueArray_2511532011(int capacity) {
		this.capacity_2011 = capacity;
		front_2011 = this.size_2011 = 0;
		rear_2011 = capacity - 1;
		array_2011 = new int [this.capacity_2011];
	}
	
	boolean isFull_2011(QueueArray_2511532011 queue) {
		return (queue.size_2011 == queue.capacity_2011);
	}
	
	boolean isEmpty_2011 (QueueArray_2511532011 queue) {
		return (queue.size_2011 == 0);
	}
	
	void enqueue_2011(int item_2011) {
		if (isFull_2011(this))
			return;
		this.rear_2011 = (this.rear_2011 + 1) % this.capacity_2011;
		this.array_2011[this.rear_2011 ] = item_2011;
		this.size_2011 = this.size_2011 + 1;
		System.out.println(item_2011 + " enqueued to queue");
	}
	
	int dequeue_2011() {
		if(isEmpty_2011(this)) 
			return Integer.MIN_VALUE;
		int item_2011 = this.array_2011[this.front_2011];
		this.front_2011 = (this.front_2011 + 1) % this.capacity_2011;
		this.size_2011 = this.size_2011 - 1;
		return item_2011;
	}
	
	int front_2011() {
		if (isEmpty_2011(this))
			return Integer.MIN_VALUE;
		
		return this.array_2011[this.front_2011];
	}
	
	int rear_2011() {
		if (isEmpty_2011(this))
			return Integer.MIN_VALUE;
		return this.array_2011[this.rear_2011];
	}
	
	void display_2011() {
		int i;
		if (front_2011 == rear_2011) {
			System.out.printf("\nantrian kosong\n");
			return;
		}
		
		for ( i = front_2011; i < rear_2011; i++) {
			System.out.printf(" %d <--", array_2011[i]);
		}
		
		return;
	}
	
}
