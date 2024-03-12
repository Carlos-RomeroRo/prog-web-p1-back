package desarrolloweb.jpa.models.api;

import java.util.HashMap;

import lombok.Getter;

public class ResJsonEntity {
    @Getter private HashMap<String, Object> content;

    public ResJsonEntity() {
        this.content = new HashMap<>();
    }

    public void AddDataToRes(String content, Object data) {
        this.content.put(content, data);
    }
}
