package com.bjpowernode.entity;

public class ClassRoom {

    private Integer id;
    private String className;
    private Integer studentNum;

    public ClassRoom() {
    }

    public ClassRoom(Integer id, String className, Integer studentNum) {
        this.id = id;
        this.className = className;
        this.studentNum = studentNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "id=" + id +
                ", className='" + className + '\'' +
                ", studentNum=" + studentNum +
                '}';
    }
}
