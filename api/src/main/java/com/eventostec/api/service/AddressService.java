package com.eventostec.api.service;


import com.eventostec.api.domain.adress.Address;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import com.eventostec.api.repositories.AddressRepository;
import com.eventostec.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private AddressRepository addressRepository;

    public Address createAddress(Event event, EventRequestDTO data){

        Address newAddress = new Address();
        newAddress.setCity(data.city());
        newAddress.setUf(data.state());
        newAddress.setEvent(event);

        return addressRepository.save(newAddress);
    }
}
