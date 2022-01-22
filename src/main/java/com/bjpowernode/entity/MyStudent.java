package com.bjpowernode.entity;

public class MyStudent {
    private Integer studentId;
    private String studentName;
    private String email;
    private Integer age;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyStudent{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
