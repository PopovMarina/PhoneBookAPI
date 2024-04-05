package helpers;

public class ReadXMLTest {
    public static void main(String[] args) {
        String key = "user001";
        String PROPERTIES_PATH = "src/main/resources/data.xml";
        PropertiesWriterXML propertiesWriterXML = new PropertiesWriterXML(PROPERTIES_PATH);
        propertiesWriterXML.setProperties(key, "John", true);

        String res = PropertiesReaderXML.getProperty(key);
        System.out.println("RESULT:" +res);

    }
}
