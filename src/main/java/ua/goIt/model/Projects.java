package ua.goIt.model;

import ua.goIt.dao.Identity;

import java.math.BigDecimal;
import java.sql.Date;

public class Projects implements Identity {
    private Long id;
    private String name;
    private String info;
    private int status;
    private BigDecimal cost;
    private Date date_creation;

    public Projects(Long id, String name, String info, int status, BigDecimal cost, Date date_creation) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.status = status;
        this.cost = cost;
        this.date_creation = date_creation;
    }

    public Projects() {
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;

    }
    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", status=" + status +
                ", cost=" + cost +
                ", dateCreation=" + date_creation +
                '}';
    }
}

