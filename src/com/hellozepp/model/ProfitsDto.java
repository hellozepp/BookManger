package com.hellozepp.model;

/**
 * @Author: zhanglin
 * @Date: 2018/12/25
 * @Time: 11:57 PM
 */
public class ProfitsDto {
    private Float profits;//利润
    private Float amount;//营业金额

    public ProfitsDto(Float profits, Float amount) {
        this.profits = profits;
        this.amount = amount;
    }

    public ProfitsDto() {
    }

    public Float getProfits() {
        return profits;
    }

    public void setProfits(Float profits) {
        this.profits = profits;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
