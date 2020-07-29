package powermock;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
public class PowermockPrivate {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemNinjaToTest systemNinjaToTest;

    @Test
    public void should_mock_private_method() throws Exception {

        given(dependency.retrieveAllStats()).willReturn(Arrays.asList(1, 2, 3));

        long result = (Long) Whitebox.invokeMethod(systemNinjaToTest, "privateMethod");

        assertThat(result, is(6l));

    }

}
