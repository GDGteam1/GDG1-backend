package com.example.gdg_project.vision;

import com.example.gdg_project.category.CategoryEntity;
import com.example.gdg_project.category.CategoryRepository;
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

    private final CategoryRepository categoryRepo;

    @PostMapping("/image-detect")
    public @ResponseBody String detectImage(@RequestParam("file") MultipartFile file) throws IOException {
        if( !file.isEmpty() ) {

            DetectImage di =  new DetectImage();
            List<String> labels =  di.getLabels(file.getBytes()).stream().map(s->s.toLowerCase(Locale.ROOT)).collect(Collectors.toList());

            String output = "";

            if ( labels.toString().contains("water") ||  labels.toString().contains("bottle")){
                output= "페트병";
            }
            if ( labels.toString().contains("can")){
                output= "캔류";
            }
            if ( labels.toString().contains("cup")){
                output= "종이류";
            }

            try{
                System.out.println(output);
                List<CategoryEntity> categories =  categoryRepo.findByCategoryName(output);

                CategoryEntity category = categories.get(0);

                long categoryId = category.getCategoryId();

                System.out.println(categoryId);



//                List<CategoryEntity> categories =  categoryRepo.findByCategoryName(output);



//                return categories.get(0).getCategoryId().toString();
                return output;
            }catch(Error err){
                return "재활용이 불가능합니다. 일반쓰레기에 버려주십시오.";
            }

        }

        return "파일이 존재하지 않습니다.";
    }

}