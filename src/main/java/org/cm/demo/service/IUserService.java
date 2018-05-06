package org.cm.demo.service;

import org.cm.demo.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
