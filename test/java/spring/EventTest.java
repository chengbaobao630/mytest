package spring;

import cc.firstTest.spring.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by cheng on 2016/4/18 0018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application.xml" })
public class EventTest {

    @Resource
    Log log;

    @Test
    public void testEvent(){
        log.log("hello");
    }
}
