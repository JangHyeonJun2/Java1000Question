package 컬렉션프레임웍.PropertiesEx;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesEx3 {
    public static void main(String[] args) {
        Properties prop = new Properties();

        prop.setProperty("timeout","30");
        prop.setProperty("language","ko");
        prop.setProperty("size","10");
        prop.setProperty("capacity","10");

        try {
            prop.store(new FileOutputStream("output.txt"),"Properties Exampel");
            prop.storeToXML(new FileOutputStream("output.xml"),"Properties Example");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
