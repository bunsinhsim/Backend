package kh.edu.istad.restful_api.dto;

public record UserAddDto (
        String userName,
        String password,
        String fullName
)
{
}
