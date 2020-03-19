package academy.everyonecodes.threepwoodCinema;

public class Template {

    private String name;
    private String keyword;
    private String message;

    Template() {
    }

    public String getName() {
        return name;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getMessage() {
        return message;
    }

    void setName(String name) {
        this.name = name;
    }

    void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    void setMessage(String message) {
        this.message = message;
    }
}
