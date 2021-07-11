import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void test1() {
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StringBuilder message = new StringBuilder();
        for(int i = 0; i < 100; i++) {
            double number = StdRandom.uniform();
            if(number < 0.25) {
                sad.addFirst(i);
                ads.addFirst(i);
                message.append("addFirst(" + i + ")\n");
            } else if(number < 0.5) {
                sad.addLast(i);
                ads.addLast(i);
                message.append("addLast(" + i + ")\n");
            } else if(number < 0.75) {
                Integer sadNum = sad.removeFirst();
                Integer adsNum = ads.removeFirst();
                message.append("removeFirst()\n");
                assertEquals("removeFirst error", adsNum, sadNum);
            } else {
                Integer sadNum = sad.removeLast();
                Integer adsNum = ads.removeLast();
                message.append("removeLast()\n");
                assertEquals(message.toString(), adsNum, sadNum);
            }
        }

    }
}
