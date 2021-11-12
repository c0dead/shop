package com.aromankina.shop.rest.controller;

import com.aromankina.shop.dto.CD;
import com.aromankina.shop.dto.CDs;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Обычно приложение состоит из 3-ёх прослоек:
// 1) API -- то, с чем взаимодействует фронтальный сервис, запросы к нашему серверу. Это контроллеры.
// 2) Второй уровень абстракции -- бизнес-логика. Это будут сервисы. Создадим интерфейсы, они отвечают за бизнес-логику.
//    Это самая сильнозависимая часть. Она в produces делает то, что нужно для контроллера, и потребляет то, что генерирует БД.
//    Это прослойка между нашей БД (или нашей реализацией получения данных) и тем, что мы отдаём фронту.
// 3)

// пишем запрос к серверу

// Мы написали про get "Получить все CDs (cd-дискам)". У нас есть промах. Вопрос: как получить конкретный cd-диск?
// Нужно модифицировать API. Дать уникальные id'ишники cd-дискам.
// Нужно модифицировать yaml-файл (spec.yaml) (?). Это потом. Идём в dto.

@RestController
@Validated
// @RequestMapping("v1/cds") // позволяет нам прикрепить к контроллеру относительную ссылку; говорит о том, что
// CDController обрабатывает запросы, у которых начало пути то, которое указано в скобках, а конец пути -- то, что
// мы укажем непосредственно от функции-обработчика (?)
public class CDController {
    // функции-обработчики, каждая возвращает одну из dto'шек; обязательно public
    // мы возвращаем body; мы можем отдавать либо response entity, либо request entity
    // entity -- это такие штуки, в которые одновременно входило body, коды ошибок и многое другое
    // мы будем делать другим способом
    // у нас в объявлении возвращаемого типа остаётся примитив, т. е. то, что войдёт в body
    // и принимаем мы какую-то штуку, которая тоже будет body и всякими такими вещами

    // костыль
    private final CDs cdList = new CDs();

    // пишем конструктор для CDController'а
    public CDController() {
        // т. к. у нас сейчас нет никакой штуки, которая позволяет нам генерировать наши CDs (нам негде их хранить),
        // пишем заглушку
        CDs cdList = new CDs(); // создаём контейнер для CDs, в нём будем их возвращать
        // заполняем контейнер: инициализируем CDs
        CD cd1 = new CD();
        cd1.setId(1L);
        cd1.setName("Terra Incognita");
        cd1.setArtist("Gojira");
        cd1.setReleaseDate("03/19/2001");
        cd1.setGenre("Death Metal");
        cd1.setAlbumCover("Gojira Terra Incognita.jpg"); // пока не заполняем
        cd1.setPrice(new BigDecimal(14));

        CD cd2 = new CD();
        cd2.setId(2L);
        cd2.setName("Kin");
        cd2.setArtist("Whitechapel");
        cd2.setReleaseDate("10/29/2021");
        cd2.setGenre("Progressive Death Metal");
        cd2.setAlbumCover("Whitechapel Kin.jpg"); // пока не заполняем
        cd2.setPrice(new BigDecimal(13));

        CD cd3 = new CD();
        cd3.setId(3L);
        cd3.setName("A Tear In The Fabric Of Life");
        cd3.setArtist("Knocked Loose");
        cd3.setReleaseDate("10/13/2021");
        cd3.setGenre("Hardcore");
        cd3.setAlbumCover("Knocked Loose A Tear In The Fabric Of Life.jpg"); // пока не заполняем
        cd3.setPrice(new BigDecimal(11));

        List<CD> tmp = new ArrayList<CD>();
        tmp.add(cd1);
        tmp.add(cd2);
        tmp.add(cd3);
        cdList.setCdList(tmp);
    }

    // функцию называем, как сам API
    @GetMapping (value = "cds", produces = MediaType.APPLICATION_JSON_VALUE) // т. к. у нас запрос get; пишем в кавычках какой-то get-запрос, чтобы заmap'ить функцию на запрос
    // produces задаёт то, что мы возвращаем; т. е. через наш GetMapping мы возвращаем json
    public CDs cds()  {
        return cdList; // возвращаем пока что пустой list
    }

/*@GetMapping(value="cd", )
public CD cd()
{
    return
}*/

}
