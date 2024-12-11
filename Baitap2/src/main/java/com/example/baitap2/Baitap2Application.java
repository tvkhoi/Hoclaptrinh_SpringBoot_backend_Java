package com.example.baitap2;

import com.example.baitap2.model.Client;
import com.example.baitap2.model.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Baitap2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Baitap2Application.class, args);
        // Cách 1 cơ bản
        //EmailService emailService = new EmailService();
        //Client client = new Client(emailService);
        //client.processMessage("Hello World");
        // Cách 2 Sử dụng phương pháp IOC
        // Sử dụng anotation @component
        // Để quản lí các lớp
        //Client client = context.getBean(Client.class);
        //client.processMessage("Hello World");
        // Cách 3 Kết hợp anotation @Autowired
        // @Autowired sử dụng được cho 1 constructor, 1 trường field, 1 phương thức (setter)
        // Áp dụng cho từng cái có từng ưu nhược khác nhau
        // Ở đây áp dụng tiêm vào 1 trường field
        Client client = context.getBean(Client.class);
        client.processMessage("Hello World");
    }

}
