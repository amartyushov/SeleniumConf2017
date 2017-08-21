package io.mart.dto;

import lombok.*;

import java.util.List;

@Setter @Getter
@AllArgsConstructor
@ToString
public class User {

    private Address address;
    private List<Book> books;
    private String name;
}
