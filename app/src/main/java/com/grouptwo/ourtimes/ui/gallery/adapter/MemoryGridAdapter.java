package com.grouptwo.ourtimes.ui.gallery.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grouptwo.ourtimes.databinding.ItemMemoryGridBinding;
import com.grouptwo.ourtimes.ui.gallery.MemoryGalleryItem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MemoryGridAdapter extends RecyclerView.Adapter<MemoryViewHolder> {
    private final List<MemoryGalleryItem> items;
    private final OnMemoryClickListener listener;
    private final SimpleDateFormat dateFormat;

    public MemoryGridAdapter(OnMemoryClickListener listener) {
        this.listener = listener;

        this.items = new ArrayList<>();
        this.dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
    }

    public void setItems(List<MemoryGalleryItem> items) {
        this.items.clear();

        if (items != null) {
            this.items.addAll(items);
        }

        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MemoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMemoryGridBinding binding = ItemMemoryGridBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MemoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoryViewHolder holder, int position) {
        holder.bind(this.items.get(position), this.listener, this.dateFormat);
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
