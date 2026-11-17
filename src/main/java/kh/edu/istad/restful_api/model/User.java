package kh.edu.istad.restful_api.model;

import java.util.UUID;

public record User(
        UUID id,
        String userName,
        String password,
        String fullName
)
{

}