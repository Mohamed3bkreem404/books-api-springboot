package com.SpringData.DataProject.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService{

            @Async
            public void sendEmailToUser(){
                System.out.println("Book have been added successfully");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

}
