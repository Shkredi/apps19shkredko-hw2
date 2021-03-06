package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    private ImmutableArrayList empty_list, list;

    @Before
    public void setUp() throws Exception {
        empty_list = new ImmutableArrayList();
        list = new ImmutableArrayList(new Object[]{1, "abc", 2.5, 'd'});
    }

    @Test
    public void add1() {
        assertArrayEquals(new Object[]{1, "abc", 2.5, 'd', 5}, list.add(5).toArray());
        assertArrayEquals(new Object[]{"fff"}, empty_list.add("fff").toArray());
    }

    @Test
    public void add2() {
        assertArrayEquals(new Object[]{1, "abc", "2", 2.5, 'd'}, list.add(2,"2").toArray());
        assertArrayEquals(new Object[]{5.3}, empty_list.add(0, 5.3).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add3() {
        list.add(-3,"2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void add4() {
        empty_list.add(2, 5.3);
    }

    @Test
    public void addAll1() {
        assertArrayEquals(new Object[]{1, "abc", 2.5, 'd', 5, "f", 3.14}, list.addAll(new Object[]{5, "f", 3.14}).toArray());
        assertArrayEquals(new Object[]{"abc", '4'}, empty_list.addAll(new Object[]{"abc", '4'}).toArray());
    }

    @Test
    public void AddAll2() {
        assertArrayEquals(new Object[]{1, "abc", 2.5, 'd'}, list.addAll(2, new Object[]{}).toArray());
        assertArrayEquals(new Object[]{1, "1..0"}, empty_list.addAll(0, new Object[]{1, "1..0"}).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAll3() {
        list.addAll(-3, new Object[]{"abc", '4'});
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void AddAll4() {
        empty_list.addAll(1, new Object[]{});
    }

    @Test
    public void get1() {
        assertEquals("abc", list.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get2() {
        empty_list.get(1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void get3() {
        list.get(-5);
    }

    @Test
    public void remove1() {
        assertArrayEquals(new Object[]{1, "abc", 'd'}, list.remove(2).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove2() {
        list.remove(5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void remove3() {
        list.remove(-2);
    }

    @Test
    public void set1() {
        assertArrayEquals(new Object[]{1, "c", 2.5, 'd'}, list.set(1, "c").toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void set2() {
        list.set(6, "q");
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void set3() {
        list.set(-3, "q");
    }

    @Test
    public void indexOf() {
        assertEquals(1, list.indexOf("abc"));
        assertEquals(-1, list.indexOf('1'));
        assertEquals(-1, empty_list.indexOf(3));
    }

    @Test
    public void size() {
        assertEquals(4, list.size());
        assertEquals(0, empty_list.size());
    }

    @Test
    public void clear() {
        assertArrayEquals(new Object[]{}, list.clear().toArray());
        assertArrayEquals(new Object[]{}, empty_list.clear().toArray());
    }

    @Test
    public void isEmpty() {
        assertFalse(list.isEmpty());
        assertTrue(empty_list.isEmpty());
    }

    @Test
    public void toArray() {
        assertArrayEquals(new Object[]{1, "abc", 2.5, 'd'}, list.toArray());
        assertArrayEquals(new Object[]{}, empty_list.toArray());
    }

    @Test
    public void ToString() {
        assertEquals("[1, abc, 2.5, d]", list.toString());
        assertEquals("[]", empty_list.toString());
    }
}
