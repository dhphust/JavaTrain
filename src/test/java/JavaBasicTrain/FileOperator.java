package JavaBasicTrain;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件操作
 */
public class FileOperator {

    public static List<String> upfiles(CommonsMultipartFile[] files){
        List<String> list = new ArrayList<String>();
        // 获得项目的路径
  //      ServletContext sc = request.getSession().getServletContext();
        String basePath = "/Users/dhp/Downloads/test/img";
        // 上传位置
        String path = basePath + File.separatorChar; // 设定文件保存的目录
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();

        for (int i = 0; i < files.length; i++) {
            // 获得原始文件名
            String fileName = files[i].getOriginalFilename();
            System.out.println("原始文件名:" + fileName);
            // 新文件名
            String newFileName = UUID.randomUUID() + fileName;
            if (!files[i].isEmpty()) {
                try {
                    FileOutputStream fos = new FileOutputStream(path
                            + newFileName);
                    InputStream in = files[i].getInputStream();
                    int b = 0;
                    while ((b = in.read()) != -1) {
                        fos.write(b);
                    }
                    fos.close();
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("上传图片到:" + path + newFileName);
            list.add("img/"+newFileName);
        }
        return list;
    }

    /**
     * 下载文件
     * @param path
     */
    public static void downLoadFile(String path){

    }

    public static void main(String[] args) {

    }

}
