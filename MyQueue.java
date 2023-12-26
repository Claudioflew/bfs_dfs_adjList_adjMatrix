class MyQueue {

  public Node front;
  private Node rear;

  public MyQueue() {
    front = null;
    rear = null;
  } 

  public void enqueue(int c) {
    Node temp = new Node(c);
    if (front == null)
      front = temp;
    else
      rear.next = temp;
    rear = temp;
  }

  public Node dequeue() {
    Node temp = null;
    if (front != null) {
      temp  = front;
      front = front.next;
    }
    return temp;
  } 

  public boolean empty() {
    return front == null;
  }   
}