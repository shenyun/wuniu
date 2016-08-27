package cn.shenyun.utils;


import org.springframework.beans.BeanUtils;
//import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Field;

/**
 * Created by luoyong on 2015/8/18.
 */
public class FieldCopyUtils {

    /**
     * 查询目标对象有哪些字段，目标对象中有，则从源对象中复制过来
     * 已经处理了父类中的字段
     * @param src
     * @param des
     */
    public static void copy(Object src,Object des){
//        copyByReflection(src,des);
        copyByCglib(src,des);
//        copyBySpring(src,des);
    }
    private static void copyBySpring(Object src,Object des){
        BeanUtils.copyProperties(src,des);
    }

    private static void copyByCglib(Object src,Object des){
//        BeanCopier copier =BeanCopier.create(src.getClass(), des.getClass(), false);
//        copier.copy(src, des, null);
    }
    /**
     * 查询目标对象有哪些字段，目标对象中有，则从源对象中复制过来
     * 已经处理了父类中的字段
     * @param src
     * @param des
     */
    private static void copyByReflection(Object src,Object des){
        Class desClass = des.getClass();
        Class srcClass = src.getClass();

        while (!desClass.getName().equals("java.lang.Object")) {
            Field[] fields = desClass.getDeclaredFields();
            copyField(fields, src, des);
            //操作父类
            desClass=desClass.getSuperclass();
        }
    }

    /**
     * 字段内容复制
     * @param fields
     * @param src
     * @param des
     */
    private static void copyField(Field[] fields,Object src,Object des){
        for (int i = 0; i <fields.length ; i++) {
            Field field=fields[i];
            String fieldName=field.getName();
            if(fieldName.equals("serialVersionUID")){
                continue;
            }
            Field srcField=getField(src.getClass(),fieldName);
            if(srcField!=null){
                try {
                    field.setAccessible(true);
                    srcField.setAccessible(true);
                    Object srcValue=srcField.get(src);
                    field.set(des, srcValue);
                    field.setAccessible(false);
                    srcField.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取对象的属性字段，要检索父类字段
     * @param objectClass
     * @param fieldName
     * @return
     */
    private static Field getField(Class<?> objectClass,String fieldName){
//        Class<?> objectClass=object.getClass();
        Field field=null;
        try {
            field=objectClass.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
        }
        //如果没有取到检查父类中有没有
        if(field==null&&!(objectClass.getSuperclass().getName().equals("java.lang.Object"))){
            return getField(objectClass.getSuperclass(),fieldName);
        }
        return field;
    }

//    public static void main(String[] agrs){
//        CategoryGuideDO categoryGuideDO= new CategoryGuideDO();
//        categoryGuideDO.setCategoryId(1);
//        CategoryGuideNdto categoryGuideNdto=new CategoryGuideNdto();
//        copy(categoryGuideDO,categoryGuideNdto);
//        System.out.println(categoryGuideNdto.getCategoryId());
//    }
//
//    public static void main1(String[] args){
//        CategoryDetailNdto categoryDetailNdto=new CategoryDetailNdto();
//
//        CategoryNdto categoryNdto=new CategoryNdto();
//        categoryNdto.setCategoryName("测试类目");
//        copy(categoryNdto, categoryDetailNdto);
//
//        System.out.println(categoryDetailNdto.getCategoryName());
//    }
}
