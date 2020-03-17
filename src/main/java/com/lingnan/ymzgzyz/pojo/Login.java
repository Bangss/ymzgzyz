package com.lingnan.ymzgzyz.pojo;

public class Login {
    private Integer id;
    private Integer role;
    private String login_time;

    public Integer getId ( ) {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Integer getRole ( ) {
        return role;
    }

    public void setRole ( Integer role ) {
        this.role = role;
    }

    public String getLogin_time ( ) {
        return login_time;
    }

    public void setLogin_time ( String login_time ) {
        this.login_time = login_time;
    }

    public Login ( ) {
    }

    public Login ( Integer id, Integer role, String login_time ) {
        this.id = id;
        this.role = role;
        this.login_time = login_time;
    }

    @Override
    public String toString ( ) {
        return "Login{" +
                "id=" + id +
                ", role=" + role +
                ", login_time='" + login_time + '\'' +
                '}';
    }
}
