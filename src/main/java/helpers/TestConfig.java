package helpers;

import com.google.gson.Gson;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public class TestConfig {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    // Создание статической константы JSON, которая представляет собой объект MediaType.
    // В данном случае устанавливается тип контента application/json с кодировкой utf-8.
    // Это используется для определения типа содержимого запроса, который будет отправлен на сервер.
    public static final Gson gson = new Gson();
    public static final OkHttpClient client = new OkHttpClient();
    // Создание статической константы client,
    // которая представляет собой объект OkHttpClient. Этот объект OkHttpClient
    // используется для выполнения HTTP-запросов.

}
