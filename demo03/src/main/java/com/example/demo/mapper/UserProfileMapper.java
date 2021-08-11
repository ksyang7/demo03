package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.UserProfile;

@Mapper
public interface UserProfileMapper {
	@Select("select * from UserProfile where id =#{id}")
	UserProfile getUserProfile (@Param("id") String id);
	
	@Select("select * from UserProfile")
	List<UserProfile> getUserProfilelist();
	
	@Insert("insert into UserProfile values(#{id},#{name},#{phone},#{address})")
	int insertUserProfile(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address);
	
	@Update("update userProfile set name=#{name}, phone=#{phone}, address=#{address} where id=#{id}")
	int updateUserProfile(@RequestParam("id") String id,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address);
	
	@Delete("delete from userProfile where id=#{id}")
	int deleteUserProfile(@RequestParam("id") String id);
}
