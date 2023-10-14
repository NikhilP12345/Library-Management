package com.practice.library_management.models.dto.book;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreateBookDto {
    private String name;
    private String title;
    private String authorName;
    private String userName;
}
