package models;

import lombok.Data;

@Data
public class Phone {

    private final String number;

    private final Type type;
}
