import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class TestCompute {
  Compute c;

  @Test
  public void testCountNumberOfOccurrences_EmptyQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(0);
    c = new Compute(mq);
    assertEquals(-1, c.countNumberOfOccurrences("test"));
  }

  // Assuming there are 3 elements in the queue for below tests.
  @Test
  public void testCountNumberOfOccurrences_ElementNotInQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3); 
    when(mq.contains("test")).thenReturn(false);
    c = new Compute(mq);
    assertEquals(0, c.countNumberOfOccurrences("test"));
  }

  @Test
  public void testCountNumberOfOccurrences_ElementInQueue() {
    MessageQueue mq = mock(MessageQueue.class);
    when(mq.size()).thenReturn(3); 
    when(mq.contains("test")).thenReturn(true);
    when(mq.getAt(0)).thenReturn("test");
    when(mq.getAt(1)).thenReturn("abc");
    when(mq.getAt(2)).thenReturn("test");
    c = new Compute(mq);
    assertEquals(2, c.countNumberOfOccurrences("test"));
  }
}
