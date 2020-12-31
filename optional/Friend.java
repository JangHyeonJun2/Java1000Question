package optional;

import jdk.jfr.Frequency;

import java.util.Optional;

public class Friend {
    private String name;
    private Company cmp; //null일 수 있다.

    public Friend(String name, Company cmp) {
        this.name = name;
        this.cmp = cmp;
    }

    public String getName() {
        return name;
    }

    public Company getCmp() {
        return cmp;
    }

    static void showCompAddr(Optional<Friend> f) {
        String s = f.map(friend -> friend.getCmp()).map(company -> company.getcInfo()).map(contInfo -> contInfo.getAdrs()).orElse("Threre`s no...");
        System.out.println(s);
    }
    public static void main(String[] args) {
        ContInfo ci = new ContInfo("010-1111-2222","Gumi");
        Company co = new Company("Coupang",ci);
        Friend fe = new Friend("jang",co);

        showCompAddr(Optional.of(fe));
    }
}
