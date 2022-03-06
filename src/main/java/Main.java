import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.startsWith;

public class Main {

    List<String> pickElements(List<String> list) {
                    return list.stream().filter(name -> startsWith(name, "N"))
                .collect(Collectors.toList());
    }

    final Predicate<String> startWithN = name -> startsWith(name, "N");
    long pickElementCount(List<String> list) {
        return list.stream().filter(startWithN).count();
    }

    // NOTE refactor
//    private static Predicate<String> checkIfStartsWith(final String letter) {
//        return name -> startsWith(name, letter);
//    }
    final Function<String, Predicate<String>> startsWithLetter = letter -> name -> startsWith(name, letter);
    long pickDifferentFriendCount(List<String> list, String letter) {
//        return list.stream().filter(checkIfStartsWith(letter)).count();
        return list.stream().filter(startsWithLetter.apply(letter)).count();
    }

    static String pickName(final List<String> names, final String stsrtingLetter) {
        final Optional<String> foundName = names.stream()
                .filter(name -> startsWith(name, stsrtingLetter))
                .findFirst();
        foundName.ifPresent(name -> System.out.println(join("Hello ", name)));
        return String.format("A name starting with %s: %s", stsrtingLetter, foundName.orElse("No name found"));
    }
}
