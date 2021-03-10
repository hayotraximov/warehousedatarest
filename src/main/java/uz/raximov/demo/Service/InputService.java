package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.Currency;
import uz.raximov.demo.Entity.Input;
import uz.raximov.demo.Entity.Supplier;
import uz.raximov.demo.Entity.Warehouse;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.InputRepository;
import uz.raximov.demo.payload.InputDTO;

import java.util.Optional;
import java.util.UUID;

@Service
public class InputService {

    @Autowired
    InputRepository inputRepository;

    @Autowired
    WareHouseService wareHouseService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    CurrencyService currencyService;

    public Page<Input> page(Integer page){
        Pageable pageable = PageRequest.of(page, 10);
        return inputRepository.findAll(pageable);
    }

    public Input getById(Integer id){
        Optional<Input> optionalInput = inputRepository.findById(id);
        return optionalInput.orElseGet(Input::new);
    }

    public Delete delete(Integer id){
        return new Delete();
        //code
    }

    public Input add(InputDTO inputDTO){
        Optional<Warehouse> byId = wareHouseService.wareHouseRepository.findById(inputDTO.getWarehouseId());
        if (!byId.isPresent()) {
            return new Input();
        }

        Optional<Supplier> byId1 = supplierService.supplierRepositpory.findById(inputDTO.getSupplierId());
        if (!byId1.isPresent()) {
            return new Input();
        }

        Optional<Currency> byId2 = currencyService.currencyRepository.findById(inputDTO.getCurrencyId());
        if (!byId2.isPresent()) {
            return new Input();
        }

        Input input = new Input();
        input.setCurrency(byId2.get());
        input.setSupplier(byId1.get());
        input.setWarehouse(byId.get());

        input.setFactureNumber(inputDTO.getFacturNumber());
        input.setDate(inputDTO.getDate());
        UUID uuid = UUID.randomUUID();
        input.setCode(uuid.toString());

        return inputRepository.save(input);
    }

    public Input edit(Integer id, InputDTO inputDTO){
        Optional<Input> inputOptional = inputRepository.findById(id);

        if (inputOptional.isPresent()){
            Optional<Warehouse> byId = wareHouseService.wareHouseRepository.findById(inputDTO.getWarehouseId());
            if (!byId.isPresent()) {
                return new Input();
            }

            Optional<Supplier> byId1 = supplierService.supplierRepositpory.findById(inputDTO.getSupplierId());
            if (!byId1.isPresent()) {
                return new Input();
            }

            Optional<Currency> byId2 = currencyService.currencyRepository.findById(inputDTO.getCurrencyId());
            if (!byId2.isPresent()) {
                return new Input();
            }

            Input input = inputOptional.get();
            input.setCurrency(byId2.get());
            input.setSupplier(byId1.get());
            input.setWarehouse(byId.get());

            input.setFactureNumber(inputDTO.getFacturNumber());
            input.setDate(inputDTO.getDate());
            UUID uuid = UUID.randomUUID();
            input.setCode(uuid.toString());

            return inputRepository.save(input);
        }

        return new Input();
    }

}
