
package com.mahmoudh.chemafoam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Production {

    @SerializedName("A damage")
    @Expose
    private Double aDamage;
    @SerializedName("A total amount")
    @Expose
    private Double aTotalAmount;
    @SerializedName("B damage")
    @Expose
    private Double bDamage;
    @SerializedName("B total amount")
    @Expose
    private Double bTotalAmount;
    @SerializedName("total amount")
    @Expose
    private Double totalAmount;
    @SerializedName("total damage")
    @Expose
    private Double totalDamage;

    public Double getADamage() {
        return aDamage;
    }

    public void setADamage(Double aDamage) {
        this.aDamage = aDamage;
    }

    public Double getATotalAmount() {
        return aTotalAmount;
    }

    public void setATotalAmount(Double aTotalAmount) {
        this.aTotalAmount = aTotalAmount;
    }

    public Double getBDamage() {
        return bDamage;
    }

    public void setBDamage(Double bDamage) {
        this.bDamage = bDamage;
    }

    public Double getBTotalAmount() {
        return bTotalAmount;
    }

    public void setBTotalAmount(Double bTotalAmount) {
        this.bTotalAmount = bTotalAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getTotalDamage() {
        return totalDamage;
    }

    public void setTotalDamage(Double totalDamage) {
        this.totalDamage = totalDamage;
    }

}
