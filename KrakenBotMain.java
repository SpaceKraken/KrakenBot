import org.jibble.pircbot.*;

public class KrakenBotMain {
    
    public static void main(String[] args) throws Exception {
        
        // Now start our bot up.
        KrakenBot bot = new KrakenBot();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.esper.net");

        // Join the #pircbot channel.
        bot.joinChannel("#kspmodders");
        
        bot.joinChannel("#bottorture");
        
        bot.joinChannel("#kspofficial");
        
        
    }
    
}