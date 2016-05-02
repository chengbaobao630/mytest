package enumTest;

import java.security.Security;

/**
 * Created by cheng on 2016/4/27 0027.
 */
public enum SecurityCategory {
    STOCK(Security.STOCK.class),BOND(Security.BOND.class);
    Security[] values;
    interface Security{
        enum STOCK implements Security{SHORT,LONG,MARGIN}
        enum BOND implements Security{MUNICIPAL,JUNK}
    }

    SecurityCategory(Class<? extends Security> kind) {
        values=kind.getEnumConstants();
    }

    public Security randomSelection(){
        return Enums.random(values);
    }
    public static void main(String args[]){
        for(int i=0;i<10;i++){
            SecurityCategory category=
                    Enums.random(SecurityCategory.class);
            System.out.println(category+":"+
            category.randomSelection());
        }
    }
}
