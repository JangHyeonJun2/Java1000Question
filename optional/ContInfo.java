package optional;

public class ContInfo {
    private String phone;// null일 수 있다.
    private String adrs; // null일 수 있다.

    public ContInfo(String phone, String adrs) {
        this.phone = phone;
        this.adrs = adrs;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdrs() {
        return adrs;
    }
}
