package com.aromankina.shop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Schema // в файле spec.yaml description не написано
@Validated
public class CDs {
    @NotNull
    @Schema
    @JsonProperty("cd_list")
    private List<CD> cdList;
}
