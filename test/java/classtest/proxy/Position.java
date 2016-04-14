package classtest.proxy;

/**
 * Created by cheng on 2016/4/7 0007.
 */
public class Position {
    private String title;

    private Person person;

    public Position(String jobTitle, Person employee) {
        this.title = jobTitle;
        this.person = employee;
        if(person == null)
            person=Person.NULL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        if(person == null)
            person=Person.NULL;

    }

    public Position(String title) {
        this.title = title;
        this.person=Person.NULL;

    }

    @Override
    public String toString() {
        return "Position: "+title+" "+person;
    }
}
