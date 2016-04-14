package collectiontest;

import java.util.Iterator;

/**
 * Created by cheng on 2016/3/29 0029.
 */
public class IterableClass implements Iterable<String> {
    protected String[] words=("And that we know the Earth to be banana-shaped").split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index<words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }

            @Override
            public void remove() {
            throw new UnsupportedOperationException();
            }
        };
    }
}
