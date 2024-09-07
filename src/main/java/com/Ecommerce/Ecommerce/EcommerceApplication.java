package com.Ecommerce.Ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class EcommerceApplication {

	public static void main(String[] args) {

		SpringApplication.run(EcommerceApplication.class, args);
//		String url = "jdbc:oracle:thin:@localhost:1521:orcl2";
//		String user = "CET341";
//		String password = "sawwinthant";
//
//		try (
//				Connection connection = DriverManager.getConnection(url, user, password)) {
//			System.out.println("Connected to Oracle 21c database!");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
