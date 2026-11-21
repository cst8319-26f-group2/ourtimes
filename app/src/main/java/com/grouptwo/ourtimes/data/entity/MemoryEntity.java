package com.grouptwo.ourtimes.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Attachments are in MemoryAttachmentCrossRefEntity

@Entity(tableName = "memory")
public class MemoryEntity {
    // The user won't have over 2,147,483,647 memories
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;

    public String description;

    // TODO: Consider conversion/enforcement (number must be 1-5)
    public int rating;

    // Unix epoch timestamp (of the memory as it happened, not the entity creation date)
    public long timestamp;

    public String location;
}
