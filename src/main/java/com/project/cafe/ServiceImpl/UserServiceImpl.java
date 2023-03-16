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
import java.util.Objects;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try {
            if (validateSignUpMap(requestMap)) {
                User user = userRepository.findByEmailId(requestMap.get("email"));

                if (Objects.isNull(user)) {
                    userRepository.save(getUserFromMap(requestMap));
                    return CafeUtils.getResponseEntity("Successfully Registered.", HttpStatus.OK);
                } else {
                    return CafeUtils.getResponseEntity("Email already exists.", HttpStatus.BAD_REQUEST);
                }
            } else {
                return CafeUtils.getResponseEntity(CafeConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WENT, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private boolean validateSignUpMap(Map<String, String> requestMap){

        if (requestMap.containsKey("name") && requestMap.containsKey("contactNumber")
                && requestMap.containsKey("email") && requestMap.containsKey("contactNumber")){
            return true;
        }

        return false;
    }

    private User getUserFromMap(Map<String, String> requestMap){

       User user = new User();
       user.setName(requestMap.get("name"));
       user.setContactNumber(requestMap.get("contactNumber"));
       user.setEmail(requestMap.get("email"));
       user.setPassword(requestMap.get("password"));
       user.setStatus("false");
       user.setRole(requestMap.get("user"));

        return user;
    }




}
