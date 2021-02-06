package com.mycompany.sharemarket.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mycompany.sharemarket.Adapter.SharesAdapter;
import com.mycompany.sharemarket.Models.Share;
import com.mycompany.sharemarket.R;

import java.util.ArrayList;
import java.util.List;

public class ViewShares extends AppCompatActivity {

    List<Share> shares;
    RecyclerView recyclerView;
    SharesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_shares);

        initVariable();
    }

    private void initVariable() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        shares = new ArrayList<>();
        adapter = new SharesAdapter(shares);
    }
}