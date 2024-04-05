package models;

public class ContactResponseModel {
    String message;

    @Override
    public String toString() {
        return "ContactResponseModel{" +
                "massage='" + message + '\'' +
                '}';
    }

    public ContactResponseModel(String massage) {
        this.message = massage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
