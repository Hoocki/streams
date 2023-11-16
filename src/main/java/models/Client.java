package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Client {

    private final long id;

    private String name;

    private int age;

    private List<Phone> phoneList;
}
