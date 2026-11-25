package com.grouptwo.ourtimes.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.grouptwo.ourtimes.databinding.FragmentGalleryBinding;
import com.grouptwo.ourtimes.ui.gallery.adapter.MemoryGridAdapter;

public class GalleryFragment extends Fragment {
    private FragmentGalleryBinding binding;
    private MemoryGridAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = FragmentGalleryBinding.inflate(inflater, container, false);
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.setupRecyclerView();
        this.setupNavigationHooks();
        this.loadPlaceholderData();
    }

    private void setupRecyclerView() {
        this.binding.rvMemoriesGrid.setLayoutManager(new GridLayoutManager(this.requireContext(), 2));
        this.adapter = new MemoryGridAdapter(this::navigateToEditMemory);

        this.binding.rvMemoriesGrid.setAdapter(adapter);
    }

    private void setupNavigationHooks() {
        this.binding.fabAddMemory.setOnClickListener(click -> this.navigateToCreateMemory());
    }

    // TEMPORARY UNTIL WE HAVE ACTUAL MEMORIES STORED
    private void loadPlaceholderData() {
        this.adapter.setItems(MemoryGalleryItem.getSampleItems());
    }

    // REQUIRES TASK 2: EDITFRAGMENT
    private void navigateToCreateMemory() {
        Toast.makeText(this.requireContext(), "Open EditFragment when completed", Toast.LENGTH_LONG).show();
    }

    // REQUIRES TASK 2: EDITFRAGMENT
    private void navigateToEditMemory(MemoryGalleryItem item) {
        Toast.makeText(this.requireContext(), "Open EditFragment when completed. Memory ID: " + item.memory.id, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
