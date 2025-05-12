package com.example.communication.models;

import jakarta.persistence.*;

@Entity
@Table(name = "messages") // Explicitly define table name
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensure sender is not null
    private String sender;

    @Column(columnDefinition = "TEXT") // Define content column type
    private String content;

    // Default constructor (Required for JPA)
    public Message() {}

    // Parameterized constructor
    public Message(String sender, String content) {
        this.sender = sender;
        this.content = content;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}