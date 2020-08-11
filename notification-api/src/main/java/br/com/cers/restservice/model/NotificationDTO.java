package br.com.cers.restservice.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationDTO  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private long id = 0;

  @JsonProperty("title")
  private String title = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("publication")
  private Date publication = null;

  @JsonProperty("visualization")
  private Date visualization = null;
}

