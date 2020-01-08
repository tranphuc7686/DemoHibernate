import model.entities.Address;
import model.repo.AddressRepository;
import model.repo.AddressRepositoryImpl;

public class Main {

    public static void main(String[] args) {
        AddressRepository addressRepository = new AddressRepositoryImpl(Address.class);
        Address nhaPhuc = new Address("TT HUẾ");
        try {
            addressRepository.add(nhaPhuc);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
