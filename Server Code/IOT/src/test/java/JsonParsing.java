import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;


public class JsonParsing {
public static void main(String[] args) {
// String st="{\"auth\": {\"sessionId\":\"************************\"},\"data\": {\"command\": \"method.exec\",\"params\": { \"ackTimeout\": 30,\"method\":\"aa_enable_key\",\"params\": { \"aa_enable_var_key\": false},\"singleton\": false, \"thingKey\": \"357164041279590\"}}}";
String st="{\"auth\": {\"sessionId\":\"************************\"},\"data\": {\"command\": \"method.exec\"},\"params\": { \"ackTimeout\": 30,\"method\":\"aa_enable_key\"},\"params\": { \"aa_enable_var_key\": false},\"singleton\": false, \"thingKey\": \"357164041279590\"}}}";


String st2="{\"3\": {\"state\": {\"on\": false,\"bri\": 254,\"hue\": 35625,\"sat\": 118,\"effect\": \"none\",\"xy\": [0.3413, 0.3389],\"ct\": 192,\"alert\": \"select\",\"colormode\": \"xy\",\"reachable\": false},\"type\": \"Extended color light\",\"name\": \"Bedroom\",\"modelid\": \"LCT001\",\"manufacturername\": \"Philips\",\"uniqueid\": \"00:17:88:01:00:f6:70:b8-0b\",\"swversion\": \"5.23.1.13187\"}}";
 JSONObject firstJSONObject;
 try {
  firstJSONObject = new JSONObject(st2);
  Iterator keysToCopyIterator = firstJSONObject.keys();
  List<String> keysList = new ArrayList<String>();
  while(keysToCopyIterator.hasNext()) {
      String key = (String) keysToCopyIterator.next();
      keysList.add(key);
  }
  
  System.out.println(  keysList.get(0));
   System.out.println("======"+keysList);
  String[] keysArray = keysList.toArray(new String[keysList.size()]);
  System.out.println("-----------"+keysArray.getClass().getName().charAt(1));
 } catch (JSONException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
 }
 
//JSONObject secondJSONObject = new JSONObject(keysList);
}
}