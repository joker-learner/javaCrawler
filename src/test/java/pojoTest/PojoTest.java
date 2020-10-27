package pojoTest;

import com.lc.pojo.Item;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class PojoTest {
    @Test
    public void test1(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        Item item = (Item)app.getBean("item");
        item.setPic("asdasdw.jpg");
        System.out.println(item.toString());
    }
}
