package com.bjpowernode.vo;

public class StudentClassRoom {

    private Integer sid;
    private String sName;
    private String sEmail;
    private Integer sAge;
    private Integer cId;
    private String cName;
    private Integer cStudentNum;

    public StudentClassRoom() {
    }

    public StudentClassRoom(Integer sid, String sName, String sEmail, Integer sAge, Integer cId, String cName, Integer cStudentNum) {
        this.sid = sid;
        this.sName = sName;
        this.sEmail = sEmail;
        this.sAge = sAge;
        this.cId = cId;
        this.cName = cName;
        this.cStudentNum = cStudentNum;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcStudentNum() {
        return cStudentNum;
    }

    public void setcStudentNum(Integer cStudentNum) {
        this.cStudentNum = cStudentNum;
    }

    @Override
    public String toString() {
        return "StudentClassRoom{}";
    }
}
