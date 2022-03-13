package com.mista1984.rest.config;

import com.mista1984.rest.controller.Student;
import com.mista1984.rest.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    public CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args ->{
            studentRepository.saveAll(List.of(
                    new Student("Alex", "alex@gmail.com", LocalDate.of(2000, Month.SEPTEMBER,12)),
                            new Student("Oleg","oleg@gmail.com", LocalDate.of(1997, Month.JANUARY,1))
            ));
        };
    }

}
