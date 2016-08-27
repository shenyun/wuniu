package cn.shenyun.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class InstantiationTracingBeanPostProcessor implements
        ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (event.getApplicationContext().getParent() == null) {
            // root application context 没有parent，他就是老大.
            // 需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。
            System.out.println("parent");
            ApplicationContext ac=event.getApplicationContext();
            String[] beanNameArray=ac.getBeanDefinitionNames();
            for (int i = 0; i < beanNameArray.length; i++) {
                logger.info("parent bean 【"+beanNameArray[i]+"】 init ok");
            }
        } else {
            System.out.println("child");
            ApplicationContext ac=event.getApplicationContext();
            String[] beanNameArray=ac.getBeanDefinitionNames();
            for (int i = 0; i < beanNameArray.length; i++) {
                logger.info("mvc bean 【" + beanNameArray[i] + "】 init ok");
            }
        }
        logger.info("spring bean 初始化完成");
    }
}