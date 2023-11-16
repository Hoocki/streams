package generator;

import lombok.experimental.UtilityClass;
import models.Client;
import models.Phone;
import models.Type;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class ClientGenerator {
    public final List<Client> clients = List.of(
            new Client(0, "Alice", 777, new ArrayList<>(List.of(
                    new Phone("+123456789", Type.MOBILE),
                    new Phone("+4355762", Type.MOBILE),
                    new Phone("+23464765", Type.WIRED)
            ))),
            new Client(1, "Bob", 23, new ArrayList<>(List.of(
                    new Phone("+4556754743", Type.MOBILE)
            ))),
            new Client(2, "Clint", 54, new ArrayList<>(List.of(
                    new Phone("+5778786", Type.WIRED),
                    new Phone("+12435632", Type.WIRED)
            ))),
            new Client(3, "David", 90, new ArrayList<>(List.of(
                    new Phone("+45876221", Type.MOBILE),
                    new Phone("+3435535", Type.MOBILE),
                    new Phone("+5768687", Type.WIRED),
                    new Phone("+90909009", Type.MOBILE)
            ))),
            new Client(4, "Ernest", 0, new ArrayList<>(List.of(

            ))),
            new Client(5, "Falcon", 43, new ArrayList<>(List.of(
                    new Phone("+2223", Type.MOBILE),
                    new Phone("+222", Type.WIRED)
            ))),
            new Client(6, "Gorge", 54, new ArrayList<>(List.of(

            ))),
            new Client(7, "Alice", 90, new ArrayList<>(List.of(
                    new Phone("+55789", Type.WIRED)
            ))),
            new Client(8, "Bob", 5455, new ArrayList<>(List.of(
                    new Phone("+1111", Type.WIRED),
                    new Phone("+11212", Type.WIRED)
            ))),
            new Client(9, "Clint", 111, new ArrayList<>(List.of(
                    new Phone("+421113423", Type.MOBILE)
            )))
    );
}