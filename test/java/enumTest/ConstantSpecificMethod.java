package enumTest;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public enum ConstantSpecificMethod {
    DATE_TIME{
        String getInfo(){
            return
                    DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH{
        String getInfo(){
            return
                   System.getenv("CLASSPATH");
        }
    },
    VERSION{
        String getInfo(){
            return
                    System.getProperty("java.version");
        }
    };

    abstract String getInfo();

    public static void main(String[] args){
        for(ConstantSpecificMethod csm:values()){
            System.out.println(csm.getInfo());
        }
    }
}
