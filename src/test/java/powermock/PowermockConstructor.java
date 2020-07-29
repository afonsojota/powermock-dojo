package powermock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemNinjaToTest.class)
public class PowermockConstructor {

    @InjectMocks
    SystemNinjaToTest systemNinjaToTest;

    @Test
    public void should_mock_constructor() throws Exception {
        ArrayList mockList = mock(ArrayList.class);

        given(mockList.size()).willReturn(150);
        whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

        int result = systemNinjaToTest.methodUsingAnArrayListConstructor();

        assertThat(result, is(150));
    }

}
