package com.example.springschool.service.impl;

import com.example.springschool.dto.LoginResponseDto;
import com.example.springschool.entity.User;
import com.example.springschool.repo.UserRepository;
import com.example.springschool.service.UserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService extends A_Service implements UserServiceRepository {
    @Autowired
    private UserRepository repo;

    public List<User> getAll(){
        return repo.findAll();
    }



    public LoginResponseDto returnLogin(User user){
        return LoginResponseDto.builder()
                .access_token(JWTUtils.genRefreshToken(user))
                .refresh_token(JWTUtils.genRefreshToken(user))
                .expired_time(System.currentTimeMillis() + JWTUtils.expireTime).build();
    }

    @Override
    public User findById(long id) {
        return repo.findById(id);
    }

    @Override
    public boolean add(User user) {
        if (!Objects.isNull(user) && user.getId() == 0){
            repo.save(user);
            return true;
        }
        return false;
    }

    @Override
    public User getByName(String username) {
        return null;
    }

    @Override
    public boolean checkLogin(User user) {
        for (User existedUser: getAll()){
            if (user.getUsername().equals(existedUser.getUsername()) && user.getPassword().equals(existedUser.getPassword())){
                return true;
            }
        }
        return false;
    }
}
