package br.com.cers.restservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cers.restservice.dao.NotificationRepository;
import br.com.cers.restservice.dao.entity.NotificationEntity;
import br.com.cers.restservice.exception.BusinessEntityNotFoundException;
import br.com.cers.restservice.exception.BusinessException;
import br.com.cers.restservice.model.NotificationDTO;
import br.com.cers.restservice.model.NotificationListDTO;

@Service
public class NotificationServices {
	
    @Autowired
    private NotificationRepository repository;

    public NotificationListDTO findAll() throws BusinessException {
        
        List<NotificationEntity> entity = repository.findAll();
        NotificationListDTO ret = new NotificationListDTO();
        
        for (NotificationEntity notifications : entity) {
            NotificationDTO notification = entityToDTO(notifications);
            
            ret.add(notification);
        }
        
        return ret;
    }
    
    public NotificationDTO findById(long id) throws BusinessException {
        //long id = Long.parseLong(notificationId);
        
        Optional<NotificationEntity> entityOpt = repository.findById(id);
        
        if(entityOpt.isEmpty()) {
            throw new BusinessEntityNotFoundException("notificationId: " + id);
        }   
        
        NotificationDTO ret = entityToDTO(entityOpt.get());
        
        return ret;
    }
    
    public void deleteById(long id) throws BusinessException {
        repository.deleteById(id);
    }
    
    public NotificationDTO save(NotificationDTO notificationDTO) {
        NotificationEntity entity = repository.save(dTOToEntity(notificationDTO));
        
        NotificationDTO ret = entityToDTO(entity);
        
        return ret;
    }
    
    private NotificationEntity dTOToEntity(NotificationDTO dto) {
        NotificationEntity ret = new NotificationEntity();
        
        ret.setId(dto.getId());
        ret.setTitle(dto.getTitle());
        ret.setDescription(dto.getDescription());
        ret.setPublication(dto.getPublication());
        ret.setVisualization(dto.getVisualization());
        
        return ret;
    }
    
    private NotificationDTO entityToDTO(NotificationEntity entity) {
        NotificationDTO ret = new NotificationDTO();
        
        ret.setId(entity.getId());
        ret.setTitle(entity.getTitle());
        ret.setDescription(entity.getDescription());
        ret.setPublication(entity.getPublication());
        ret.setVisualization(entity.getVisualization());
        
        return ret;
    }
}
