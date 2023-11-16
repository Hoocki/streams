import models.Client;
import models.Phone;
import models.Type;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class ClientUtility {

    public int getSumOfAges(final List<Client> clientList, final String name) {
        return clientList
                .stream()
                .filter(client -> client.getName().equals(name))
                .mapToInt(Client::getAge)
                .sum();
    }

    public Set<String> getSetOfClientNames(final List<Client> clientList) {
        return clientList
                .stream()
                .map(Client::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public boolean doesAgeGreaterExist(final List<Client> clientList, final int age) {
        return clientList
                .stream()
                .map(Client::getAge)
                .anyMatch(clientAge -> clientAge > age);
    }

    public Map<Long, String> convertListtoIdandNameMap(final List<Client> clientList) {
        return clientList
                .stream()
                .collect(Collectors.toMap(
                        Client::getId,
                        Client::getName,
                        (c1, c2) -> c2,
                        TreeMap::new));
    }

    public Map<Integer, List<Client>> convertListtoAgeandListOfClientMap(final List<Client> clientList) {
        return clientList
                .stream()
                .collect(Collectors.groupingBy(Client::getAge));
    }

    public String getStringOfNumbers(final List<Client> clientList) {
        return clientList
                .stream()
                .flatMap(client -> client.getPhoneList().stream())
                .map(Phone::getNumber)
                .collect(Collectors.joining(", "));
    }

    public Client getMostEldestClientUsingWiredPhone(final List<Client> clientList) {
        return clientList
                .stream()
                .filter(client -> client.getPhoneList().stream().anyMatch(phone -> Type.WIRED.equals(phone.getType())))
                .max(Comparator.comparingInt(Client::getAge))
                .orElseThrow(() -> new NullPointerException("No client with a wired phone found"));
    }
}