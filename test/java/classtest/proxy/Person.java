package classtest.proxy;

import classtest.util.Null;

/**
 * Created by cheng on 2016/4/7 0007.
 */
public class Person {
    public  String first;

    public  String last;

    public  String address;

    public Person(String first, String last, String address) {
        this.first = first;
        this.last = last;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person : "+first+" "+last+" "+address;
    }
    public static class NullPerson extends Person implements Null{

        public NullPerson() {
            super("None", "None", "None");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }
    public  static final Person NULL=new NullPerson();
}
