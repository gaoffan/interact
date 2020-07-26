package org.sacc.interact.entity;

public class Group {
    private int id;
    private String name;
    private String desc;
    private String logo;

    public String getLogo() {
        return logo;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLogo(String logopath) {
        this.logo = logopath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
