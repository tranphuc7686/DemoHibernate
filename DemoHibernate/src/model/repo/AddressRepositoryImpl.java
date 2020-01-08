package model.repo;

import model.entities.Address;
import ultis.GenericRepository;

import java.util.List;
import java.util.Optional;

public class AddressRepositoryImpl extends GenericRepository<Address> implements AddressRepository {

    public AddressRepositoryImpl() {
        super(Address.class);
    }

    @Override
    public Optional<Address> getAddressbyId(int id) throws Exception {
        return Optional.of(super.getById(id));
    }

    @Override
    public void add(Address address) {
        super.create(address);
    }

    @Override
    public List<Address> getAll(){
        return super.getAll();
    }
}
