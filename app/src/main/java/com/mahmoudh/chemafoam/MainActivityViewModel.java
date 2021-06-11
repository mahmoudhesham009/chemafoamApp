package com.mahmoudh.chemafoam;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mahmoudh.chemafoam.api.APIClient;
import com.mahmoudh.chemafoam.api.APIInterface;
import com.mahmoudh.chemafoam.model.FilteredData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivityViewModel extends ViewModel {
    Retrofit retrofit;
    APIInterface apiInterface;
    MutableLiveData<FilteredData> filteredDataMutableLiveData=new MutableLiveData<>();
    public void inti(){
        retrofit=APIClient.getClient();
    }

    public void getData(String date, String shift, String month, int week, String foamType){
        apiInterface=retrofit.create(APIInterface.class);
        apiInterface.getFilteredData(date,shift,month,week,foamType).enqueue(new Callback<FilteredData>() {
            @Override
            public void onResponse(Call<FilteredData> call, Response<FilteredData> response) {
                filteredDataMutableLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<FilteredData> call, Throwable t) {
                Log.i("onFailure",t.getMessage());
            }
        });
    }

    public MutableLiveData<FilteredData> getFilteredDataMutableLiveData() {
        return filteredDataMutableLiveData;
    }
}
