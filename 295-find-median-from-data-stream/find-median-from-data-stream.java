class MedianFinder {
    PriorityQueue<Integer>small;
    PriorityQueue<Integer>big;
    public MedianFinder() {
        small=new PriorityQueue<>((a,b)->b-a);
        big=new PriorityQueue<>((a,b)->a-b);
    }
    
    public void addNum(int num) {
        small.add(num);
        //small peek val should be less than big peek val
        if(!big.isEmpty() && small.peek()>big.peek()){
            big.add(small.poll());
        }

        //if diff bts small and big increase by one

        if(small.size()>big.size()+1){
            big.add(small.poll());
        }

        if(big.size()>small.size()+1){
            small.add(big.poll());
        }
    }
    
    public double findMedian() {
        if(big.size()==small.size()){
            return (((double)big.peek()+small.peek())/2);

        }

        else if(big.size()>small.size()){
            return big.peek();
        }
        else{
            return small.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */