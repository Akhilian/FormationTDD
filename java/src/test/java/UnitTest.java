import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class UnitTest {

    @Test
    public void assertTrue_shouldBeFalse() throws Exception
    {
        assertThat(true).isTrue();
    }
}
