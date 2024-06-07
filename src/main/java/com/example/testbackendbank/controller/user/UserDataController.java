package com.example.testbackendbank.controller.user;

import com.example.testbackendbank.dto.request.user.UserDataDto;
import com.example.testbackendbank.entity.UserData;
import com.example.testbackendbank.service.user.UserDataService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/userData")
public class UserDataController {
    private final UserDataService userDataService;

    @GetMapping()
    public ResponseEntity<UserData> getUserData(HttpServletRequest request) throws UnsupportedEncodingException {
        UserData userData = userDataService.getUserData(request);
        return ResponseEntity.ok(userData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserData> getUserDataById(@PathVariable Integer id) throws UnsupportedEncodingException {
        UserData userData = userDataService.getUserDataByUserId(id);
        return ResponseEntity.ok(userData);
    }

    @PutMapping()
    public ResponseEntity<UserData> updateUserData(HttpServletRequest request, @Valid @RequestBody UserDataDto userDataDto) throws UnsupportedEncodingException {
        userDataService.updateUserData(request, userDataDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserData> updateUserDataByEmployee(@Valid @RequestBody UserDataDto userDataDto, @PathVariable Integer id) throws UnsupportedEncodingException {
        userDataService.updateUserDataByEmployee(userDataDto,id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
