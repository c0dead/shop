package com.aromankina.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// все ресурсы будем тянуть из папки resources/static, не будем хранить их в своём приложении
// (они лежат на сервере, т. к. это часть динамического контента)

@SpringBootApplication // объединяет несколько аннотаций, которые делают автосканирование нашего репозитория,
 				       // и подключает все компоненты, которые он найдёт
public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
