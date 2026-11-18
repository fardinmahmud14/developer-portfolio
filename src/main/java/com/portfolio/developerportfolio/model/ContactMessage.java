package com.portfolio.developerportfolio.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactMessage {

    @NotBlank(message = "Please enter your name.")
    @Size(max = 80, message = "Name must be 80 characters or fewer.")
    private String name;

    @NotBlank(message = "Please enter your email address.")
    @Email(message = "Please enter a valid email address.")
    @Size(max = 120, message = "Email must be 120 characters or fewer.")
    private String email;

    @NotBlank(message = "Please enter a subject.")
    @Size(max = 120, message = "Subject must be 120 characters or fewer.")
    private String subject;

    @NotBlank(message = "Please write a message.")
    @Size(min = 10, max = 2000, message = "Message must be between 10 and 2,000 characters.")
    private String message;

    public ContactMessage() {
    }

    public ContactMessage(ContactMessage source) {
        this.name = source.name;
        this.email = source.email;
        this.subject = source.subject;
        this.message = source.message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
