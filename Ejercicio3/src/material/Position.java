package material;


/**
 * An interface representing a position in a list.
 *
 * @param <E> the type of element stored at this position
 */
public interface Position<E> {
  /** Return the element stored at this position. */
  E getElement();
}
