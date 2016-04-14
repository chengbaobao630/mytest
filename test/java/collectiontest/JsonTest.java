package collectiontest;

import net.sf.json.JSONObject;

/**
 * Created by cheng on 2016/3/29 0029.
 */
public class JsonTest {

    public static   void  main(String[] args){
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("three","three");
        JSONObject jsonObject2=new JSONObject();
        jsonObject2.put("two",jsonObject);
        JSONObject jsonObject3=new JSONObject();
        jsonObject3.put("one",jsonObject2);
        System.out.println(jsonObject3.get("one").toString());
    }
}
