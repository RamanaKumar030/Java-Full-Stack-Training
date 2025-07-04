package com.aits.mobileprepaid.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RechargeHistory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore    
    private User user;

    @ManyToOne
    private RechargePlan plan;

    private String paymentMethod;
    private LocalDateTime rechargeDate;

    // 👉 Manual GETTERS
    public LocalDateTime getRechargeDate() {
        return rechargeDate;
    }

    public RechargePlan getPlan() {
        return plan;
    }

    public User getUser() {
        return user;
    }

    // 👉 Manual SETTERS
    public void setRechargeDate(LocalDateTime rechargeDate) {
        this.rechargeDate = rechargeDate;
    }

    public void setPlan(RechargePlan plan) {
        this.plan = plan;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
