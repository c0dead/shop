package com.aromankina.shop.dto;
// непосредственная реализация API
// в пакете dto (data transfer object) описываем схемы

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Schema(description = "the brief info about a cd")
@Validated // говорит о том, что этот класс нужно валидировать по тем условиям, которые там написаны (в файле spec.yaml)
public class CD {
    @NotNull
    @Schema(description = "the id of a cd", required = true)
    @JsonProperty("id")
    private Long id;

    // в файле spec.yaml написали required (указывали поля, которые not null)
    @NotNull
    @Schema(description = "the name of an album", required = true) // Schema из swagger'а и плагина -- для генерации документации swagger'а
    @JsonProperty("name") // name -- название поля в json-файле; явно указываем, как эта переменная называется в json'е
    private String name; // @Data нам сгенерировала сеттеры и геттеры и всё остальное

    @NotNull
    @Schema(description = "the name of an artist", required = true)
    @JsonProperty("artist")
    private String artist;

    @NotNull
    @Schema(description = "the release date of an album", required = true)
    @JsonProperty("release_date")
    private String releaseDate;

    @NotNull
    @Schema(description = "the genre of an album", required = true)
    @JsonProperty("genre")
    private String genre;

    @NotNull
    @Schema(description = "the relative url of an image", required = true)
    @JsonProperty("album_cover")
    private String albumCover;

    @NotNull
    @Schema(description = "the price of an album", required = true)
    @JsonProperty("price")
    private BigDecimal price;
}
