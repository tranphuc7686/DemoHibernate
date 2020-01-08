package model.repo;

import model.entities.Address;
import ultis.GenericRepository;

import java.util.Optional;

public class AddressRepositoryImpl extends GenericRepository<Address> implements AddressRepository {
    public AddressRepositoryImpl(Class<Address> entityClass) {
        super(entityClass);
    }

    @Override
    public Optional<Address> getAddressbyId(int id) throws Exception {
        return Optional.of(super.getById(id));
    }

    @Override
    public void add(Address address) throws Exception {
        super.create(address);
    }
}
