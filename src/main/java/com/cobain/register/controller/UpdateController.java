package com.cobain.register.controller;

import com.cobain.register.Dto.UpdateDto.UpdateRequestDto;
import com.cobain.register.service.UpdateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@RestController
public class UpdateController {

    private final UpdateService updateService;

    public UpdateController(UpdateService updateService) {
        this.updateService = updateService;
    }

    @PutMapping("/updatebyid")
    @ResponseBody
    public ResponseEntity<String> UpdateById(@RequestParam(name = "id") String id, @RequestBody UpdateRequestDto updateRequestDto) {
        try {
            updateService.userUpdateById(id, updateRequestDto);
            return ResponseEntity.ok("회원정보가 변경되었습니다.");
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


    @PutMapping("/updatebyname")
    @ResponseBody
    public ResponseEntity<String> UpdateByUserName(@RequestParam(name = "userName") String userName, @RequestBody UpdateRequestDto updateRequestDto) {
        try {
            updateService.userUpdateByUserName(userName, updateRequestDto);
            return ResponseEntity.ok("회원정보가 변경되었습니다.");
        } catch (NullPointerException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
