package test.wuniu;


import org.apache.commons.lang.math.NumberUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

/**
 * Created by yong.luo on 2016/6/21.
 */

public class TestMain {
    @Test
    public void  test() {
        System.out.println("test");
        String a="1233";
        System.out.println(a.toString());
        Double dd=123.56D;
//        Object fa=dd;
//        Integer intt=(Integer)fa;
        System.out.println(dd.toString());
        if (NumberUtils.isNumber(dd.toString())) {
            BigDecimal big=new BigDecimal(dd.toString());
            System.out.println(big);
        }

    }
    @Test
    public void  test2(){
        for (int i = 0; i <20 ; i++) {
            String uuid=UUID.randomUUID().toString();
            System.out.println(uuid);
        }


    }
}