package Utuls;

import java.util.UUID;

public class RandomPassword {
    public static String generateCode(){
        String uniqueID = UUID.randomUUID().toString();
        String[] parts = uniqueID.split("-");
        return parts[0];
    }
}
