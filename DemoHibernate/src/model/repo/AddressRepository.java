package model.repo;

import model.entities.Address;

import java.util.Optional;

public interface AddressRepository {
    Optional<Address> getAddressbyId(int id) throws Exception;
    void add(Address address) throws Exception;
}
