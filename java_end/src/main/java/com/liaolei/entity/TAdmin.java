package com.liaolei.entity;

public class TAdmin {
    private Integer Id;
    private String account;
    private String password;

    public TAdmin(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public TAdmin() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
