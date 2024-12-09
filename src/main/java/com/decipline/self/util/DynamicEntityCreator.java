package com.decipline.self.util;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.Entity;
import javassist.ClassPool;
import javassist.CtClass;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

@Service
public class DynamicEntityCreator {
//    todo : crete table dynamically

//    public static Class<?> createEntityClass(String className, String[] fieldNames){
//
//        if (StringUtils.isNotBlank(className) && (fieldNames!= null && fieldNames.length > 0)){
//            ClassPool pool = ClassPool.getDefault();
//            CtClass ctClass = pool.makeClass(className);
//
//            CtAnn
//
//        }
//    }
//
//    private static void addEntityAnnotation(CtClass ctClass) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<Entity> entityAnnotationClass = Entity.class;
//        Annotation annotation = entityAnnotationClass.getConstructor().newInstance();
//        ctClass.an
//    }
}
