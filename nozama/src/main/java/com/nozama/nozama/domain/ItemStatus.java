package com.nozama.nozama.domain;

import javax.persistence.*;

@Entity
@Table
public class ItemStatus {
    private Integer statusId;
    private String status;

    @Id
    @Column
    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ItemStatus{" +
                "statusId=" + statusId +
                ", status='" + status + '\'' +
                '}';
    }
}
