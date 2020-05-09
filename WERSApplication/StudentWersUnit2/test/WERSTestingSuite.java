
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import planning.AcidChloridePlanTest;
import planning.NullPlanTest;
import planning.StandardPlanTest;
import planning.UniquePlannerTest;
import planning.UniqueSpillKitTest;

/**
 * Suite for running all JUnit tests at once
 * @author Martin Dwyer
 */
@RunWith(Suite.class)
@SuiteClasses({
    AcidChloridePlanTest.class,
    NullPlanTest.class,
    StandardPlanTest.class,
    UniquePlannerTest.class,
    UniqueSpillKitTest.class
})

public class WERSTestingSuite {
    
    
    
}
