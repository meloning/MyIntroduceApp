package com.example.junsu.androidproject;

/**
 * Created by junsu on 2017-06-17.
 */

public class Member {

    //기본 필수정보
    private int picture=0;
    private String name="";
    private String birth="";
    private String gender="";
    private String ID="";
    private String PW="";
    // 추가정보
    private String university="";//대학교명
    private String hakbun="";//학번
    private String hakkha="";//학과
    private String certificate="";//자격증

    public Member(){}

    public Member(String name, String birth, String gender, String ID, String PW) {
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.ID = ID;
        this.PW = PW;
    }
    public  String getUniversity() {
        return university;
    }
    public void   setUniversity(String university) {
        this.university = university;
    }
    public String getHakbun() {
        return hakbun;
    }
    public void   setHakbun(String hakbun) {
        this.hakbun = hakbun;
    }
    public String getHakkha() {
        return hakkha;
    }
    public void   setHakkha(String hakkha) {
        this.hakkha = hakkha;
    }
    public String getCertificate() {
        return certificate;
    }
    public void   setCertificate(String certificate) {
        this.certificate = certificate;
    }
    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }

    public String getName() {

        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getGender() {
        return gender;
    }

    public String getID() {
        return ID;
    }

    public String getPW() {
        return PW;
    }
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        if(this.name!=null) sb.append("이름: "+this.name+"\n");
        if(this.birth!=null) sb.append("생일: "+this.birth+"\n");
        if(this.university!=null) sb.append("대학교: "+this.university+"\n");
        if(this.hakkha!=null) sb.append("학과: "+this.hakkha+"\n");
        if(this.hakbun!=null) sb.append("학번: "+this.hakbun+"\n");
        if(this.certificate!=null) sb.append("취득자격증: "+this.certificate+"\n");
        return sb.toString();
    }
}
