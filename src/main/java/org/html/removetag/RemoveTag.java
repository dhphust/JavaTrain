package org.html.removetag;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author dhp
 * 通过正则表达式去除html文件中的<a>标签内容
 */
public class RemoveTag
{
    public static void main(String[] args)
    {
        FileReader fr;
        String content =null;
        String regex = "<a[^>]+>.*?</a>";


//        try {
//            String filePath="/Users/dhp/Downloads/ERR1383595/Result/taxonomy.html";
//            File input = new File(filePath);
//            Document doc = Jsoup.parse(input, "UTF-8", "");
//            Elements inputElements = doc.getElementsByTag("node");
//            for (Element inputElement : inputElements) {
//                String td_value = inputElement.text();
//                System.out.println(td_value);
//
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//        }

        try
        {
            //  fr = new FileReader("/Users/dhp/Downloads/ERR1383595/Result/taxonomy.html");
            fr = new FileReader("/Users/dhp/Downloads/test.html");
            BufferedReader br = new BufferedReader(fr);
            String str = null;
            StringBuffer sb = new StringBuffer();
            while((str = br.readLine()) != null)
            {
                sb.append(str+"\n");
            }
            content = sb.toString();
            br.close();

        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb1 = new StringBuffer();
        while(matcher.find())
        {
            sb1.append(matcher.replaceAll("")+"\n");
        }
        try
        {
            FileWriter fw = new FileWriter("/Users/dhp/Downloads/test1.html");
            BufferedWriter bw = new BufferedWriter(fw);
            fw.write(sb1.toString());
            bw.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
