package com.example.lianxi.Bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DatasBean {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private boolean che;
    @Generated(hash = 498265934)
    public DatasBean(Long id, String title, boolean che) {
        this.id = id;
        this.title = title;
        this.che = che;
    }
    @Generated(hash = 128729784)
    public DatasBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public boolean getChe() {
        return this.che;
    }
    public void setChe(boolean che) {
        this.che = che;
    }

}
