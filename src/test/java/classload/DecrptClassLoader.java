package classload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 加载文件系统中加密后的class字节码的类加载器
 */
public class DecrptClassLoader extends ClassLoader{
    private String rootDir;

    public DecrptClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        if(c != null){
            return c;
        }else {
            ClassLoader parent = this.getParent();
            c = parent.loadClass(name); //委派给父类加载
            if (c != null) {
                return c;
            } else {
                byte[] classData = new byte[0];
                try {
                    classData = loadClassData(name);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                c = defineClass(name, classData, 0, classData.length);
            }
        }
        return c;
    }

    private byte[] loadClassData(String classname) throws IOException {
//        String path = rootDir + "/" + classname.replace('.','/') + ".class";
        String path = rootDir + File.separatorChar
                + classname.replace('.', File.separatorChar) + ".class";

        InputStream inputStream = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            inputStream = new FileInputStream(path);
            int temp;
            //实现简单的解密处理：取反操作
            while ((temp = inputStream.read()) != -1){
                baos.write(temp ^ 0xff);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null)
                inputStream.close();
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        DecrptClassLoader loader = new DecrptClassLoader("./src/test/java/classload/temp");
        Class<?> test = loader.loadClass("People");
        System.out.println(test);
    }

}
