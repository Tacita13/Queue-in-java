/*
 This is a program designed to generate a generic Queue that stores elements of
 any types base on the FIFO principle.
 */
package queue;

/**
 *
 * @author Isamar
 * @param <T>
 */
public class Queue<T> {
//head stores the first element of the list.
    private Node<T> head;
//Clase Node was implemented for better managed of the list.
    public class Node<T> {
// Elements stands for every other element. Next stands for the following 
// element on the list.

        T Element;
        Node next;

        public Node() {
            next = null;
        }

        public Node(T Element) {
            this.Element = Element;
        }

        @Override
        public String toString() {
            return Element + "";
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node N) {
            next = N;
        }
    }

//Constructor creates an empty Queue
    public Queue() {
        head = null;
    }

    //#1 Method: Adds a new element to the Queue.
    public void add(T newElement) {
        Node QueueTemp = new Node(newElement);
        if (head == null) {
            head = QueueTemp;
        } else {
            Node QueueCurrent = head;
            while (QueueCurrent.getNext() != null) {
                QueueCurrent = QueueCurrent.getNext();
            }
            QueueCurrent.setNext(QueueTemp);
        }
    }
//#2 Method: Removes the first element of the Queue.

    public Node remove() {
        head = head.next;
        return head;
    }

//#3 Method: Presents the elements of the Queue divided by commas as a String.
//Additionally tells if the Queue is empty.
    @Override
    public String toString() {
        Node i = head;
        String totalValue = "";
        if (isEmpty()) {
            return "List is empty";
        }
        while (i.getNext() != null) {
            totalValue += (i + ", ");
            i = i.getNext();
        }
        totalValue += (i);
        return totalValue;
    }

//#4: Method: Throws true if the Queue is empty.
    public boolean isEmpty() {
        return (head == null);
    }

//Main cointains the following examples the demosntrate the different functions
//of the Queue.
    public static void main(String[] args) {
        Queue list = new Queue();
        list.add('a');
        list.add(2);
        list.add(1.1);
        list.add("Hell yeah!");
        list.add(false);
        System.out.println(list);
        list.remove();
        System.out.println(list);
    }
}
