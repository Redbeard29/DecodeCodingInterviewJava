package netflix;

import java.util.PriorityQueue;

public class MedianOfAges {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianOfAges(){
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertAge(int age){
        //Determine which heap to add the incoming age to
        if(maxHeap.isEmpty() || maxHeap.peek() >= age)
            maxHeap.add(age);
        else
            minHeap.add(age);

        //Balance the heaps - heaps will either be even or maxHeap will have one more element
        if(maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if(maxHeap.size() < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    public double findMedian(){
        //If num of elems is even, we take the top from both and find the average
        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
        //If maxHeap has one more elem, it will be the median
        return maxHeap.peek();
    }

    public static void main(String[] args){
        MedianOfAges MedianOfAges = new MedianOfAges();
        MedianOfAges.insertAge(22);
        MedianOfAges.insertAge(35);
        System.out.println("The median age is: " + MedianOfAges.findMedian());
        MedianOfAges.insertAge(30);
        System.out.println("The median age is: " + MedianOfAges.findMedian());
        MedianOfAges.insertAge(25);
        System.out.println("The median age is: " + MedianOfAges.findMedian());
    }

}
