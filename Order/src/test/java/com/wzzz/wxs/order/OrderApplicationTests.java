package com.wzzz.wxs.order;

import com.alibaba.druid.filter.config.ConfigTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {
        private String password;
        @Test
        public void testDruid() {
            password = "19970121";
            try {
                ConfigTools.main(new String[]{password});
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


}
