package com.grouptwo.ourtimes.data.entity;

import androidx.room.Entity;
import androidx.room.Index;

// https://developer.android.com/training/data-storage/room/relationships/many-to-many
@Entity(tableName = "memory_attachments",
        primaryKeys = {"memory_id", "attachment_id"},
        indices = @Index("memory_id"))
public class MemoryAttachmentCrossRefEntity {
    public int memory_id;
    public int attachment_id;
}
