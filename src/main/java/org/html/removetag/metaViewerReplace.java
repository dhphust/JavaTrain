package org.html.removetag;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class metaViewerReplace {
    /***
     * 替换指定文件中的指定内容
     * @param filePath  文件路径
     * @param sourceStr 文件需要替换的内容
     * @param targetStr 替换后的内容
     * @return 替换成功返回true，否则返回false
     */
    public boolean replaceFileStr(String filePath, String sourceStr, String targetStr) {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bu = new BufferedReader(fileReader);
            //创建缓冲字符数组
            char[] data = new char[1024];
            int rn = 0;
            StringBuilder stringBuilder = new StringBuilder();
            while ((rn = fileReader.read(data)) > 0) {
                String str = String.valueOf(data, 0, rn);
                //    System.out.println(str);
                stringBuilder.append(str);
            }

            fileReader.close();
            // 从构建器中生成字符串，并替换搜索文本
            String str = stringBuilder.toString().replace(sourceStr, targetStr);
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(str.toCharArray());
            fileWriter.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * 获取文件路径
     * @param fileRootPath
     * @return
     * @throws IOException
     */
    public void readFilePath(String fileRootPath) throws IOException {
        List<File> fileList = new ArrayList<File>();
        File file = new File(fileRootPath);
        File[] files = file.listFiles();
        String runEbiCode = null;
        for (File f : files) {
            if (f.isFile()) {
                fileList.add(f);
            } else if (f.isDirectory()) {
                readFilePath(f.getAbsolutePath());
            }
        }
        for (File f1 : fileList) {
            //runEbiCode
            String filePath = f1.getAbsolutePath();
            String[] path = filePath.split("/");
            // TODO: 2018/7/18 路径根据实际情况取值
            if (path.length > 5) {
                runEbiCode = path[5];
                String fileName = f1.getName();
                if (fileName.equals("meta_viewer.js")) {
                    String sourceStr = "songbaoxinginnerHTML =songbaoxinginnerHTML + \"<a href=\\\"http://www.computationalbioenergy.org/web_service/parallel-meta_developing/visualization_redirect.cgi?target=\" + lable + \"\\\" target=\\\"_blank\\\">\" + lable + \"</a>\";\n";
                    String targetStr = "//songbaoxinginnerHTML =songbaoxinginnerHTML + \"<a href=\\\"http://www.computationalbioenergy.org/web_service/parallel-meta_developing/visualization_redirect.cgi?target=\" + lable + \"\\\" target=\\\"_blank\\\">\" + lable + \"</a>\";\n";
                    if (replaceFileStr(filePath, sourceStr, targetStr)) {
                        System.out.println(runEbiCode + "替换成功");
                    }
                }
            }
        }
    }
    //    System.out.println("加载run个数：" + num);
    //    return set;


    public static void main(String[] args) throws IOException {
//        metaViewerReplace metaViewerReplace = new metaViewerReplace();
//        String filePath = "/Users/dhp/Downloads/ERR1383595/Result/meta_viewer.js";
//        String sourceStr="songbaoxinginnerHTML =songbaoxinginnerHTML + \"<a href=\\\"http://www.computationalbioenergy.org/web_service/parallel-meta_developing/visualization_redirect.cgi?target=\" + lable + \"\\\" target=\\\"_blank\\\">\" + lable + \"</a>\";\n";
//        String targetStr = "//songbaoxinginnerHTML =songbaoxinginnerHTML + \"<a href=\\\"http://www.computationalbioenergy.org/web_service/parallel-meta_developing/visualization_redirect.cgi?target=\" + lable + \"\\\" target=\\\"_blank\\\">\" + lable + \"</a>\";\n";
//        if(metaViewerReplace.replaceFileStr(filePath,sourceStr,targetStr)){
//            System.out.println("替换成功");}
        metaViewerReplace metaViewerReplace = new metaViewerReplace();
        String fileRootPath = "/tmp/src/Project333344/16s_se";
        metaViewerReplace.readFilePath(fileRootPath);
    }
}
