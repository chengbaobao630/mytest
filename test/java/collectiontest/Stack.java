package collectiontest;

import java.util.LinkedList;


/**
 * Created by cheng on 2016/3/29 0029.
 */
public class Stack<T>  {
    private LinkedList<T>  storage=new LinkedList<>();

    public void push(T t){
        storage.addFirst(t);
    }
    public T peek(T t){
        return storage.getFirst();
    }
    public T pop(T t){
        return storage.removeFirst();
    }
    public boolean empty(){
        return storage.isEmpty();
    }
    public String toString() {
        return storage.toString();
    }
}
