package enumTest;
import java.util.EnumMap;

import  static enumTest.Input.*;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public enum Category {
    MONEY(NICKEL,DIME,QUARTER,DOLLAR),
    ITEM_SELECTION(TOOTHPASTE,CHIPS,SODA,SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;
    Category(Input... values) {
        this.values = values;
    }
    private  static EnumMap<Input,Category> categories=new EnumMap<>(Input.class);
    static {
        for(Category c:Category.class.getEnumConstants()){
            for(Input type:c.values){
                categories.put(type,c);
            }
        }
    }
    public static Category categoriza(Input input){
        return categories.get(input);
    }
}
