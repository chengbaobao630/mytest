package classtest.proxy;

import java.util.ArrayList;

/**
 * Created by cheng on 2016/4/7 0007.
 */
public class Staff extends ArrayList<Position> {
    public void add(String title,Person employee){
        add(new Position(title,employee));
    }

    public  void  add(String ...titles){
        for(String title:titles)
            add(new Position(title,Person.NULL));
    }
    public Staff(String ... titles){
        add(titles);
    }
    public boolean positionAvailable(String title){
        for (Position position:this)
            if (position.getTitle().equals(title)&&position.getPerson()==Person.NULL)
                return  true;
            return false;
    }
    public  void  fillPosition(String title,Person hire){
        for(Position position:this)
            if (position.getTitle().equals(title)&&position.getPerson()==Person.NULL){
                position.setPerson(hire);
                return;
              }
            throw  new RuntimeException(
                    "Position "+title+"is not available");
    }
}
