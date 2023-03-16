package com.project.cafe.Service;

import com.project.cafe.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {

    ResponseEntity<String> signUp(Map<String,String> requestMap);
}
