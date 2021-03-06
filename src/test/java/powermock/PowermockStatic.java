package powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UtilityClass.class)
public class PowermockStatic {

    @Mock
    Dependency dependency;

    @InjectMocks
    SystemNinjaToTest systemNinjaToTest;

    @Test
    public void should_mock_static(){
        given(dependency.retrieveAllStats()).willReturn(Arrays.asList(1, 2, 3));

        mockStatic(UtilityClass.class);

        systemNinjaToTest.methodCallingAStaticMethod();

        verifyStatic(Mockito.times(1));
        UtilityClass.staticMethod(6);
    }

}
