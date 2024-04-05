package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdExtractor {

    public static void main(String[] args) {

        System.out.println("Res: " + extractId("Contact was added! ID: ac452eef-546c-40da-8bab-47520374e461"));
   /*     //Метод для поиска ID в строке
    //@param input - текст в котором нужно найти id
    //@return - id
    }

 */
    }
    public static String extractId(String input) {

    // в методе создается объект Pattern, который представляет регулярное выражение "ID: (\\S+)".
    // Это регулярное выражение ищет текст, который начинается с подстроки "ID:
        Pattern pattern = Pattern.compile("ID: (\\S+)");
    //часть выражения \\S+ соответствует одному или более символу, который не является пробелом.
        Matcher matcher = pattern.matcher(input);
    // объект Matcher используется для поиска соответствий регулярному выражению в строке input.
        if(matcher.find()) {
    // Метод find() вызывается для поиска первого соответствия в строке input. Если соответствие найдено, то метод group(1)
    // возвращает найденное значение, которое соответствует первой группе в регулярном выражении
            return matcher.group(1);
        }
        else {
            return null;
        }
    }
}
