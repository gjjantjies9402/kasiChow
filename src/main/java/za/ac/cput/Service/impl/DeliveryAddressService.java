package za.ac.cput.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Entity.DeliveryAddress;
import za.ac.cput.Repository.Interface.IDeliveryAddressRepository;
import za.ac.cput.Service.Interface.IDeliveryAddressService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryAddressService implements IDeliveryAddressService {

    private static DeliveryAddressService service;

    @Autowired
    private IDeliveryAddressRepository repository;

    public static DeliveryAddressService getDeliveryAddressService() {

        if(service == null) {
            service = new DeliveryAddressService();
        }

        return service;
    }

    private DeliveryAddressService()
    {
        this.repository = repository;

    }

    public Set<DeliveryAddress> getAll() {

        return this.repository.findAll().stream().collect(Collectors.toSet());

    }

    @Override
    public DeliveryAddress create(DeliveryAddress deliveryAddress) {

        return this.repository.save(deliveryAddress);

    }

    @Override
    public DeliveryAddress read(String s) {

        return this.repository.findById(s).orElseGet(null);

    }

    @Override
    public DeliveryAddress update(DeliveryAddress deliveryAddress) {

        if(this.repository.existsById(deliveryAddress.getDeliveryID())) {
            return this.repository.save(deliveryAddress);
        }

        return null;

    }

    @Override
    public boolean delete(String s) {

        this.repository.deleteById(s);

        if(this.repository.existsById(s)) return false;
        else return true;

    }

    public List<DeliveryAddress> getAllDeliveryAddresses() {
        return this.repository.findAll();
    }
}
