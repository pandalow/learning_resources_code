package chatService;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* Tool class for Threading management, static ConcurrentHashMap can be shared by all entities.
The following is a series of static methods for adding, deleting, modifying and checking the HashMap.
 */
public class ServerThreadingManagement {
    //Static ConcurrentHashMap, convenient for thread sharing
    private static ConcurrentHashMap<String, ServerThreading> map = new ConcurrentHashMap<>();
    //Add operation
    public static void addMap(String nickName, ServerThreading serverThreading) {
        map.put(nickName, serverThreading);
    }
    //Get the corresponding HashMap
    public static ConcurrentHashMap<String, ServerThreading> getMap() {
        return map;
    }

    //Operations that modify the corresponding nickName
    public static void updateNickName(String oldNickName, String newNickName) {
        if (map.containsKey(oldNickName)) {
            ServerThreading serverThreading = map.remove(oldNickName); // Remove old nickname key-value pairs
            map.put(newNickName, serverThreading); // Use the new nickname as a key to reinsert
        }
    }
    //Get a list of all online users
    public static String getOnlineUser() {
        //set traversal, traversing the key of hashmap
        Iterator<String> iterator = map.keySet().iterator();
        String onlineUserList = "";
        while (iterator.hasNext()) {
            onlineUserList += "<" + iterator.next().toString() + ">" + ",";
        }
        return onlineUserList;
    }
}
