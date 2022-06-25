package com.example.gdg_project.vision;

import com.example.gdg_project.user.GetUserOutputDto;
import com.example.gdg_project.user.UserEntity;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class VisionController {
//    @ApiOperation(value = "", notes = "")
    @PostMapping("/image-detect")
    public @ResponseBody String detectImage(@RequestParam("file") MultipartFile file) throws IOException {
        if( !file.isEmpty() ) {
            System.out.printf("file org name = {}", file.getOriginalFilename());
            System.out.printf("file content type = {}", file.getContentType());
//            file.transferTo(new File(file.getOriginalFilename()));
//
//            File savedFile = new File("src/main/resources/images/" + file.getOriginalFilename());

            DetectImage di =  new DetectImage();
            List<String> labels =  di.getLabels(file.getBytes());

            // 분기처리
            // PET
            if (labels.contains("Water") || labels.contains("Bottle")){
                return "PET";
            }
            if (labels.contains("can")){
                return "can";
            }
            if (labels.contains("Cup")){
                return "paper";
            }

            return "success";


        }



        return "fail";
    }

}