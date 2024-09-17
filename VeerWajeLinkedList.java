
public class VeerWajeLinkedList<E> implements VeerWajeList<E> {
	private Node<E> head, tail;
	private int size = 0; // Number of elements in the list

	/** Create an empty list */
	public VeerWajeLinkedList() {
	}

	/** Create a list from an array of objects */
	public VeerWajeLinkedList(E[] objects) {
	  for (int i = 0; i < objects.length; i++)
	    add(objects[i]);
	}

	/** Return the head element in the list */
	public E getFirst() {
	  if (size == 0) {
	    return null;
	  }
	  else {
	    return head.element;
	  }
	}

	/** Return the last element in the list */
	public E getLast() {
	  if (size == 0) {
	    return null;
	  }
	  else {
	    return tail.element;
	  }
	}

	/** Add an element to the beginning of the list */
	public void addFirst(E e) {
		  Node<E> newNode = new Node<>(e); // Create a new node
		  newNode.next = head; // link the new node with the head
		  head = newNode; // head points to the new node
		  size++; // Increase list size

		  if (tail == null) // The new node is the only node in list
		    tail = head;
	}


	/** Add an element to the end of the list */
	public void addLast(E e) {
		  Node<E> newNode = new Node<>(e); // Create a new node for e

		  if (tail == null) {
		    head = tail = newNode; // The only node in list
		  }
		  else {
		    tail.next = newNode; // Link the new node with the last node
		    tail = newNode; // tail now points to the last node
		  }

		  size++; // Increase size
	}


	@Override /** Add a new element at the specified index in this list. The index of the head element is 0 */
	public void add(int index, E e) {
		if (index == 0) addFirst(e); // Insert first
		else if (index >= size) addLast(e); // Insert last
		else { // Insert in the middle
			Node<E> current = head;
		    for (int i = 1; i < index; i++)
		    	current = current.next;
		    Node<E> temp = current.next;
		    current.next = new Node<>(e);
		    (current.next).next = temp;
		    size++;
		}
	}

	/** Remove the head node and return the object that is contained in the removed node. */
	 public E removeFirst() {
		 if (size == 0) return null; // Nothing to delete
		 else {
			 Node<E> temp = head; // Keep the first node temporarily
			 head = head.next; // Move head to point to next node
			 size--; // Reduce size by 1
			 if (head == null) tail = null; // List becomes empty
			 return temp.element; // Return the deleted element
		 }
	 }

	/** Remove the last node and return the object that is contained in the removed node. */
	 public E removeLast() {
		  if (size == 0 || size == 1) {
		    return removeFirst();
		  }
		  else {
		    Node<E> current = head;
		    for (int i = 0; i < size - 2; i++) {
		      current = current.next;
		    }

		    E temp = tail.element;
		    tail = current;
		    tail.next = null;
		    size--;
		    return temp;
		 }
	}


	@Override /** Remove the element at the specified position in this list. Return the element that was removed from the list. */
	public E remove(int index) {
		  if (index < 0 || index >= size) return null; // Out of range
		  else if (index == 0) return removeFirst(); // Remove first
		  else if (index == size - 1) return removeLast(); // Remove last
		  else {
		    Node<E> previous = head;

		    for (int i = 1; i < index; i++) {
		      previous = previous.next;
		    }

		    Node<E> current = previous.next;
		    previous.next = current.next;
		    size--;
		    return current.element;
		  }
	}


	@Override /** Override toString() to return elements in the list */
	public String toString() {
	  StringBuilder result = new StringBuilder("[");

	  Node<E> current = head;
	  for (int i = 0; i < size; i++) {
	    result.append(current.element);
	    current = current.next;
	    if (current != null) {
	      result.append(", "); // Separate two elements with a comma
	    }
	    else {
	      result.append("]"); // Insert the closing ] in the string
	    }
	  }

	  return result.toString();
	}

	@Override /** Clear the list */
	public void clear() {
	  size = 0;
	  head = tail = null;
	}

	@Override /** Return true if this list contains the element e */
	public boolean contains(Object e) {
        if (e == null) {
            for (E element : this) {
                if (element == null) {
                    return true;
                }
            }
        } else {
            for (E element : this) {
                if (e.equals(element)) {
                    return true;
                }
            }
        }
        return false;
	}

	@Override /** Return the element at the specified index */
	public E get(int index) {
        
		if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
		Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
	}

	@Override /** Return the index of the first matching element in this list. Return −1 if no match. */
	public int indexOf(Object e) {
		// If the element is null, find the first occurrence of null in the list
        if (e == null) {
            int index = 0;
            for (Node<E> x = head; x != null; x = x.next) {
                if (x == null)
                    return index;
                index++;
            }
        } else {
            // If the element is not null, find the first occurrence of the specified element in the list
            int index = 0;
            for (Node<E> x = head; x != null; x = x.next) {
                if (e.equals(x))
                    return index;
                index++;
            }
        }
        // If the element is not found, return -1
        return -1;
	}

	@Override /** Return the index of the last matching element in this list. Return −1 if no match. */
	public int lastIndexOf(E e) {
		 int lastIndex = -1;
	        if (e == null) {
	            for (int i = size() - 1; i >= 0; i--) {
	                if (get(i) == null) {
	                    lastIndex = i;
	                    break;
	                }
	            }
	        } else {
	            for (int i = size() - 1; i >= 0; i--) {
	                if (e.equals(get(i))) {
	                    lastIndex = i;
	                    break;
	                }
	            }
	        }
	        return lastIndex;
	 }
	

	@Override /** Replace the element at the specified position in this list with the specified element. */
	public E set(int index, E e) {
		if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
		 Node<E> currentNode = (VeerWajeLinkedList.Node<E>) get(index);
	        E oldValue = currentNode.element;
	        currentNode.element = e;
	        return oldValue;
	}

	@Override /** Override iterator() defined in Iterable */ 
	public java.util.Iterator<E> iterator() {
	  return new LinkedListIterator();
	}

	private class LinkedListIterator
	    implements java.util.Iterator<E> {
	  private Node<E> current = head; // Current index
	  private Node<E> previous = null;

	  @Override
	  public boolean hasNext() {
	    return (current != null);
	  }

	  @Override
	  public E next() {
	    E e = current.element;
	    previous = current;
        current = current.next;
        return e;
	  }

	  @Override
	  public void remove() {
		  if (previous == null) {
              // Removing the first element in the list
              head = head.next;
          } else {
              previous.next = current;
          }

          if (current == null) {
              // The iterator is at the end of the list
              tail = previous;
          }
	  }
	}

	private static class Node<E> {
	  E element;
	  Node<E> next;

	  public Node(E element) {
	    this.element = element;
	  }
	}

	@Override /** Return the number of elements in this list */
	public int size() {
	  return size;
	}
	
	public void veerWajePrint() {
		System.out.print("LINKEDLIST=[");
        for (int i = 0; i < size() - 1; i++) {
            System.out.print(get(i) + ", ");
        }
        System.out.println(get(size() - 1) + "]");
	}

}
