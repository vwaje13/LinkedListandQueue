
public class VeerWajeQueue<E> {
	private VeerWajeLinkedList<E> list = new VeerWajeLinkedList<>();

	public void enqueue(E e) {
	  list.addLast(e);
	}

	public E dequeue() {
	  return list.removeFirst();
	}

	public int getSize() {
	  return list.size();
	}

	@Override
	public String toString() {
	  return "Queue: " + list.toString();
	}
	
	public void veerWajePrint() {
		System.out.print("QUEUE=[");
        while(getSize()>1) {
            System.out.print(dequeue() + ", ");
        }
        System.out.println(dequeue() + "]");
	}

}
