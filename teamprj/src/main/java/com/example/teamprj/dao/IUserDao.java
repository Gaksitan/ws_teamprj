package com.example.teamprj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.teamprj.dto.User;

@Mapper
public interface IUserDao {
	
	public List<User> getUserList();
	
	public User getUser(int uno);
	
	public int saveUser(User user);
	
	public int deleteUser(int uno);
	
}
