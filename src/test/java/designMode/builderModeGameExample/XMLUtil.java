package designMode.builderModeGameExample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLUtil {
    /**
     * 根据类名返回实例对象
     */
    public static List<Object> getInstances() throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, SAXException, ParserConfigurationException {
        List<String> classNames = getClassNames();
        List<Object> classNameInstance = new ArrayList<>();
        for (String className : classNames) {
            Class c = Class.forName("designMode.builderModeGameExample" + "." + className);

            classNameInstance.add(c.newInstance());
        }
        return classNameInstance;
    }

    /**
     * 从xml文件读取className属性值
     * @return
     */
    public static List<String> getClassNames() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        List<String> classNames = new ArrayList<>();
        DefaultHandler handler = new DefaultHandler(){
            boolean className = false;
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                if(qName.equalsIgnoreCase("className")){
                    className = true;
                }
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                if(className){
                    classNames.add(new String(ch, start, length));
                    className = false;
                }
            }
        };
        saxParser.parse("src/test/java/designMode/builderModeGameExample/config.xml",handler);
        return classNames;
    }


}
