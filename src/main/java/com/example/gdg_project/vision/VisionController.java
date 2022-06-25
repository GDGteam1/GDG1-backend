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
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class VisionController {
//    @ApiOperation(value = "", notes = "")
    @PostMapping("/image-detect")
    public @ResponseBody String detectImage(@RequestParam("file") MultipartFile file) throws IOException {
        if( !file.isEmpty() ) {

            DetectImage di =  new DetectImage();
            List<String> labels =  di.getLabels(file.getBytes()).stream().map(s->s.toLowerCase(Locale.ROOT)).collect(Collectors.toList());

            if ( labels.toString().contains("water") ||  labels.toString().contains("bottle")){
                return "PET";
            }
            if ( labels.toString().contains("can")){
                return "can";
            }
            if ( labels.toString().contains("cup")){
                return "paper";
            }

            return "재활용이 불가능합니다. 일반쓰레기에 버려주십시오.";
        }

        return "no such file on server";
    }

}