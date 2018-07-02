package com.stu.controller;

import com.stu.model.Student;
import com.stu.service.StudentService;
import com.stu.service.UserService;
import com.stu.service.impl.ProfessionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class RmiService {

    ApplicationContext act = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    @Autowired
//    @Qualifier("userService")
//    private UserService userService;
//
//    @Autowired
//    @Qualifier("userServiceB")
//    private UserService userServiceB;
//
//    @Autowired
//    @Qualifier("studentServer")
//    private StudentService studentServer;
//
//    @Autowired
//    @Qualifier("studentServerB")
//    private StudentService studentServerB;

    public UserService getUserService() {
        int rd = Math.random()>0.5?1:0;
        if (rd==0){
            return (UserService) act.getBean("userService");
        }else {
            return (UserService) act.getBean("userServiceB");
        }
    }

    public StudentService getStudentService() {

        int rd = Math.random()>0.5?1:0;
        if (rd==0){
            return (StudentService) act.getBean("studentServer");
        }else {
            return (StudentService) act.getBean("studentServerB");
        }

    }
}
