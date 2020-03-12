package designMode.factory.factoryMethod;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, IllegalAccessException, InstantiationException, ClassNotFoundException {

        //生产productA
//        Factory factory;
//        Product product;
//        factory = new ProductAFactory();
//        product = factory.getProduct();
//        product.diffMtehod();

        //根据xml文件动态加载产品工厂
        Factory factory;
        Product product;
        List<Object> factoryInstances = XMLUtil.getInstances();
        for (Object factoryInstance : factoryInstances) {
            factory = (Factory) factoryInstance;
            product = factory.getProduct();
            product.diffMtehod();
        }
    }
}
