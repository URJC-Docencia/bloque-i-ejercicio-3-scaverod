package ejercicio3;

import material.Position;

import java.util.Iterator;

public class LinkedPositionList<E> implements MyListBetter<E> {


    private class DLinkedNode<E> implements Position<E> {

        private DLinkedNode<E> next;
        private DLinkedNode<E> prev;
        private E element;

        public DLinkedNode(DLinkedNode<E> next, DLinkedNode<E> prev, E element) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        public DLinkedNode<E> getNext() {
            return next;
        }

        public DLinkedNode<E> getPrev() {
            return prev;
        }

        /**
         * Return the element stored at this position.
         */
        @Override
        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public void setNext(DLinkedNode<E> next) {
            this.next = next;
        }

        public void setPrev(DLinkedNode<E> prev) {
            this.prev = prev;
        }


    }


    /* AQUÍ EMPIEZA LA DEFINICIÓN DE LA CLASE */

    private DLinkedNode<E> head;
    private int size;


    public LinkedPositionList(){
        head = null;
        size = 0;
    }

    /**
     * Returns the number of elements in this list
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains no elements
     *
     * @return true if this list contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Appends the specified element to the beginning of this list
     *
     * @param value the element to be appended to this list
     * @return the position of the element
     */
    @Override
    public Position<E> add(E value) {
        DLinkedNode<E> newNode = new DLinkedNode<>(null, null, value);
        if(this.head != null) {
            newNode.setNext(this.head);
            head.setPrev(newNode);
        }
        this.head = newNode;
        this.size++;
        return newNode;
    }


    /**
     * Checks if the given position is valid and returns the corresponding node.
     *
     * @param pos The position to check.
     * @return The node corresponding to the given position.
     * @throws RuntimeException if the position is null or not an instance of DLinkedNode.
     * @throws RuntimeException if the node previous to the position is null, indicating an invalid position.
     */
    private DLinkedNode<E> checkPosition(Position<E> pos) {
        if (!(pos instanceof DLinkedNode)) {
            throw new RuntimeException("The position is invalid");
        }
        return (DLinkedNode<E>) pos;
    }

    /**
     * Inserts the specified element after the specified position in this list (optional operation)
     *
     * @param pos   position after which the specified element is to be inserted
     * @param value value to be inserted
     * @return the position of the element
     */
    @Override
    public Position<E> addAfter(Position<E> pos, E value) {
        return null;
    }

    /**
     * Inserts the specified element before the specified position in this list (optional operation)
     *
     * @param pos   position before which the specified element is to be inserted
     * @param value value to be inserted
     * @return the position of the element
     */
    @Override
    public Position<E> addBefore(Position<E> pos, E value) {
        DLinkedNode<E> node = checkPosition(pos);
        if (head == node) return add(value);
        DLinkedNode<E> newNode = new DLinkedNode<>(null, null, value);
        newNode.setNext(node);
        newNode.setPrev(node.getPrev());
        node.setPrev(newNode);
        newNode.getPrev().setNext(newNode);
        this.size++;
        return newNode;
    }

    /**
     * Remove and returns the element at the beginning of this list
     *
     * @param pos position of the element to be removed
     * @return element at the beginning of this list
     */
    @Override
    public E remove(Position<E> pos) {
        return null;
    }

    /**
     * Returns the element at the beginning of this list
     *
     * @return the element at the beginning of this list
     */
    @Override
    public Position<E> get() {
        return null;
    }

    /**
     * Modifies the element at the specified position in this list
     *
     * @param pos   position of the element to be modified
     * @param value new value to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public Position<E> set(Position<E> pos, E value) {
        return null;
    }

    /**
     * Returns the element's Position if this list contains the specified element
     * otherwise returns null
     *
     * @param value element to be searched for
     * @return the element's Position if this list contains the specified element
     */
    @Override
    public Position<E> search(E value) {
        return null;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param value element whose presence in this list is to be tested
     * @return true if this list contains the specified element, false otherwise
     */
    @Override
    public boolean contains(E value) {
        return false;
    }

    /**
     * Returns an iterator of the elements
     *
     * @return an iterator of the elements
     */
    @Override
    public Iterator<Position<E>> iterator() {
        return new Iterator<Position<E>>() {

            private DLinkedNode<E> node = head;

            
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public Position<E> next() {
                DLinkedNode<E> aux = node;
                node = node.getNext();
                return aux;
            }
        };
    }
}
