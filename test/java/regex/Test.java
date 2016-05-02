package regex;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by cheng on 2016/4/18 0018.
 */
public class Test {

    public  static void  main(String args[]){
        String matchString="Java now has regular _*expressions";
        String[] patterns={"^Java.n.w\\s+h(a|i)s(\\s\\w*){1,}"};
        for(String p:patterns){
            Pattern pattern=Pattern.compile(p);
            Matcher matcher=pattern.matcher(matchString);
            while (matcher.find()){
                System.out.print(p+"    "+ matcher.group(2)+"     start:"+ matcher.start()+"     end:"+ matcher.end());
                System.out.println();
            }
            System.out.println("matchers:"+matcher.matches());
        }
        System.out.println("------------------------------");
        System.out.println(matchString.startsWith("Java"));
    }

  /*  public  static void  main(String args[]) {
        String matchString = "abcabcabcdefabc";
        String[] patterns = {"abc+","(abc)","(abc){2,}"};
        for (String p : patterns) {
            Pattern pattern = Pattern.compile(p);
            Matcher matcher = pattern.matcher(matchString);
            while (matcher.find()){
                System.out.print(p);
                System.out.print("         "+matcher.group()+"start:"+matcher.start()+"end:"+(matcher.end()-1));
                System.out.println();
            }
        }
        System.out.println("------------------------------");
        System.out.println(matchString.startsWith("Java"));
    }*/
}
