package optional;

public class Company {
    private String cName;
    private ContInfo cInfo; // null일 수 있다.

    public Company(String cName, ContInfo cInfo) {
        this.cName = cName;
        this.cInfo = cInfo;
    }

    public String getcName() {
        return cName;
    }

    public ContInfo getcInfo() {
        return cInfo;
    }
}
