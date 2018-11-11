package cn.matrix.entity;
/*
 * 包名：untitled
 * 文件名： Area
 * 创建者：wushiqian
 * 创建时间 2018/11/11 1:19 PM
 * 描述： TODO//
 */

public class Area {

    private int id;
    private String name;

    public Area() {
    }

    public Area(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
