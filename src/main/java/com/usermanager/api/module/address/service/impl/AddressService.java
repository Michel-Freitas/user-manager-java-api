package com.usermanager.api.module.address.service.impl;

import com.usermanager.api.module.address.dto.RCreateAddressDto;
import com.usermanager.api.module.address.model.AddressModel;
import com.usermanager.api.module.address.service.IAddressService;
import com.usermanager.api.module.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

    @Autowired
    private IUserRepository userRepository;

//    @Override
//    public AddressModel create(RCreateAddressDto addressDto) {
//        AddressModel address = new AddressModel();
//        userRepository.save(address);
//    }
}
