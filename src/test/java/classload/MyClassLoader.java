package classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String root;

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        System.out.println(fileName);

        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            int bufferSize = 1024;
//            byte[] buffer = new byte[bufferSize];
//            int length = 0;
//            while ((length = ins.read(buffer)) != -1) {
//                baos.write(buffer, 0, length);
//            }

            int temp;
            //实现简单的解密处理：取反操作
            while ((temp = ins.read()) != -1){
                baos.write(temp ^ 0xff);
            }

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args) throws ClassNotFoundException {

        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("/Users/dhp/Documents/Programs/JavaTrain/src/test/temp");
        Class<?> testClass = classLoader.loadClass("People");
        System.out.println(testClass);

    }
}
