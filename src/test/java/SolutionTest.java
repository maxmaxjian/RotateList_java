import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private ListNode input1;
    private int input2;
    private ListNode expected;
    private Solution soln = new Solution2();

    public SolutionTest(ListNode input1, int input2, ListNode output) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {createList(new int[]{1, 2, 3, 4, 5}), 2, createList(new int[]{4, 5, 1, 2, 3})},
                {createList(new int[]{0,1,2}), 4, createList(new int[]{2,0,1})},
                {createList(new int[]{}), 1, createList(new int[]{})}
        });
    }

    @Test
    public void testRotate() {
        assert(checkEqual(expected, soln.rotateRight(input1, input2)));
    }

    private boolean checkEqual(ListNode expected, ListNode actual) {
        ListNode p1 = expected, p2 = actual;
        while (p1 != null && p2 != null) {
            if (p1.val != p2.val) {
                return false;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        if (p1 == null && p2 == null) {
            return true;
        } else {
            return false;
        }
    }

    private static ListNode createList(int[] ints) {
        ListNode head = null;
        if (ints.length > 0) {
            head = new ListNode(ints[0]);
            ListNode p = head;
            for (int i = 1; i < ints.length; i++) {
                p.next = new ListNode(ints[i]);
                p = p.next;
            }
        }
        return head;
    }
}