package Heap;

public class MedianFromStream {
    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        finder.findMedian();
        finder.addNum(5);
        finder.addNum(3);
        finder.addNum(6);
        finder.addNum(4);
        finder.addNum(0);
        finder.findMedian();
    }
}
