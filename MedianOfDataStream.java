
import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
  public int count = 0;
  public PriorityQueue<Integer> maxHeap;
  public PriorityQueue<Integer> minHeap;

  /** initialize your data structure here. */
  public MedianFinder() {
    maxHeap = new PriorityQueue<Integer>((x, y) -> y - x);
    minHeap = new PriorityQueue<Integer>();
  }

  public void addNum(int num) {
    count++;
    if (count == 1) {
      maxHeap.offer(num);
      return;
    }
    if (count % 2 == 0 && maxHeap.peek() < num) {
      minHeap.add(num);
    } else if (count % 2 == 0) {
      maxHeap.add(num);
      minHeap.add(maxHeap.poll());
    }
    if (count % 2 == 1 && minHeap.peek() > num) {
      maxHeap.add(num);
    } else if (count % 2 == 1) {
      minHeap.add(num);
      maxHeap.add(minHeap.poll());
    }
  }

  public double findMedian() {
    if (count % 2 == 0) {
      return ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
    } else {
      return (double) maxHeap.peek();
    }
  }
}

public class MedianOfDataStream {
  public static void main(String[] args) {
    MedianFinder m = new MedianFinder();
    m.addNum(1);
    m.addNum(4);
    System.out.println(m.findMedian());
    m.addNum(3);
    System.out.println(m.findMedian());
    m.addNum(5);
    System.out.println(m.findMedian());
    m.addNum(7);
    System.out.println(m.findMedian());
  }
}