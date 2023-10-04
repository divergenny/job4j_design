package ru.job4j.pool;

public class StringPoolExample {

    public void firstExample() {
        String string1 = "Hello, world";
        String string2 = "Hello, " + "world";
        System.out.println(string1 == string2);
    }

    /**
     * Comparing references obtained as a result of concatenation of the entire string string3 and string1,
     * which is identical in value, will return false, because the calculation of string3
     * will occur only during program execution, and the resulting string string3 will be created on the heap.
     */
    public void secondExample() {
        String string1 = "Hello, world";
        String string2 = "Hello, ";
        String string3 = string2 + "world";
        System.out.println(string1 == string3);
    }

    /**
     * \
     * When the intern method is invoked, if the pool already contains a string equal to this String object
     * as determined by the equals(Object) method, then the string from the pool is returned. Otherwise,
     * this String object is added to the pool and a reference to this String object is returned.
     */
    public void methodIntern() {
        System.out.println(new String("New string") == new String("New string"));
        System.out.println(new String("Interned string").intern() == new String("Interned string").intern());
    }

    /**
     * From -128 to 128
     */
    public void integerPool() {
        Integer pool1 = 127;
        Integer pool2 = 127;
        System.out.println(pool1 == pool2);
        Integer heap1 = -129;
        Integer heap2 = -129;
        System.out.println(heap1 == heap2);
    }
}
