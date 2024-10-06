import java.util.Stack;

class QueueUsingStacks {
    private Stack<Integer> stack1; // For enqueue operations
    private Stack<Integer> stack2; // For dequeue operations

    // Constructor to initialize the stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Method to add an element to the queue
    public void enqueue(int value) {
        stack1.push(value);
    }

    // Method to remove an element from the queue
    public int dequeue() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Move elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Method to get the front element of the queue without removing it
    public int front() {
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new RuntimeException("Queue is empty");
            }
            // Move elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        
        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element: " + queue.front()); // Output: 1

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 1
        System.out.println("Front element: " + queue.front()); // Output: 2

        // Dequeue remaining elements
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 2
        System.out.println("Dequeued: " + queue.dequeue()); // Output: 3

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: true
    }
}
