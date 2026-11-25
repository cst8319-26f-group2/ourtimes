package com.grouptwo.ourtimes.ui.gallery.adapter;

import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.grouptwo.ourtimes.databinding.ItemMemoryGridBinding;
import com.grouptwo.ourtimes.ui.gallery.MemoryGalleryItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MemoryViewHolder extends RecyclerView.ViewHolder {
    private final ItemMemoryGridBinding binding;

    public MemoryViewHolder(@NonNull ItemMemoryGridBinding binding) {
        super(binding.getRoot());

        this.binding = binding;
    }

    public void bind(final MemoryGalleryItem item, final OnMemoryClickListener listener, SimpleDateFormat dateFormat) {
        if (item.attachmentUrl != null && !item.attachmentUrl.isEmpty()) {
            binding.ivMemoryThumbnail.setImageURI(Uri.parse(item.attachmentUrl));
        } else {
            binding.ivMemoryThumbnail.setImageResource(item.placeholderResId);
        }

        binding.tvMemoryTitle.setText(item.memory.title);

        String formattedDate = dateFormat.format(new Date(item.memory.timestamp));

        if (item.memory.location != null && !item.memory.location.isEmpty()) {
            binding.tvMemoryMeta.setText(String.format(Locale.getDefault(), "%s - %s", formattedDate, item.memory.location));
        } else {
            binding.tvMemoryMeta.setText(formattedDate);
        }

        binding.tvMemoryRating.setText(String.format(Locale.getDefault(), "Rating: %d★", item.memory.rating));

        binding.getRoot().setOnClickListener(v -> {
            if (listener != null) {
                listener.onMemoryClick(item);
            }
        });
    }
}
