package com.grouptwo.ourtimes.ui.gallery;

import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;

import com.grouptwo.ourtimes.data.entity.MemoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MemoryGalleryItem {
    public final MemoryEntity memory;

    @DrawableRes
    public final int placeholderResId;

    @Nullable
    public final String attachmentUrl;

    public MemoryGalleryItem(MemoryEntity memory, @DrawableRes int placeholderResId, @Nullable String attachmentUrl) {
        this.memory = memory;
        this.placeholderResId = placeholderResId;
        this.attachmentUrl = attachmentUrl;
    }

    public static List<MemoryGalleryItem> getSampleItems() {
        List<MemoryGalleryItem> samples = new ArrayList<>();
        long dayMs = 86_400_000L;
        long now = System.currentTimeMillis();

        samples.add(createSample(1, "Parliament Hill Sunset", "Walked along the river after class.",
                5, now - (dayMs * 14), "Ottawa, ON", android.R.drawable.ic_menu_camera));
        samples.add(createSample(2, "Rideau Canal Walk", "Grabbed hot chocolate by the locks.",
                4, now - (dayMs * 10), "Ottawa, ON", android.R.drawable.ic_menu_gallery));
        samples.add(createSample(3, "Rogers Centre Game", "Great seats near third base.",
                5, now - (dayMs * 7), "Toronto, ON", android.R.drawable.ic_menu_compass));
        samples.add(createSample(4, "Gatineau Park Hike", "Lookout trail before the snow.",
                5, now - (dayMs * 5), "Chelsea, QC", android.R.drawable.ic_menu_mapmode));
        samples.add(createSample(5, "Sprint 2 UML Session", "Finalized the ER and MVVM diagrams.",
                3, now - (dayMs * 2), "Algonquin College", android.R.drawable.ic_menu_edit));
        samples.add(createSample(6, "ByWard Market Lunch", "Tried a new spot downtown.",
                4, now - dayMs, "Ottawa, ON", android.R.drawable.ic_menu_myplaces));

        return samples;
    }

    private static MemoryGalleryItem createSample(int id, String title, String description,
                                                  int rating, long timestamp, String location,
                                                  @DrawableRes int iconResId) {
        MemoryEntity entity = new MemoryEntity();
        entity.id = id;
        entity.title = title;
        entity.description = description;
        entity.rating = rating;
        entity.timestamp = timestamp;
        entity.location = location;
        return new MemoryGalleryItem(entity, iconResId, null);
    }
}
