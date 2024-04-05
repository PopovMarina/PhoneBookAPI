package helpers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
// класс используется для записи свойств в XML-файл.

public class PropertiesWriterXML {
// конструктор принимает путь к файлу filePath,
// который будет использоваться для записи свойств.
    public PropertiesWriterXML(String filePath) {
        this.filePath = filePath;
    }
    private static String filePath;
    Properties properties = new Properties();

//    public PropertiesWriterXML(Properties properties) {
//        this.properties = properties;
//    }
//
//    public PropertiesWriterXML() {}

    /**
     * Метод setProperties используется для
     * установки свойства с заданным ключом и значением. Аргумент clearFile определяет,
     * нужно ли очищать файл перед записью новых свойств.
     * Если clearFile установлен в false, метод сначала пытается загрузить свойства из файла,
     * используя FileInputStream, чтобы сохранить существующие свойства.
     * Затем метод устанавливает новое свойство с помощью setProperty(key, value).
     * После этого он записывает обновленные свойства в XML-файл, используя FileOutputStream и метод storeToXML().
     * @param key
     * @param value
     * @param clearFile - Аргумент определяет, нужно ли очищать файл перед записью новых свойств.
     */

    public void setProperties(String key, String value, boolean clearFile){
        if(!clearFile){
            try( FileInputStream inputStream = new FileInputStream(filePath)){
                properties.loadFromXML(inputStream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        properties.setProperty(key, value);
        try(FileOutputStream outputStream = new FileOutputStream(filePath)){
            properties.storeToXML(outputStream, null);
        }
        catch (IOException e){e.printStackTrace();}
    }
}