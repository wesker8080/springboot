package com.wtwd.springboot;

import com.wtwd.springboot.model.Device;
import com.wtwd.springboot.service.DeviceService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    DeviceService deviceService;

    @BeforeClass
    public static void classBefore() {
        System.out.println("在每个类加载之前执行");
    }

    @AfterClass
    public static void classAfter() {
        System.out.println("在每个类加载之后执行");
    }

    @Before
    public void before() {
        System.out.println("在每个测试方法之前执行");
    }

    @After
    public void after() {
        System.out.println("在每个测试方法之后执行");
    }
    @Test
    @Transactional
    public void contextLoads() {
        Device device = new Device();
        device.setDevType("1");
        device.setDevGroup("A");
        device.setDevPower("66");
        device.setDevId(99);
        deviceService.addDevice(device);
    }
    @Test
    public void testHashCode() {
        String a = "Aa";
        String b = "BB";
        if (a.hashCode() == b.hashCode()) {
            if (a.equals(b)) {
                System.out.println("这两个对象相等");
            }
            System.out.println("这两个对象不相等");
        } else {
            System.out.println("这两个对象不相等");
        }
    }

}
