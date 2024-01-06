package pt.iade.joaotomas.qrcaching.models.responses;

public class Response {
    private String message;
    private Object object;

    public Response(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }
}