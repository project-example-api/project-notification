package br.com.cers.restservice.dao.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "NOTIFICATION")
public class NotificationEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NOTIFICATION_ID")
    private long id;

    @Column(name = "TITLE")
    private String title;
    
    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PUBLICATION")
    private Date publication;

    @Column(name = "VISUALIZATION")
    private Date visualization; 
}
