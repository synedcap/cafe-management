package com.project.cafe.Controller;

import com.project.cafe.Constant.CafeConstants;
import com.project.cafe.ControllerRest.UserRest;
import com.project.cafe.Model.User;
import com.project.cafe.Service.UserService;
import com.project.cafe.Utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        try{
            return userService.signUp(requestMap);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstants.SOMETHING_WENT_WENT,HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
