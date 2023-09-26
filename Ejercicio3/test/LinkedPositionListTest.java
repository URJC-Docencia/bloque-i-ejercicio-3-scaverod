import ejercicio3.LinkedPositionList;
import material.Position;
import org.junit.*;

import java.util.Iterator;

import static org.junit.Assert.*;


public class LinkedPositionListTest {

    private LinkedPositionList<String> list;

    @Before
    public void setUp() {
        list = new LinkedPositionList<>();
    }

    @Test
    public void testAdd() {
        assertTrue(list.isEmpty());

        list.add("Estructuras");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());

        list.add("de");
        assertEquals(2, list.size());

        list.add("datos");
        assertEquals(3, list.size());

        list.add("avanzadas");
        assertEquals(4, list.size());
    }

    @Test
    public void testAddAfter() {
        Position<String> posEstructuras = list.add("Estructuras");
        Position<String> posDatos = list.addAfter(posEstructuras, "datos");

        Iterator<Position<String>> iter = list.iterator();
        assertEquals("Estructuras", iter.next().getElement());
        assertEquals("datos", iter.next().getElement());
        assertEquals("datos", posDatos.getElement());
        assertEquals("Estructuras", list.get().getElement());
        assertEquals(2, list.size());

        Position<String> posAvanzadas = list.addAfter(posDatos, "avanzadas");
        iter = list.iterator();
        assertEquals("Estructuras", iter.next().getElement());
        assertEquals("datos", iter.next().getElement());
        assertEquals("avanzadas", iter.next().getElement());
        assertEquals("avanzadas", posAvanzadas.getElement());
        assertEquals("Estructuras", list.get().getElement());
        assertEquals(3, list.size());

        Position<String> posDe = list.addAfter(posEstructuras, "de");
        iter = list.iterator();
        assertEquals("Estructuras", iter.next().getElement());
        assertEquals("de", iter.next().getElement());
        assertEquals("datos", iter.next().getElement());
        assertEquals("avanzadas", iter.next().getElement());
        assertEquals("de", posDe.getElement());
        assertEquals("Estructuras", list.get().getElement());
        assertEquals(4, list.size());
    }

    @Test
    public void testAddBefore() {
        Position<String> posEstructuras = list.add("Estructuras");
        Position<String> posDe = list.addBefore(posEstructuras, "de");

        assertEquals("de", posDe.getElement());
        assertEquals(2, list.size());

        Position<String> posDatos = list.addBefore(posEstructuras, "datos");
        assertEquals("datos", posDatos.getElement());
        assertEquals(3, list.size());
    }

    @Test
    public void testRemove() {
        Position<String> posEstructuras = list.add("Estructuras");
        list.remove(posEstructuras);

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemove2() {
        Position<String> posEstructuras = list.add("Estructuras");
        Position<String> posDatos = list.addAfter(posEstructuras, "datos");
        Position<String> posAvanzadas = list.addAfter(posDatos, "avanzadas");
        Position<String> posDe = list.addBefore(posEstructuras, "de");

        list.remove(posEstructuras);
        list.remove(posDatos);
        list.remove(posAvanzadas);
        list.remove(posDe);

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    public void testRemove3() {
        // try to remove an element that does not exist
        Position<String> posEstructuras = list.add("Estructuras");

        // We try to remove twice the same element
        list.remove(posEstructuras);

        // Now we have to catch a java.lang.RuntimeException when list.remove(posEstructuras);
        try {
            list.remove(posEstructuras);
            fail("Expected an RuntimeException to be thrown");
        } catch (RuntimeException re) {
            assertEquals("The list is empty", re.getMessage());
        }


    }

    @Test
    public void testGet() {
        list.add("Estructuras");
        assertEquals("Estructuras", list.get().getElement());

        list.add("de");
        assertEquals("de", list.get().getElement());

        list.add("datos");
        assertEquals("datos", list.get().getElement());

        list.add("avanzadas");
        assertEquals("avanzadas", list.get().getElement());
    }

    @Test
    public void testSet() {
        Position<String> posEstructuras = list.add("Estructuras");
        list.set(posEstructuras, "Avanzadas");

        assertEquals("Avanzadas", list.get().getElement());
    }

    @Test
    public void testSearch() {
        Position<String> posEstructuras = list.add("Estructuras");
        Position<String> posDe = list.add("de");
        Position<String> posDatos = list.add("datos");

        assertEquals(posEstructuras, list.search("Estructuras"));
        assertEquals(posDe, list.search("de"));
        assertEquals(posDatos, list.search("datos"));
    }


    @Test
    public void testContains() {
        list.add("Estructuras");
        assertTrue(list.contains("Estructuras"));

        list.add("de");
        assertTrue(list.contains("de"));

        list.add("datos");
        assertTrue(list.contains("datos"));

        assertFalse(list.contains("avanzadas"));
    }

    @Test
    public void testIterator() {
        list.add("Estructuras");
        list.add("de");
        list.add("datos");
        list.add("avanzadas");

        Iterator<Position<String>> iter = list.iterator();

        assertTrue(iter.hasNext());
        assertEquals("avanzadas", iter.next().getElement());

        assertTrue(iter.hasNext());
        assertEquals("datos", iter.next().getElement());

        assertTrue(iter.hasNext());
        assertEquals("de", iter.next().getElement());

        assertTrue(iter.hasNext());
        assertEquals("Estructuras", iter.next().getElement());

        assertFalse(iter.hasNext());
    }



}