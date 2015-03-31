import org.jibble.pircbot.*;

public class KrakenBot extends PircBot {
    
    public KrakenBot() {
        this.setName("KrakenBot");
    }
    
    public void onMessage(String channel, String sender,
                       String login, String hostname, String message) {
        if (message.equalsIgnoreCase("@time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
        }
        if (message.equalsIgnoreCase("Kraken!")) {
            sendMessage(channel, sender + "!");
        }
        if (message.equalsIgnoreCase("Hello KrakenBot")) {  
            sendMessage(channel, "Hello " + sender);
        }
        if (message.equalsIgnoreCase("KrakenBot!")) {
            sendMessage(channel, sender + ": Hello!");
        }
        if (message.equalsIgnoreCase("KrakenBot?")) {
            sendMessage(channel, sender + ": Yes?");
        }
        if(message.equalsIgnoreCase("@help")){sendMessage(channel, sender + ": I'm PM'ing you a list of my commands.");
    sendMessage(sender, "@time-Used to display time. @help-lists all commands. KrakenBot will respond if you call him and is capable of holding a very basic conversation");
        
        if(message.equalsIgnoreCase("Meet your maker, Krakenbot!")) {
            sendMessage(channel, sender + ": Noo! Don't incur the great Kraken's wrath upon me!");}
        
             
         }
       }
    


