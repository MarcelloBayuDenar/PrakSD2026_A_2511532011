package pekan4_2511532011;

public class QueueArrayDriver_2511532011 {
	public static void main ( String [] args) {
		QueueArray_2511532011 queue_2011 = new QueueArray_2511532011(1000);
		
		queue_2011.enqueue_2011(10);
		queue_2011.enqueue_2011(20);
		queue_2011.enqueue_2011(30);
		queue_2011.enqueue_2011(40);
		
		System.out.println("item di depan " + queue_2011.front_2011());
		System.out.println("item di paling belakang " + queue_2011.rear_2011());
		System.out.println("tampilkan queue");
		
		queue_2011.display_2011();
		
		System.out.println();
		System.out.println(queue_2011.dequeue_2011() + " dihapus dari queue");
		System.out.println("item di depan :" + queue_2011.front_2011());
		System.out.println("item di  belakang :" + queue_2011.rear_2011());
		
		System.out.println("tampilkan queue setelah dihapus");
		queue_2011.display_2011();
	}
}
