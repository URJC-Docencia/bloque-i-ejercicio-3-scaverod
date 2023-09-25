
package ejercicio3;

import material.Position;

import java.util.Iterator;

/**
 * An interface representing a better version of the List data structure.
 *
 * @param <E> the type of elements in the list
 */
public interface MyListBetter<E> extends Iterable<Position<E>> {
    /**
     * Returns the number of elements in this list
     *
     * @return the number of elements in this list
     */
    public int size();

    /**
     * Returns true if this list contains no elements
     *
     * @return true if this list contains no elements, false otherwise
     */
    public boolean isEmpty();

    /**
     * Appends the specified element to the beginning of this list
     *
     * @param value the element to be appended to this list
     * @return the position of the element
     */
    public Position<E> add(E value);

    /**
     * Inserts the specified element after the specified position in this list (optional operation)
     *
     * @param pos   position after which the specified element is to be inserted
     * @param value value to be inserted
     * @return the position of the element
     */
    public Position<E> addAfter(Position<E> pos, E value);

    /**
     * Inserts the specified element before the specified position in this list (optional operation)
     *
     * @param pos   position before which the specified element is to be inserted
     * @param value value to be inserted
     * @return the position of the element
     */
    public Position<E> addBefore(Position<E> pos, E value);

    /**
     * Remove and returns the element at the beginning of this list
     *
     * @param pos position of the element to be removed
     * @return element at the beginning of this list
     */
    public E remove(Position<E> pos);


    /**
     * Returns the element at the beginning of this list
     *
     * @return the element at the beginning of this list
     */
    public Position<E> get();

    /**
     * Modifies the element at the specified position in this list
     *
     * @param pos   position of the element to be modified
     * @param value new value to be stored at the specified position
     * @return the element previously at the specified position
     */
    public Position<E> set(Position<E> pos, E value);

    /**
     * Returns the element's Position if this list contains the specified element
     * otherwise returns null
     *
     * @param value element to be searched for
     * @return the element's Position if this list contains the specified element
     */
    public Position<E> search(E value);

    /**
     * Returns true if this list contains the specified element.
     *
     * @param value element whose presence in this list is to be tested
     * @return true if this list contains the specified element, false otherwise
     */
    public boolean contains(E value);

    /**
     * Returns an iterator of the elements
     *
     * @return an iterator of the elements
     */
    @Override
    public Iterator<Position<E>> iterator();
}
