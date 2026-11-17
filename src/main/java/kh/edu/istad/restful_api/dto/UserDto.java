package kh.edu.istad.restful_api.dto;

import java.util.UUID;

public record UserDto (
        UUID Id,
        String fullName
){
}
