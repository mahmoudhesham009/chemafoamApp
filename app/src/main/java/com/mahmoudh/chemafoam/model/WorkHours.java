
package com.mahmoudh.chemafoam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkHours {

    @SerializedName("A actual")
    @Expose
    private Double aActual;
    @SerializedName("A plan")
    @Expose
    private Double aPlan;
    @SerializedName("B actual")
    @Expose
    private Double bActual;
    @SerializedName("B plan")
    @Expose
    private Double bPlan;
    @SerializedName("total actual")
    @Expose
    private Double totalActual;
    @SerializedName("total plan")
    @Expose
    private Double totalPlan;

    public Double getAActual() {
        return aActual;
    }

    public void setAActual(Double aActual) {
        this.aActual = aActual;
    }

    public Double getAPlan() {
        return aPlan;
    }

    public void setAPlan(Double aPlan) {
        this.aPlan = aPlan;
    }

    public Double getBActual() {
        return bActual;
    }

    public void setBActual(Double bActual) {
        this.bActual = bActual;
    }

    public Double getBPlan() {
        return bPlan;
    }

    public void setBPlan(Double bPlan) {
        this.bPlan = bPlan;
    }

    public Double getTotalActual() {
        return totalActual;
    }

    public void setTotalActual(Double totalActual) {
        this.totalActual = totalActual;
    }

    public Double getTotalPlan() {
        return totalPlan;
    }

    public void setTotalPlan(Double totalPlan) {
        this.totalPlan = totalPlan;
    }

}
