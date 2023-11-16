import generator.ClientGenerator;
import models.Client;
import models.Phone;
import models.Type;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class ClientUtilityTest {

    private final ClientUtility clientUtility = new ClientUtility();

    private final List<Client> clientList = ClientGenerator.clients;

    @Test
    void should_returnSumOfAges() {
        //given
        String name = "Alice";

        //when
        int sum = clientUtility.getSumOfAges(clientList, name);

        //then
        int expectedSum = 867;
        assertThat(expectedSum).isEqualTo(sum);
    }

    @Test
    void should_returnSetOfClientNames() {
        //when
        Set<String> setOfNames = clientUtility.getSetOfClientNames(clientList);

        //then
        Set<String> expectedSetOfNames = new LinkedHashSet<>(Arrays.asList("Alice", "Bob", "Clint", "David", "Ernest", "Falcon", "Gorge"));
        assertThat(expectedSetOfNames).containsExactlyElementsOf(setOfNames);
    }

    @Test
    void should_returnTrueIfClientExistsWithAgeGreaterThanSpecified() {
        //given
        int age = 5000;

        //when
        boolean exist = clientUtility.doesAgeGreaterExist(clientList, age);

        //then
        assertThat(exist).isTrue();
    }

    @Test
    void should_convertListOfClientIntoIdAndNameMap() {
        //when
        Map<Long, String> map = clientUtility.convertListtoIdandNameMap(clientList);

        //then
        Map<Long, String> expectedMap = new TreeMap<>(Map.of(0L, "Alice", 1L, "Bob", 2L, "Clint", 3L, "David", 4L, "Ernest", 5L, "Falcon", 6L, "Gorge", 7L, "Alice", 8L, "Bob", 9L, "Clint"));
        assertThat(expectedMap).isEqualTo(map);
    }

    @Test
    void should_convertListOfClientIntoAgeAndListOfClientMap() {
        //given
        final List<Client> clients = List.of(
                new Client(0, "Alice", 54, new ArrayList<>(List.of(
                        new Phone("+123456789", Type.MOBILE)
                ))),
                new Client(1, "Bob", 23, new ArrayList<>(List.of(
                        new Phone("+4556754743", Type.WIRED)
                ))),
                new Client(2, "Clint", 54, new ArrayList<>(List.of(
                )))
        );
        //when
        Map<Integer, List<Client>> map = clientUtility.convertListtoAgeandListOfClientMap(clients);

        //then
        Map<Integer, List<Client>> expectedMap = Map.of(
                54, List.of(
                        new Client(0, "Alice", 54,
                                List.of(new Phone("+123456789", Type.MOBILE))),
                        new Client(2, "Clint", 54, List.of())),
                23, List.of(
                        new Client(1, "Bob", 23,
                                List.of(new Phone("+4556754743", Type.WIRED))
                        )));
        assertThat(expectedMap).isEqualTo(map);
    }

    @Test
    void should_returnStringOfNumbers() {
        //when
        String numbers = clientUtility.getStringOfNumbers(clientList);

        //then
        String expectedNumbers = "+123456789, +4355762, +23464765, +4556754743, +5778786, +12435632, +45876221, +3435535, +5768687, +90909009, +2223, +222, +55789, +1111, +11212, +421113423";
        assertThat(expectedNumbers).isEqualTo(numbers);
    }

    @Test
    void should_returnMostEldestClientUsingWiredPhone() {
        //when
        Client client = clientUtility.getMostEldestClientUsingWiredPhone(clientList);

        //then
        Client expectedClient = new Client(8, "Bob", 5455, new ArrayList<>(List.of(
                new Phone("+1111", Type.WIRED),
                new Phone("+11212", Type.WIRED)
        )));
        assertThat(expectedClient).isEqualTo(client);
    }
}
