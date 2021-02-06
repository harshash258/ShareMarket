package com.mycompany.sharemarket.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mycompany.sharemarket.Models.Share;
import com.mycompany.sharemarket.R;

import java.util.ArrayList;
import java.util.List;

public class SharesAdapter extends RecyclerView.Adapter<SharesAdapter.ViewHolder> implements Filterable {
    List<Share> shares;
    List<Share> searchList;

    Filter searchFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Share> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(searchList);
            } else {
                String filterText = constraint.toString().toLowerCase().trim();

                for (Share user : searchList) {
                    if (user.getShareName().toLowerCase().contains(filterText)) {
                        filteredList.add(user);

                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            shares.clear();
            shares.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public SharesAdapter(List<Share> shares) {
        this.shares = shares;
        searchList = new ArrayList<>(shares);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.share_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Share share = shares.get(position);
        holder.shareName.setText(share.getShareName());
        holder.company.setText(share.getCompany());
        holder.openPrice.setText(share.getOpenPrice());
        holder.closePrice.setText(share.getClosePrice());
        holder._52WeeksLow.setText(share.get_52WeeksLow());
        holder._52WeeksHigh.setText(share.get_52WeeksHigh());
        holder.currentPrice.setText(share.getCurrentPrice());
        holder.volume.setText(share.getVolume());

    }

    @Override
    public int getItemCount() {
        return shares.size();
    }

    @Override
    public Filter getFilter() {
        return searchFilter;
    }

    static public class ViewHolder extends RecyclerView.ViewHolder {
        TextView openPrice, closePrice, _52WeeksLow, _52WeeksHigh, currentPrice, volume, shareName,
                company;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            openPrice = itemView.findViewById(R.id.openPrice);
            closePrice = itemView.findViewById(R.id.closePrice);
            _52WeeksLow = itemView.findViewById(R.id._52wLow);
            _52WeeksHigh = itemView.findViewById(R.id._52wHigh);
            currentPrice = itemView.findViewById(R.id.currentPrice);
            volume = itemView.findViewById(R.id.volume);
            shareName = itemView.findViewById(R.id.name);
            company = itemView.findViewById(R.id.company);
        }
    }
}
