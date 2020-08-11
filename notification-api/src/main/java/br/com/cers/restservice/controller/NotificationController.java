package br.com.cers.restservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cers.restservice.exception.BusinessException;
import br.com.cers.restservice.model.NotificationDTO;
import br.com.cers.restservice.model.NotificationListDTO;
import br.com.cers.restservice.model.NotificationResponse;
import br.com.cers.restservice.service.NotificationServices;

@RestController
@RequestMapping(value = "/notification")
public class NotificationController {

    @Autowired
    private NotificationServices service;

    @GetMapping(value = "/notifications")
    public ResponseEntity<NotificationResponse> listNotifications() throws BusinessException {

        NotificationListDTO notificationList = service.findAll();
        
        NotificationResponse ret = new NotificationResponse();
        ret.setNotification(notificationList);

        return new ResponseEntity<NotificationResponse>(ret, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<NotificationDTO> getNotification(@PathVariable long id) throws BusinessException {

        NotificationDTO notification = service.findById(id);
        
        return new ResponseEntity<NotificationDTO>(notification, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNotification(@PathVariable long id) throws Exception {
        service.deleteById(id);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<NotificationDTO> createNotification(@RequestBody NotificationDTO notificationDTO) throws Exception {
        NotificationDTO notification = service.save(notificationDTO);

        return new ResponseEntity<NotificationDTO>(notification, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<NotificationDTO> updateNotification(@PathVariable long id, @RequestBody NotificationDTO notificationDTO) throws Exception {
        NotificationDTO notification = service.findById(id);
        
        if(notification.getId() == id) {
            notification = service.save(notificationDTO);
        }
        
        return new ResponseEntity<NotificationDTO>(notification, HttpStatus.OK);
    }
}
