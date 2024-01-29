class MyQueue {
    int[] s1;
    int[] s2;
    int t1 = -1, t2 = -1;
    public MyQueue() {
        this.s1 = new int[10];
        this.s2 = new int[10];
        t1 = -1; t2 = -1;
    }
    
    public void push(int x) {
        if(t1 == 9)
            while(t2 <= 9)
                s2[++t2] = s1[t1--];
        s1[++t1] = x;
    }
    
    public int pop() {
         if(t2 == -1)
            while(t1 != -1) 
                s2[++t2] = s1[t1--];
        return s2[t2--];
    }
    
    public int peek() {
        if(t2 == -1)
            while(t1 != -1) 
                s2[++t2] = s1[t1--];
        return s2[t2];
    }
    
    public boolean empty() {
        return (t1==-1 && t2 == -1);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */