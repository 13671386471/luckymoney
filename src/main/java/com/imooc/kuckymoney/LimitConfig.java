package com.imooc.kuckymoney;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
@Component
@ConfigurationProperties(prefix = "limit")
public class LimitConfig {
    private BigDecimal minMoney;
    private BigDecimal maxMoney;

    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }

    public void setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public BigDecimal getMinMoney() {
        return minMoney;
    }

    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    public String getDescription() {
        return description;
    }
}
