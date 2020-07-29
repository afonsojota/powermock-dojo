package powermock;

import java.util.ArrayList;
import java.util.List;

public class SystemNinjaToTest {

	private Dependency dependency;

	public int methodUsingAnArrayListConstructor() {
		ArrayList list = new ArrayList();
		return list.size();
	}

	public int methodCallingAStaticMethod() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return UtilityClass.staticMethod(sum);
	}

	private final long privateMethod() {
		List<Integer> stats = dependency.retrieveAllStats();
		long sum = 0;
		for (int stat : stats)
			sum += stat;
		return sum;
	}

}
