package com.mahmoudh.chemafoam;

public interface FilterationEvent {
    public void onFilterEvent(String date, String shift, String month, int week, String foamType);
}
