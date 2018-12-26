package com.hellozepp.model;

import java.util.Date;

/**
 * @Author: zhanglin
 * @Date: 2018/12/25
 * @Time: 11:45 PM
 */
public class Order {
    private String id;
    private Float total;
    private Float royalty;
    private Float price;
    private Integer numbers;
    private String employees;
    private Date update_time;
    private Date create_time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getRoyalty() {
        return royalty;
    }

    public void setRoyalty(Float royalty) {
        this.royalty = royalty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getNumbers() {
        return numbers;
    }

    public void setNumbers(Integer numbers) {
        this.numbers = numbers;
    }

    public String getEmployees() {
        return employees;
    }

    public void setEmployees(String employees) {
        this.employees = employees;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Order() {
    }

    public Order(String id, Float total, Float royalty, Float price, Integer numbers, String employees, Date update_time, Date create_time) {
        this.id = id;
        this.total = total;
        this.royalty = royalty;
        this.price = price;
        this.numbers = numbers;
        this.employees = employees;
        this.update_time = update_time;
        this.create_time = create_time;
    }
}
