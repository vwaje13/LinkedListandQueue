import java.util.Collection;
import java.util.Iterator;

public interface VeerWajeList<E> extends Collection<E>
{
	    
	     /** Add a new element at the specified index in this list */
	     public void add(int index, E e);
	 
	     /** Return the element from this list at the specified index */
	     public E get(int index);
	
	    /** Return the index of the first matching element in this list.
	     *  Return −1 if no match. */
	    public int indexOf(Object e);
	
	    /** Return the index of the last matching element in this list
	     *  Return −1 if no match. */
	    public int lastIndexOf(E e);
	
	    /** Remove the element at the specified position in this list 
	     *  Shift any subsequent elements to the left.
	     *  Return the element that was removed from the list. */
	    public E remove(int index);
	
	    /** Replace the element at the specified position in this list
	     *  with the specified element and returns the new set. */
	    public E set(int index, E e);
	 
	    @Override /** Add a new element at the end of this list */
	    public default boolean add(E e) {
	      add(size(), e);
	      return true;
	    }
	
	    @Override /** Return true if this list contains no elements */
	    public default boolean isEmpty() {
	      return size() == 0;
	    }
	
	    @Override /** Remove the first occurrence of the element e 
	     * from this list. Shift any subsequent elements to the left.
	     * Return true if the element is removed. */
	    public default boolean remove(Object e) {
	      if (indexOf(e) >= 0) {
	        remove(indexOf(e));
	        return true;
	      }
	      else
	        return false;
	    }

	
		@Override
	    public default boolean containsAll(Collection<?> c) {
			for (Object obj : c) {
	            if (!contains(obj)) {
	                return false;
	            }
	        }
	        return true;
	    }
	
	    @Override
	    public default boolean addAll(Collection<?  extends E> c) {
	    	 boolean modified = false;
	         for (E element : c) {
	             if (add(element)) {
	                 modified = true;
	             }
	         }
	         return modified;
	    }
	
	    @Override
	    public default boolean removeAll(Collection<?> c) {
	    	boolean modified = false;

	        Iterator<E> it = iterator();
	        while (it.hasNext()) {
	            E element = it.next();
	            if (c.contains(element)) {
	                it.remove();
	                modified = true;
	            }
	        }

	        return modified;
	    }
	
	    @Override
	    public default boolean retainAll(Collection<?> c) {
	    	 boolean modified = false;
	         Iterator<E> iterator = this.iterator();

	         while (iterator.hasNext()) {
	             E element = iterator.next();
	             if (!c.contains(element)) {
	                 iterator.remove();
	                 modified = true;
	             }
	         }
	         return modified;
	    }
	
	    @Override
	    public default Object[] toArray() {
	    	// Create an array of the same type as the elements in the list
	        // with the size of the list
	        E[] array = (E[]) new Object[size()];

	        // Copy each element from the list to the array
	        for (int i = 0; i < size(); i++) {
	            array[i] = get(i);
	        }

	        return array;
	    }
	
	    @Override
	    public default <T> T[] toArray(T[] array) {
	    	int size = size();
	        
	        // If the input array is too small, create a new array of the same type with the correct size
	        if (array.length < size) {
	            array = (T[]) java.lang.reflect.Array.newInstance(array.getClass().getComponentType(), size);
	        }
	        
	        Object[] elements = this.toArray();
	        
	        // Copy elements from the internal array to the provided array
	        if (array.length >= size) {
	            System.arraycopy(elements, 0, array, 0, size);
	            
	            // If the provided array is larger, set the element after the last one to null
	            if (array.length > size) {
	                array[size] = null;
	            }
	        }
	        
	        return array;
	    }
	    public default void veerWajePrint() {
	    	 System.out.print("LIST=[");
	         for (int i = 0; i < size() - 1; i++) {
	             System.out.print(get(i) + ", ");
	         }
	         System.out.println(get(size() - 1) + "]");
	    }

}
