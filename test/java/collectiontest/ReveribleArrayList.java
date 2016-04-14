package collectiontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by cheng on 2016/3/29 0029.
 */
public class ReveribleArrayList<T> extends ArrayList<T> {
    public ReveribleArrayList(Collection<? extends T> c) {
        super(c);
    }
    public Iterable<T> reversed(){
        return new Iterable<T>(){
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current=size()-1;
                    @Override
                    public boolean hasNext() {
                        return current>-1;
                    }

                    @Override
                    public T next() {
                        return get(current--);
                    }

                    @Override
                    public void remove() {
                        throw  new UnsupportedOperationException();
                    }
                };
            }
        };
    }

    public  static  void main(String[] args){
        ReveribleArrayList<String> ral=new ReveribleArrayList<>(
                Arrays.asList("To be or not to be".split(" "))
        );
        for (String s:ral.reversed()){
            System.out.print(s+" ");
        }
    }
}
