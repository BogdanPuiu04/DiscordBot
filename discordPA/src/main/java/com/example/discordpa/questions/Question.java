package com.example.discordpa.questions;

public class Question {

    int id;
    String keyword;
    String info;


    public Question(int id,String keyword,String info){
        this.id=id;
        this.info=info;
        this.keyword=keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setCategory(String keyword) {
        this.keyword = keyword;
    }
}
