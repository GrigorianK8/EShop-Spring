package am.itspace.eshopspring.service;

import am.itspace.eshopspring.entity.User;

import java.util.List;

public interface UserService {

    User save(User user);

    List<User> findAll();

    User findByEmail(String email);
}
