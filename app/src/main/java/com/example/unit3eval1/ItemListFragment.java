package com.example.unit3eval1;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ItemListFragment extends Fragment {
    private RecyclerView recycler;
    private ClickListener listener;
    private List<ResponseModel> modelList=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        listener= (ClickListener) context;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler=view.findViewById(R.id.recycle);
        recycler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model model=new Model();
                Bundle bundle=new Bundle();
                bundle.putInt("image", model.getImage());
                bundle.putString("title",model.getTitle());
                bundle.putString("subtitle",model.getSubtitle());
                if(listener!=null){
                    listener.launchdetailfrag(bundle);
                }

            }
        });
    }
    private void callAPI(){
        ApiService apiService=Network.getInstance().create(ApiService.class);
        apiService.getposts("/shivarajp/2cbe00030c04472c9d8ad4b0ec112dbe/raw/c651391e428182f08d60d59e79073f3fcf79b858/nobroker").enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                if(response.body()!=null){
                    modelList=response.body();
                    setrecyclerview();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        } );

    }

    private void setrecyclerview() {
        Adapter adapter=new Adapter(modelList);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(adapter);
    }

}