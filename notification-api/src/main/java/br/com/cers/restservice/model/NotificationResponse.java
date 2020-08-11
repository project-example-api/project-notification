package br.com.cers.restservice.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationResponse {

    @JsonProperty("page")
    private int page = 0;

    @JsonProperty("per_page")
    private int per_page = 0;

    @JsonProperty("total")
    private int total = 0;

    @JsonProperty("total_pages")
    private int total_pages = 0;

    @JsonProperty("list")
    private NotificationListDTO notification = null;

}
