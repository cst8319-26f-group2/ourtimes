package com.grouptwo.ourtimes.data.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "attachment")
public class AttachmentEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;

    // TODO: Not sure if MIME types should be cached here or not
    public String uri;
}
