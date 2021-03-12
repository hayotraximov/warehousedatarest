package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Warehouse;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.WareHouseRepository;

import java.util.List;
import java.util.Optional;


@Service
public class WareHouseService {

    @Autowired
    WareHouseRepository wareHouseRepository;

    public Page<Warehouse> page(Integer page) {
        Pageable pageable = PageRequest.of(page, 10);
        return wareHouseRepository.findAll(pageable);
    }

    public List<Warehouse> getAll() {
        return wareHouseRepository.findAll();
    }

    //Id bo'yicha qaytarish
    public Warehouse getById(Integer id) {
        Optional<Warehouse> optionalWarehouse = wareHouseRepository.findById(id);
        return optionalWarehouse.orElseGet(Warehouse::new);
    }

    //O'chirish
    public Delete delete(Integer id) {
        return new Delete();
        //kod yozish kerak
    }

    //Qo'shish
    public Warehouse add(Warehouse warehouse) {
        Optional<Warehouse> warehouseOptional = wareHouseRepository.findByName(warehouse.getName());
        if (!warehouseOptional.isPresent()) {
            Warehouse currency1 = new Warehouse();
            currency1.setActive(true);
            currency1.setName(warehouse.getName());
            return wareHouseRepository.save(currency1);
        }
        return new Warehouse();
    }

    //Tahrirlash
    public Warehouse edit(Integer id, Warehouse warehouse) {
        Optional<Warehouse> optionalWarehouse = wareHouseRepository.findById(id);
        if (optionalWarehouse.isPresent()) {
            Warehouse currency1 = optionalWarehouse.get();
            currency1.setName(warehouse.getName());
            currency1.setActive(true);
            return wareHouseRepository.save(currency1);
        }
        return new Warehouse();
    }
}
