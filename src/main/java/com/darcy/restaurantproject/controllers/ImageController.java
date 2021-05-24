package com.darcy.restaurantproject.controllers;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.repositories.EventRepository;
import com.darcy.restaurantproject.services.EventService;
import com.darcy.restaurantproject.services.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Darcy Xian  23/5/21  11:27 pm      restaurantProject
 */
@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@Slf4j
public class ImageController {
   private final EventService eventService;
   private final ImageService imageService;
    @GetMapping("/{id}")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException{
        // HttpServletResponse 是web服务器向客户端发送数据
        EventGetDTO eventGetDTO = eventService.findByID(Long.valueOf(id));
        byte[] byteArray = new byte[eventGetDTO.getImage().length];

        int i = 0;
        for(Byte wrappedByte : eventGetDTO.getImage()){
            byteArray[i++] = wrappedByte;// auto unboxing
        }
        response.setContentType("image/jpeg");
        InputStream is = new ByteArrayInputStream(byteArray);
        // IOUtils is going to copy from the bytearray input stream to the response outputStream
        log.debug(" I am in image controller render");
        IOUtils.copy(is,response.getOutputStream());
    }
    @PostMapping("/{id}/post")
    public ResponseEntity<EventGetDTO> updateImage(@PathVariable Long id,
                                                  @RequestParam("imageFile") MultipartFile file){

        return ResponseEntity.ok(imageService.saveImageFile(id,file));
    }



}
