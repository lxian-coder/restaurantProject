//package com.darcy.restaurantproject.controllers;
//
//import com.darcy.restaurantproject.dtos.EventGetDTO;
//import com.darcy.restaurantproject.services.EventService;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.anyLong;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
///**
// * Darcy Xian  24/5/21  3:16 pm      restaurantProject
// */
//@ExtendWith(SpringExtension.class)
//@WebMvcTest(ImageController.class)
//public class ImageControllerTest {
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private ImageService imageService;
//    @MockBean
//    private EventService eventService;
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Test
//    public void testRenderImageFromDB() throws Exception{
//        //given
//       EventGetDTO eventGetDTO = new EventGetDTO();
//       eventGetDTO.setId(1L);
//
//        String s = "Fake image text";
//        Byte[] byteBoxed = new Byte[s.getBytes().length];
//        int i = 0;
//        for(byte primByte : s.getBytes()){
//            byteBoxed[i++] = primByte;
//        }
//        eventGetDTO.setImage(byteBoxed);
//        when(eventService.findByID(anyLong())).thenReturn(eventGetDTO);
//
//        // when
//        MockHttpServletResponse response =
//                mockMvc.perform(get("/image/1")
//                        .content(objectMapper.writeValueAsString(eventGetDTO))
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn().getResponse();
//
//        byte[] reponseBytes = response.getContentAsByteArray();
//        assertEquals(s.getBytes().length,reponseBytes.length);
//    }
//    @Test
//    public void testPostUpdateImage() throws Exception{
//        MockMultipartFile multipartFile =
//                new MockMultipartFile("imageFile","testing.txt","text/plain",
//                        "Spring Framework Darcy".getBytes());
//        mockMvc.perform(multipart("/image/1/post").file(multipartFile))
//                .andExpect(status().is2xxSuccessful());
//    }
//}
