package netflix.fetchTopMovies;

public class LLNode {
    public int data;
    public LLNode nextNode;

    public LLNode(int data){
        this.data = data;
        this.nextNode = null;
    }

    public LLNode(int data, LLNode nextNode){
        this.data = data;
        this.nextNode = nextNode;
    }
}
