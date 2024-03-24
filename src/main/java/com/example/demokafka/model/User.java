package com.example.demokafka.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Iterator;
import java.util.NoSuchElementException;

@Data
@Entity
@Table(name = "\"user\"")
public class User implements Comparable<User>, Iterable<String> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String email;




    private static final int DEFAULT_ID = 0;
    private static final String DEFAULT_NAME = "Default Name";
    private static final String DEFAULT_LAST_NAME = "Default Last Name";
    private static final int DEFAULT_AGE = 18;
    private static final String DEFAULT_EMAIL = "default@example.com";




    // Copy constructor
    public User(User otherUser) {
        this.id = otherUser.id;
        this.name = otherUser.name;
        this.lastName = otherUser.lastName;
        this.age = otherUser.age;
        this.email = otherUser.email;
    }

    // Default constructor
    public User() {
    }

    // Constructor with parameters
    public User(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.name = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public int compareTo(User otherUser) {
        return Integer.compare(this.id, otherUser.getId());
    }

    public boolean isAdult() {
        return age >= 18;
    }

    public String getFullName() {
        return name + " " + lastName;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public Iterator<String> iterator() {
        return new UserIterator();
    }

    // Iterator implementation
    private class UserIterator implements Iterator<String> {
        private int currentIndex = 0;
        private final String[] fields = {String.valueOf(id), name, lastName, String.valueOf(age), email};

        @Override
        public boolean hasNext() {
            return currentIndex < fields.length;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return fields[currentIndex++];
        }
    }

    public void setData(int id, String name, String lastName, int age, String email) {
        this.id = id != 0 ? id : DEFAULT_ID;
        this.name = name != null ? name : DEFAULT_NAME;
        this.lastName = lastName != null ? lastName : DEFAULT_LAST_NAME;
        this.age = age != 0 ? age : DEFAULT_AGE;
        this.email = email != null ? email : DEFAULT_EMAIL;
    }


}
