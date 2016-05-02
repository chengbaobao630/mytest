package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cheng on 2016/4/21 0021.
 */
public class Interview {

    public static void main(String args[]){
        Pattern pattern=Pattern.compile("(^[12]?\\d{0,3})[-./][01][1-9][-./]([012][0-9]|[3][01])$");
        Matcher matcher=pattern.matcher("1992.03.20");
        System.out.println(matcher.matches());

        Pattern pattern1=Pattern.compile("^\\s+|\\s+$");
        Matcher matcher1=pattern1.matcher("&&&&");
            System.out.println(matcher1.matches());
    }
}
