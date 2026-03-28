public class SmartPlaylist {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addAtEnd("Song A","AR Rahman");
        playlist.addAtEnd("Song B","AR Sweta");
        playlist.addAtStart("Song C","AR Jaishree");
        playlist.addAtEnd("Song D","AR Sana");
        playlist.Display();
        playlist.deleteByTitle("Song B");
        playlist.Display();
    }
}
class Song{
    String title;
    String artist;
    Song next;
    public Song(String title, String artist){
        this.title = title;
        this.artist = artist;
        this.next = null;
    }
}
class Playlist{
    Song head;
    public void addAtEnd(String title, String artist){
        Song newSong = new Song(title,artist);
        if(head == null){
            head = newSong;
            return;
        }
        Song temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newSong;
    }
    public void addAtStart(String title, String artist){
        Song temp = new Song(title,artist);
        temp.next = head;
        head = temp;
    }
    public void deleteByTitle(String targetTitle){
        if(head == null){ return;}
        else if(head.title.equals(targetTitle)){
            head = head.next;
        } else {
            Song temp = head;
            while (temp.next != null) {
                if(temp.next.title.equals(targetTitle)){
                    temp.next = temp.next.next;
                    return;
                }
                temp = temp.next;
            }
        }
    }
    public void Display(){
        Song temp = head;
        while(temp != null){
            System.out.println(temp.title + " - " + temp.artist);
            temp = temp.next;
        }
        System.out.println("--------------------");
    }
}