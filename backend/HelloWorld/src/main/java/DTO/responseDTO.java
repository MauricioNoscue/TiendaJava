package DTO;

public class responseDTO {
    private String message;

    public responseDTO() {
    }

    public responseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
