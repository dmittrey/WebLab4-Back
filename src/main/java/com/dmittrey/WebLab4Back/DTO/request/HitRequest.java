package com.dmittrey.WebLab4Back.DTO.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class HitRequest {

    @JsonProperty(value = "xValue")
    @NotNull(message = "X value should exist")
    @Pattern(regexp = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$", message = "X value form is incorrect")
    private String xValue;

    @JsonProperty(value = "yValue")
    @NotNull(message = "Y value should exist")
    @Pattern(regexp = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$", message = "Y value form is incorrect")
    private String yValue;

    @JsonProperty(value = "rValue")
    @NotNull(message = "R value should exist")
    @Pattern(regexp = "^[+-]?([0-9]+([.][0-9]*)?|[.][0-9]+)$", message = "R value form is incorrect")
    private String rValue;
}
