package com.icore.icoretest.dao;

import com.icore.icoretest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}