/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package planning;

import junit.framework.TestCase;

/**
 *
 * @author riggs
 */
public class UniqueSpillKitTest extends TestCase {

    public UniqueSpillKitTest(String testName) {
        super(testName);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Used mostly for error printing of details about the interview.
     *
     * @param s
     * @param sc
     * @param sz
     * @return
     */
    String interviewString(String[] s, SpillCase sc, int sz) {
        return new String("[" + s[1] + "," + s[0] + "," + s[2] + "," + s[3]
                + "," + sc + "," + sz + "]");
    }

    public void checkUniqueSpillKit() {

    }

    public void testCheckUniqueSpillKit() throws Exception {

        Planner planner = Planner.getThePlanner();
        // lastName, firstName, building, room, materialSpilled
        String[] interview = {"Smith", "Bill", "2", "301"};
        // small spill responded to by known person
        SpillCase material = SpillCase.standard;
        int sz = 12;

        // even the same spill should receive two different spill kits
        Plan p8 = planner.getPlan(interview, material, sz);
        Plan p9 = planner.getPlan(interview, material, sz);
        System.out.println("SPILL KITS were from "
                + p8.getAreaInfo().nearSpillKit() + " and "
                + p9.getAreaInfo().nearSpillKit());
        if (p8.getAreaInfo().nearSpillKit().equals(p9.getAreaInfo().nearSpillKit())) {
            fail("Same spill kit used twice! Have you not yet fixed concurrency?");
        }

    }

}
