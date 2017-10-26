package com.yihaomen.model;

/**
 * Created by ZhangGuozhao on 2017/10/23.
 */
public class Blog {
    private String id;
    //    /    博客名字
    private String owner;
    //    博客题目
    private String title;
    //    博客文章内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "content='" + content + '\'' +
                ", id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
