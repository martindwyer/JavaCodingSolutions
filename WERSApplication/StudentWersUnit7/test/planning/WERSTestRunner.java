/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;



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


public class WERSTestRunner {
    
}
