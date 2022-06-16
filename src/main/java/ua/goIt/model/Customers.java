package ua.goIt.model;

import ua.goIt.dao.Identity;

import java.sql.Date;

public class Customers implements Identity {
    private long id;
    private String name;
    private String state_code;
    private String country;
    private Date birthday;
    private String sex;
    private String info;

    public Customers(long id, String name, Long state_code, String country, Date birthday, String sex, String info) {
        this.id = id;
        this.name = name;
        this.state_code = String.valueOf(state_code);
        this.country = country;
        this.birthday = birthday;
        this.sex = sex;
        this.info = info;
    }

    public Customers() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState_code() {
        return state_code;
    }

    public void setState_code(String state_code) {
        this.state_code = state_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state_code='" + state_code + '\'' +
                ", country='" + country + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", info='" + info + '\'' +
                '}';
    }


}



