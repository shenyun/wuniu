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
    public static void main(String[] args) {

        String bizCode="114001";
        String fileId="390208";
        String absoluteUrl="http://filesystem.msxf.lotest/file/download?bizCode="+bizCode+"&fileId="+fileId;

    }
    @Test
    public void dd(){
        String aa="123";

        aa.equals(null);
        System.out.println("oo");
    }
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
    @Test
    public void test3(){

        long workerIdBits = 5L;
        long dd1=(-1L << workerIdBits);
        long maxWorkerId = -1L ^(-1L << workerIdBits);
        System.out.println(dd1);
        System.out.println(maxWorkerId);
        System.out.println(1<<5);
    }
    @Test
    public void test4(){
        boolean[] a=new boolean[150];
        for (int i = 0; i <150 ; i++) {
            a[i]=false;
        }

        for (int i = 0; i <150 ; i++) {
            if((i+1)%3==0){
                a[i]=!a[i];
            }
        }

        for (int i = 0; i <150 ; i++) {
            if((i+1)%5==0){
                a[i]=!a[i];
            }
        }
        int lia=0;
        for (int i = 0; i <150 ; i++) {
            if(a[i]==true){
                lia=lia+1;
            }
        }
        System.out.println(lia);

    }
    @Test
    public void split(){
        String aa="good";
        String[] jsonPathArr=aa.split(",");
        for (int i = 0; i <jsonPathArr.length ; i++) {
            System.out.println(jsonPathArr[i]);
        }
    }
}