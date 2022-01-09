package netflix.fetchTopMovies;

import java.util.Arrays;

public class LL {

    public LLNode head;
    public int size;

    public LL(){
        this.head = null;
        this.size = 0;
    }

    public LLNode insert(int data){
        LLNode newNode = new LLNode(data);

        if(this.head == null){
            this.head = newNode;
            this.size++;
            return newNode;
        }

        LLNode currentNode = this.head;

        while(currentNode.nextNode != null){
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = newNode;
        this.size++;
        return newNode;
    }

    public void printLL(){
        int[] listHolder = new int[this.size];
        LLNode currentNode = this.head;
        int x = 0;
        while(currentNode != null && x < this.size){
            listHolder[x] = currentNode.data;
            currentNode = currentNode.nextNode;
            x++;
        }
        System.out.println(Arrays.toString(listHolder));
    }
}
