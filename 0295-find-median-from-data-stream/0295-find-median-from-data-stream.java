class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        this.minHeap = new PriorityQueue();
        this.maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()){
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.offer(maxHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) return maxHeap.peek();
        if(minHeap.size() > maxHeap.size()) return minHeap.peek();
        return (minHeap.peek() + maxHeap.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */