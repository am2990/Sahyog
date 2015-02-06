package com.chs.dao;


import java.util.List;

import com.chs.entity.UserEntity;

public interface UserDAO
{
   public void addUser(UserEntity user);
   public List<UserEntity> getAllUsers();
   public void deleteUser(Integer userId);
   public boolean isUser(String user, String pass);
}