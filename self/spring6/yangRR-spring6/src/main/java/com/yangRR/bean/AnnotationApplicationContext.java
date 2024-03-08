package com.yangRR.bean;

import com.yangRR.anno.Bean;
import com.yangRR.anno.Di;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext{

    private Map<Class,Object> beanFactory = new HashMap<>();
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }


    public AnnotationApplicationContext(String basePackage){
        try {
//            String packagePath = basePackage.replace(".", "\\");
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            Enumeration<URL> urls =
                    Thread.currentThread().getContextClassLoader().getResources(packagePath);

            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        //依赖注入
        loadDi();

    }

    private void loadDi() {
        for(Map.Entry<Class,Object> entry : beanFactory.entrySet()){
            //就是咱们放在容器的对象
            Object obj = entry.getValue();
            Class<?> aClass = obj.getClass();
            Field[] declaredFields = aClass.getDeclaredFields();
            for (Field field : declaredFields){
                Di annotation = field.getAnnotation(Di.class);
                if( annotation != null ){
                    field.setAccessible(true);
                    try {
                        System.out.println("正在给【"+obj.getClass().getName()+"】属性【" + field.getName() +
                                "】注入值【"+ beanFactory.get(field.getType()).getClass().getName() +"】");
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }




    private void loadBean(File file) throws Exception {
        if(file.isDirectory()){
            File[] childFiles = file.listFiles();
            if (childFiles.length == 0 || childFiles == null) {
                return;
            }

            for(File child : childFiles){
                if(child.isDirectory()){
                    loadBean(child);
                }else {
                    String pathWithClass =
                            child.getAbsolutePath().substring(rootPath.length() - 1);
//                    System.out.println(pathWithClass);
                    if (pathWithClass.contains(".class")) {
                        String allName = pathWithClass.replaceAll("\\\\", "\\.")
                                .replace(".class", "");

                        Class<?> clazz = Class.forName(allName);

                        if(!clazz.isInterface()){
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                Object instance = clazz.getConstructor().newInstance();

                                if(clazz.getInterfaces().length > 0){
                                    beanFactory.put(clazz.getInterfaces()[0],instance);
                                }else {
                                    beanFactory.put(clazz,instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
