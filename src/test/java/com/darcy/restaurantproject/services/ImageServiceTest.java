//package com.darcy.restaurantproject.services;
//
//import com.darcy.restaurantproject.dtos.EventGetDTO;
//import com.darcy.restaurantproject.entities.Event;
//import com.darcy.restaurantproject.mappers.EventMapper;
//import com.darcy.restaurantproject.repositories.EventRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.*;
//
///**
// * Darcy Xian  24/5/21  3:01 pm      restaurantProject
// */
//@ExtendWith(MockitoExtension.class)
//public class ImageServiceTest {
//    @Mock
//    private EventRepository eventRepository;
//    @Mock
//    private EventMapper eventMapper;
//
//    @InjectMocks
//    ImageService imageService;
//
//    @Test
//    public void saveImageFile () throws Exception{
//        Long id = 1L;
//        MultipartFile multipartFile = new MockMultipartFile("imageFile","testing.txt","text/plain",
//                "Spring Framework Darcy".getBytes());
//        Event event = new Event();
//        event.setId(id);
//        when(eventRepository.findById(anyLong())).thenReturn(Optional.of(event));
//
//        // ArgrmentCaptor 用来捕捉方法传入的参数
//        ArgumentCaptor<Event> argumentCaptor = ArgumentCaptor.forClass(Event.class);
//
//        // when
//        imageService.saveImageFile(id,multipartFile);
//
//        // then
//       verify(eventRepository,times(1)).save(argumentCaptor.capture());
//       Event savedEvent = argumentCaptor.getValue();
//       assertEquals(multipartFile.getBytes().length,savedEvent.getImage().length);
//
//
//    }
//
//}
//















