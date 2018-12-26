package com.hellozepp.model;

import java.util.Date;

/**
 * @Author: zhanglin
 * @Date: 2018/12/26
 * @Time: 12:47 AM
 */
public class Lease {
    private Long id;
    private Long bookId;
    private Float deposit;
    private Float price;
    private String phoneNumber;
    private String employee;
    private Integer deleted;
    private Date leaseTime;

    public Lease() {
    }

    public Lease(Long id, Long bookId, Float deposit, Float price, String phoneNumber, String employee, Integer deleted, Date leaseTime) {
        this.id = id;
        this.bookId = bookId;
        this.deposit = deposit;
        this.price = price;
        this.phoneNumber = phoneNumber;
        employee = employee;
        this.deleted = deleted;
        this.leaseTime = leaseTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Float getDeposit() {
        return deposit;
    }

    public void setDeposit(Float deposit) {
        this.deposit = deposit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Date getLeaseTime() {
        return leaseTime;
    }

    public void setLeaseTime(Date leaseTime) {
        this.leaseTime = leaseTime;
    }
}
