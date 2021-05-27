import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestOffByOne {
    
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
//    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/
    @Test
    public void testOffByOne() {
    	assertTrue(offByOne.equalChars('b', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
        assertFalse(offByOne.equalChars('a', ' '));
        assertTrue(offByOne.equalChars('a', 'b'));
    	assertFalse(offByOne.equalChars('a', 'A'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('A', 'B'));



    }
    @Test
    public void testOffByOne2(){

    }
}
