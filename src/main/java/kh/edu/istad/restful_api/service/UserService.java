package kh.edu.istad.restful_api.service;

import kh.edu.istad.restful_api.dto.UserAddDto;
import kh.edu.istad.restful_api.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void updateById(UUID id, UserAddDto userUpdateDto);
    void deleteById(UUID id);

    UserDto getById(UUID id);


    UserDto addNew(UserAddDto userAddDto);
    List<UserDto> getAll(String keyword);

}