package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table
public class Picture {
    private Integer pictureId;
    private Integer itemId;
    private String pictureUrl;

    @Id
    @Column
    @GeneratedValue(generator = "PICTURECOUNT", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "PICTURECOUNT", sequenceName = "PICTURECOUNT",allocationSize=1)
    public Integer getPictureId() {
        return pictureId;
    }

    public void setPictureId(Integer pictureId) {
        this.pictureId = pictureId;
    }

    @Basic
    @Column
    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column
    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId=" + pictureId +
                ", itemId=" + itemId +
                ", pictureUrl='" + pictureUrl + '\'' +
                '}';
    }
}
