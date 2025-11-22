/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application;

import entities.Comment;
import entities.Post;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author jorge-victor
 */
public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LocalDateTime moment = LocalDateTime.now();

        System.out.print("Title: ");
        String title = scan.nextLine();

        System.out.print("Content: ");
        String content = scan.nextLine();

        System.out.print("Likes: ");
        int likes = scan.nextInt();

        Post post = new Post(moment, title, content, likes);

        System.out.println("How many comments");
        int n = scan.nextInt();

        scan.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Text: ");
            String text = scan.nextLine();
            post.addComment(new Comment(text));
        }
        System.out.println(" ");
        System.out.println(post);

    }
}
