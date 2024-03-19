package desarrolloweb.jpa.models.api;

import java.util.HashMap;

import lombok.Getter;

public class ResJsonEntity {
    @Getter private HashMap<String, Object> content;
    private static final String MESSAGE_KEY = "message";

    public ResJsonEntity() {
        this.content = new HashMap<>();
    }

    /**
     * Add data to the response
     * @param content the key of the data on the json
     * @param data the data
     */
    public void AddDataToRes(String content, Object data) {
        this.content.put(content, data);
    }

    /**
     * Add a message to the response
     * @param message the message
     */
    public void AddMessageToRes(String message) {
        this.content.put(MESSAGE_KEY, message);
    }
}
