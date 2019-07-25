package classload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 加密工具类
 */
public class EncrptUtil {
    
    public static void encrpt(String src, String dest) throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(src);//接收文件的输入
            outputStream = new FileOutputStream(dest);//输出加密的文件流

            int temp = -1;
            //实现简单的加密处理：取反操作
            while ((temp = inputStream.read()) != -1){
                outputStream.write(temp ^ 0xff);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream != null){
                outputStream.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        encrpt("./src/test/java/classload/People.class","/Users/dhp/Documents/Programs/JavaTrain/src/test/temp/People.class");
    }
}
