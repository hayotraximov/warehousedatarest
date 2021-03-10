package uz.raximov.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.raximov.demo.Entity.User;
import uz.raximov.demo.Entity.Warehouse;
import uz.raximov.demo.Messages.Delete;
import uz.raximov.demo.Repository.UserRepository;
import uz.raximov.demo.payload.UserDTO;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WareHouseService wareHouseService;

    //Barchasini qaytarish
    public Page<User> page(Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return userRepository.findAll(pageable);
    }

    //Id bo'yicha qaytarish
    public User getById(Integer id){
        Optional<User> optionalCategory = userRepository.findById(id);
        return optionalCategory.orElseGet(User::new);
    }

    //O'chirish
    public Delete delete(Integer id){
        return new Delete();
        //kod yozish kerak
    }

    //Qo'shish
    public User add(UserDTO userDTO){
        Optional<User> optionalUser = userRepository.findByPhoneNumber(userDTO.getPhoneNumber());
        if (!optionalUser.isPresent()) {
            UUID uuid = UUID.randomUUID();
            User user = new User();
            user.setActive(userDTO.isStatus());
            user.setCode(uuid.toString());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setPassword(userDTO.getPassword());

            Set<Warehouse> warehouseSet = new HashSet<>();
            for (Integer integer : userDTO.getWareHouseId()) {
                Optional<Warehouse> warehouseOptional = wareHouseService.wareHouseRepository.findById(integer);
                warehouseOptional.ifPresent(warehouseSet::add);
            }

            user.setWarehouseSet(warehouseSet);
            return userRepository.save(user);
        }
        return new User();
    }

    //Tahrirlash
    public User edit(Integer id, UserDTO userDTO){

        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            UUID uuid = UUID.randomUUID();
            User user = userOptional.get();
            user.setActive(userDTO.isStatus());
            user.setCode(uuid.toString());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setPhoneNumber(userDTO.getPhoneNumber());
            user.setPassword(userDTO.getPassword());

            Set<Warehouse> warehouseSet = new HashSet<>();
            for (Integer integer : userDTO.getWareHouseId()) {
                Optional<Warehouse> warehouseOptional = wareHouseService.wareHouseRepository.findById(integer);
                warehouseOptional.ifPresent(warehouseSet::add);
            }

            user.setWarehouseSet(warehouseSet);
            return userRepository.save(user);
        }
        return new User();
    }
}
