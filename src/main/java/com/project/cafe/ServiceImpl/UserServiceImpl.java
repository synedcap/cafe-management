package com.project.cafe.ServiceImpl;

import com.project.cafe.Constant.CafeConstants;
import com.project.cafe.Model.User;
import com.project.cafe.Repository.UserRepository;
import com.project.cafe.Service.UserService;
import com.project.cafe.Utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        if (validateSignUpMap(requestMap)){
            User user = userRepository.findByEmailId(requestMap.get("email"));
        }else{
            return  CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
        }
        return null;
    }


    private boolean validateSignUpMap(Map<String, String> requestMap){

        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("contactNumber")){
            return true;
        }

        return false;
    }




}
