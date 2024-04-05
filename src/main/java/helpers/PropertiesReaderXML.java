package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderXML {
    private static final String PROPERTIES_PATH = "src/main/resources/data.xml";
    //Путь до файла xml

    /**
     * Метод getProperty(String key) принимает ключ в качестве аргумента и возвращает соответствующее значение из XML-файла.
     * @param key - key
     * @return - value
     * Внутри метода создается объект Properties, который используется для хранения пар ключ-значение.
     * Далее открывается поток чтения из файла с помощью FileInputStream. Этот поток используется для чтения данных из файла.
     * Метод loadFromXML() загружает свойства из файла, переданного через FileInputStream, предполагая, что файл имеет формат XML.
     * Затем метод getProperty(key) вызывается для получения значения, связанного с переданным ключом.
     */

    public static String getProperty(String key){
        Properties properties = new Properties();
        try(FileInputStream fis = new FileInputStream(PROPERTIES_PATH)){
            properties.loadFromXML(fis);
            return properties.getProperty(key);
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }


    }
}
