package com.allcom.persistence;

import com.allcom.domain.CharacterRate;
import com.allcom.domain.Request;
import com.allcom.domain.repository.RequestRepository;
import com.allcom.persistence.crud.SolicitudCrudRepository;
import com.allcom.persistence.entity.Solicitud;
import com.allcom.persistence.entity.TarifaCaracter;
import com.allcom.persistence.mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SolicitudRepository implements RequestRepository {
    @Autowired
    private SolicitudCrudRepository solicitudCrudRepository;
    @Autowired
    private RequestMapper mapper;

    @Override
    public List<Request> getAll(){
        List<Solicitud> solicitudes = (List<Solicitud>) solicitudCrudRepository.findAll();
        return mapper.toRequests(solicitudes);
    }

    @Override
    public Optional<List<Request>> getByUser(String userNameId){
        Optional<List<Solicitud>> solicitudes = solicitudCrudRepository.findByIdUsuarioNombre(userNameId);
        return solicitudes.map(solicitud -> mapper.toRequests(solicitud));
    }

    @Override
    public Request save(Request request) {
        Solicitud solicitud = mapper.toSolicitud(request);
        return mapper.toRequest(solicitudCrudRepository.save(solicitud));
    }

}
