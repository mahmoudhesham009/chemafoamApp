package com.mahmoudh.chemafoam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import com.google.android.material.appbar.MaterialToolbar;

import com.mahmoudh.chemafoam.model.FilteredData;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class MainActivity extends AppCompatActivity implements MaterialToolbar.OnMenuItemClickListener,FilterationEvent {
    FilteredData filteredData=null;
    MaterialToolbar mToolbar;
    MainActivityViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.tool_bar);
        CircularProgressBar circularProgressBar1 = findViewById(R.id.yourCircularProgressbar1);
        TextView circular1=findViewById(R.id.a_loss);
        CircularProgressBar circularProgressBar2 = findViewById(R.id.yourCircularProgressbar2);
        TextView circular2=findViewById(R.id.b_loss);

        CircularProgressBar circularProgressBar1w = findViewById(R.id.yourCircularProgressbar1w);
        TextView circular1w=findViewById(R.id.a_work_eff);
        CircularProgressBar circularProgressBar2w = findViewById(R.id.yourCircularProgressbar2w);
        TextView circular2w=findViewById(R.id.b_work_eff);

        mToolbar.setOnMenuItemClickListener(this);
        viewModel=new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.inti();
        viewModel.getFilteredDataMutableLiveData().observe(this, new Observer<FilteredData>() {
            @Override
            public void onChanged(FilteredData filteredData) {
                if(filteredData.getProduction().getATotalAmount().floatValue()!=0){
                    circularProgressBar1.setProgressWithAnimation(100*filteredData.getProduction().getADamage().floatValue()/filteredData.getProduction().getATotalAmount().floatValue());
                    circular1.setText(100*filteredData.getProduction().getADamage().floatValue()/filteredData.getProduction().getATotalAmount().floatValue()+"");
                }

                if(filteredData.getProduction().getBTotalAmount().floatValue()!=0){
                    circularProgressBar2.setProgressWithAnimation(100*filteredData.getProduction().getBDamage().floatValue()/filteredData.getProduction().getBTotalAmount().floatValue());
                    circular2.setText(100*filteredData.getProduction().getBDamage().floatValue()/filteredData.getProduction().getBTotalAmount().floatValue()+"");
                }


                if(filteredData.getWorkHours().getAActual().floatValue()!=0){
                    circularProgressBar1w.setProgress(100*filteredData.getWorkHours().getAPlan().floatValue()/filteredData.getWorkHours().getAActual().floatValue());
                    circular1w.setText(100*filteredData.getWorkHours().getAPlan().floatValue()/filteredData.getWorkHours().getAActual().floatValue()+"");
                }

                if(filteredData.getWorkHours().getBActual().floatValue()!=0){
                    circularProgressBar2w.setProgress(100*filteredData.getWorkHours().getBPlan().floatValue()/filteredData.getWorkHours().getBActual().floatValue());
                    circular2w.setText(100*filteredData.getWorkHours().getBPlan().floatValue()/filteredData.getWorkHours().getBActual().floatValue()+"");
                }
            }
        });

        viewModel.getData("","","",-1,"");
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId()==R.id.filter){
            Fragment frag2 = new FiltrationFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.frame, frag2);
            ft.commit();
        }
        return false;
    }

    @Override
    public void onFilterEvent(String date, String shift, String month, int week, String foamType) {
        viewModel.getData(date,shift,month,week,foamType);
    }
}