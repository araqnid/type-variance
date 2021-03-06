package org.araqnid.typevariance;

import java.time.Instant;
import java.time.temporal.Temporal;
import java.util.Iterator;

public class Arrays {
    public static int count(Iterable<?> iterable) {
        int size = 0;
        Iterator<?> iter = iterable.iterator();
        while (iter.hasNext()) {
            @SuppressWarnings("unused") Object x = iter.next();
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        Integer[] ints = new Integer[] { 1, 2, 3 };
        Object[] any = new Object[3];
        Arrays.copy(ints, any); // Java arrays are covariant
        
        Arrays.fill(new Temporal[2], Instant.EPOCH);
    }

    private static <T> void copy(T[] src, T[] dest) {
        assert src.length == dest.length;
        //noinspection ManualArrayCopy
        for (int i = 0; i < src.length; i++)
            dest[i] = src[i];
    }

    private static <T> void fill(T[] dest, T value) {
        for (int i = 0; i < dest.length; i++)
            dest[i] = value;
    }
}
