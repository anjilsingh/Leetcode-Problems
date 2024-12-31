//we have to create two pq 
//one for adding all min value that will be maxheap
//one for adding all max value that will be minheap
//then make sure while adding remove and push to other if diff is greater 
//then if size is same remove from bothe side and then divide by two 
//is small length is greater return its peak else return large peak
class MedianFinder {
    PriorityQueue<Integer>small;
    PriorityQueue<Integer>large;
    public MedianFinder() {
        small=new PriorityQueue<>((a,b)->b-a);
        large=new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
    // Add to small heap first
    small.add(num);

    // Ensure small's top is <= large's top
    if (!large.isEmpty() && small.peek() > large.peek()) {
        large.add(small.poll());
    }

    // Rebalance the heaps if sizes differ by more than 1
    if (small.size() > large.size() + 1) {
        large.add(small.poll());
    } else if (large.size() > small.size() + 1) {
        small.add(large.poll());
    }
}

    
    public double findMedian() {
        if(large.size()==small.size()) return ((double)(large.peek())+(double)(small.peek()))/2;
        else if(large.size()>small.size())  return (double)large.peek();
        else return (double) small.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */