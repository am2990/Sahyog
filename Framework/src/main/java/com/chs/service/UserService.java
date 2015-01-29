package com.chs.service;

import java.util.List;

import com.chs.entity.UserEntity;

 
public interface UserService {
    public void addUser(UserEntity user);
    public List<UserEntity> getAllUsers();
    public void deleteUser(Integer userId);
}