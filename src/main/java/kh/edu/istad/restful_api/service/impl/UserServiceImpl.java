package kh.edu.istad.restful_api.service.impl;

import kh.edu.istad.restful_api.dto.UserAddDto;
import kh.edu.istad.restful_api.dto.UserDto;
import kh.edu.istad.restful_api.model.User;
import kh.edu.istad.restful_api.repository.UserRepository;

import kh.edu.istad.restful_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@Service
 class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void updateById(UUID id, UserAddDto userUpdateDto) { // Update this signature in UserService too
        User existingUser = userRepository.select()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        int index = userRepository.select().indexOf(existingUser);

        // Keep the exact same order as your User record: (id, userName, password, fullName)
        User updatedUser = new User(
                existingUser.getId(),
                userUpdateDto.userName(),
                userUpdateDto.password(),
                userUpdateDto.fullName()
        );

        // Save the updated user back into the list at the found index
        userRepository.select().set(index, updatedUser);

        new UserDto(
                updatedUser.getId(),
                updatedUser.getFullName()
        );
    }
    @Override
    public void deleteById(UUID id) {
        boolean isFound = userRepository.select()
                .stream()
                .anyMatch(user -> user.getId().equals(id));

        IO.println("user with ID"+ id + "is Found : "+ isFound);

        if (isFound)
            userRepository.select().removeIf(user -> user.getId().equals(id));
        else
            throw new RuntimeException("User not Found ):");


    }
    @Override
    public UserDto getById(UUID id) {
        return userRepository.select()
                .stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(user -> new UserDto(user.getId(),user.getFullName()))
                .orElseThrow(()-> new RuntimeException("user not found"));
    }

    @Override
    public UserDto addNew(UserAddDto userAddDto) {
        User user = new User(
                UUID.randomUUID(),
                userAddDto.userName(),
                userAddDto.password(),
                userAddDto.fullName()
        );

        userRepository.select().add(user);
        return new UserDto(user.getId(), user.getFullName());
    }


    @Override
    public List<UserDto> getAll(String keyword) {
        return userRepository.select()
                .stream()
                .filter(user -> user.getFullName().toLowerCase()
                        .contains(keyword.toLowerCase())
                )
                .map(user -> new UserDto(user.getId(), user.getFullName()))
                .toList();
    }

}