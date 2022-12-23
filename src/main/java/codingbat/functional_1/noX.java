package codingbat.functional_1;

import java.util.List;
import java.util.stream.Collectors;

public class noX {
    public List<String> noX(List<String> strings) {
        return strings.stream()
                .map(s -> s.replaceAll("x", ""))
                .collect(Collectors.toList());
    }

}
