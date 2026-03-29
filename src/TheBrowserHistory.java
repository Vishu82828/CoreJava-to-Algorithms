public class TheBrowserHistory {
    public static void main(String[] args) {
        HistoryStack browser = new HistoryStack();

        browser.push("google.com 01");
        browser.push("github.com 02");
        browser.push("linkedin.com 03");

        System.out.println("Back button pressed: " + browser.pop());
        System.out.println("Back button pressed: " + browser.pop());

        PrintJobQueue queue = new PrintJobQueue();
        queue.enqueue("doc 01");
        queue.enqueue("doc 02");
        queue.enqueue("doc 03");

        System.out.println("Print Document : " + queue.dequeue());
    }
}
class History{
    String url;
    History next;
    public History(String url){
        this.url = url;
        this.next = null;
    }
}
class HistoryStack{
    History top;
    public void push(String url){
        History newHistory = new History(url);
        newHistory.next = top;
        top = newHistory;
        System.out.println("History pushed");
    }
    public String pop(){
        if (top == null) {return "No history to go back to.";}
        String url = top.url;
        top = top.next;
        return url;
    }
}
// The Queue Logic ---
class PrintJob{
    String documentName;
    PrintJob next;
    public PrintJob(String documentName){
        this.documentName = documentName;
        this.next = null;
    }
}
class PrintJobQueue{
    PrintJob front;
    PrintJob rear;
    public void enqueue(String documentName){
        PrintJob newJob = new PrintJob(documentName);
        if(front == null || rear == null){
            front = rear = newJob; // front and rear both are = null.
            return;
        }
        rear.next = newJob;
        rear = newJob;
        System.out.println("PrintJob enqueued: " + documentName);
    }
    public String dequeue(){
        if(front == null){return "No history to go back to.";}
        String documentName = front.documentName;
        front = front.next;
        if(front == null){
            rear = null;
        }
        return documentName;
    }
}