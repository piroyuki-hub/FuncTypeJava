import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    @InjectMocks
    Main target;

    static final List<String> FRIENDS = List.of("Brian", "Nate", "Neal", "Raju", "Sara", "Scott");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() {}

    @Test
    void pickElementsTest() {
        List<String> actual = target.pickElements(FRIENDS);
        assertThat(actual).isNotNull().size().isEqualTo(2);
    }

    @Test
    void pickElementCountTest() {
        long actual = target.pickElementCount(FRIENDS);
        assertThat(actual).isEqualTo(2);
    }

    @Test
    void pickDifferentFriendCountTest() {
        long actual = target.pickDifferentFriendCount(FRIENDS, "N");
        assertThat(actual).isEqualTo(2);

        actual = target.pickDifferentFriendCount(FRIENDS, "B");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    void pickNameTest() {
        String actual = Main.pickName(FRIENDS, "N");
        assertThat(actual).isEqualTo("A name starting with N: Nate");

        actual = Main.pickName(FRIENDS, "Z");
        assertThat(actual).isEqualTo("A name starting with Z: No name found");
    }
}
