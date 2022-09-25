class MyCircularQueue {
    int[] queue;
    int front, rear;
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.front = -1;
        this.rear = -1;
    }
    
    public boolean enQueue(int value) {
        if(front == -1 && rear == -1){
            front = 0;
        }
        else if(front > rear){
            return false;
        }
        else if(rear - front + 1 == queue.length) return false;
        rear++;
        queue[rear % queue.length] = value;
        return true;
        
    }
    
    public boolean deQueue() {
    
        if(front == -1 && rear == -1) return false;
        else if(front > rear) return false;
        front++;
        if(front > rear){
            front = -1;
            rear = -1;
        }
        return true;
    }
    
    public int Front() {
        if(front == -1 && rear == -1) return -1;
        else if(front > rear) return -1;
        return queue[front % queue.length];
    }
    
    public int Rear() {
        if(front == -1 && rear == -1) return -1;
        else if(front > rear) return -1;
        return queue[rear % queue.length];
    }
    
    public boolean isEmpty() {
        if(front == -1 && rear == -1) return true;
        else if(front > rear) return true;
        return false;
    }
    
    public boolean isFull() {
        if(rear - front + 1 == queue.length) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */