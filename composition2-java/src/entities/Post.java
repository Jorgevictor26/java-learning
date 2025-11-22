/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author jorge-victor
 */
public class Post {

    private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;

    private ArrayList<Comment> Comments = new ArrayList();

    public Post(LocalDateTime moment, String title, String content, Integer likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public ArrayList<Comment> getComments() {
        return Comments;
    }

    public void addComment(Comment comment) {
        Comments.add(comment);
    }

    public void removeComment(Comment comment) {
        Comments.add(comment);
    }

    @Override
    public String toString() {
//        return "Post{" + "moment=" + moment + ", title=" + title + ", content=" + content + ", likes=" + likes + ", Comments=" + Comments + '}';
        StringBuilder data = new StringBuilder();

       

        data.append(title).append("\n");
        data.append(likes);
        data.append(" Likes - ");
        data.append(moment.format(fmt)).append("\n");
        data.append(content).append("\n");
        data.append("Comments: " + "\n");
        for (Comment c : Comments) {
            data.append(c.getText()).append("\n");
        }
        return data.toString();
    }

}
