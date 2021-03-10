package uz.raximov.demo.payload;

import lombok.Data;

@Data
public class UserDTO {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private Integer[] wareHouseId;
    private boolean status;
}
