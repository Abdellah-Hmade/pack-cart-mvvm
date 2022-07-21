package com.hmd377.pack_carte_mvvm.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "packModel",indices = @Index(value = {"id"},unique = true))
public class PackModel {
    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name="title")
    private String title;

    @ColumnInfo(name = "res_description")
    private String resDescription;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name="is_in_cart")
    private Boolean isInCart;

    public PackModel(int id, String title,String resDescription ,String description, Boolean isInCart) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.resDescription = resDescription;
        this.isInCart = isInCart;
    }

    @Ignore
    public PackModel( String title,String resDescription, String description, Boolean isInCart) {
        this.title = title;
        this.resDescription = resDescription;
        this.description = description;
        this.isInCart = isInCart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResDescription() {
        return resDescription;
    }

    public void setResDescription(String resDescription) {
        this.resDescription = resDescription;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getInCart() {
        return isInCart;
    }

    public void setInCart(Boolean inCart) {
        isInCart = inCart;
    }


}
