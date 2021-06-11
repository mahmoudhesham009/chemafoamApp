package com.mahmoudh.chemafoam;

import android.database.DataSetObserver;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;

public class FiltrationFragment extends Fragment{
    FilterationEvent filterationEvent;
    EditText dateEdit,weekEdit;
    CheckBox boxA, boxB;
    Spinner spinnerMonth, spinnerFoamType;
    String[] monthByName={"No filter","يناير","فبراير","مارس","ابريل","مايو"};
    String[] foamTypeByName={"No filter","CB1","CB2","CB3","CNF1","CNL1","Cou. L","MM1","MM2","PA1","PA3","SH1","SH2","SH3","SL1","SL2"};

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        filterationEvent= (FilterationEvent) getActivity();
        v=inflater.inflate(R.layout.fragment_filtration, container, false);
        dateEdit=v.findViewById(R.id.date_edit);
        boxA=v.findViewById(R.id.shift_a);
        boxB=v.findViewById(R.id.shift_b);
        spinnerMonth=v.findViewById(R.id.spinner);
        weekEdit=v.findViewById(R.id.week_edit);
        spinnerFoamType=v.findViewById(R.id.spinner2);

        ArrayAdapter<String> monthSpinnerAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,monthByName);
        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthSpinnerAdapter);

        ArrayAdapter<String> foamSpinnerAdapter=new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item,foamTypeByName);
        foamSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFoamType.setAdapter(foamSpinnerAdapter);

        boxA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    boxB.setChecked(false);
                }
            }
        });

        boxB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    boxA.setChecked(false);
                }
            }
        });

        v.findViewById(R.id.filter_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int week;
                String shift="";
                try {
                    week=Integer.getInteger(weekEdit.getText().toString());
                }catch (Exception e){
                    week=-1;
                }

                if(boxA.isChecked())
                    shift="A";
                else if(boxB.isChecked())
                    shift="B";

                String month=(String) spinnerMonth.getSelectedItem();
                if(month=="No filter")
                    month="";

                String foamType=(String) spinnerFoamType.getSelectedItem();
                if(foamType=="No filter")
                    foamType="";

                filterationEvent.onFilterEvent(dateEdit.getText().toString(),shift,month,week,foamType);
                getFragmentManager().beginTransaction().remove(FiltrationFragment.this).commit();
            }
        });
        return v;
    }


}