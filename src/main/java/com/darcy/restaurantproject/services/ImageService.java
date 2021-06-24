package com.darcy.restaurantproject.services;

import com.darcy.restaurantproject.dtos.EventGetDTO;
import com.darcy.restaurantproject.entities.Event;
import com.darcy.restaurantproject.mappers.EventMapper;
import com.darcy.restaurantproject.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
//
///**
// * Darcy Xian  23/5/21  11:18 pm      restaurantProject
// */
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class ImageService {
//    private final EventRepository eventRepository;
//    private final EventMapper eventMapper;
//
//    public EventGetDTO saveImageFile(Long eventId, MultipartFile imageFile){
//        log.debug("Received a file.");
//        try{
//            Event event = eventRepository.findById(eventId).get();
//            // 按照接受的文件长度， 建立Byte[]
//            Byte[] bytesObjects = new Byte[imageFile.getBytes().length];
//            int i =0;
//            // 用 byte  把file文件的值全部复制出来
//            for(byte b: imageFile.getBytes()){
//                bytesObjects[i++] = b;
//            }
//            event.setImage(bytesObjects);
//           return eventMapper.fromEntity(eventRepository.save(event));
//        }catch(IOException e){
//            // to do handle better
//            log.error("Image getBytes error",e);
//            e.printStackTrace();
//            return null;
//        }
//    }
//}
