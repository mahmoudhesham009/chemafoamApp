
package com.mahmoudh.chemafoam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilteredData {

    @SerializedName("production")
    @Expose
    private Production production;
    @SerializedName("workHours")
    @Expose
    private WorkHours workHours;

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public WorkHours getWorkHours() {
        return workHours;
    }

    public void setWorkHours(WorkHours workHours) {
        this.workHours = workHours;
    }

}
