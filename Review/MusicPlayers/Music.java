package MusicPlayers;
public class Music {
     public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer(); 
        player.addMedia("Song A");
        player.addMedia("Song B");
        player.addMedia("Song C");
        System.out.println(player.playNext("Song A"));
    }
}
