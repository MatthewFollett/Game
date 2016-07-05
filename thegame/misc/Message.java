package thegame.misc;

import java.util.ArrayList;

public class Message {
    public static volatile Message INSTANCE = new Message();
    ArrayList<messagePair> list;
    
    private Message(){
         list = new ArrayList<messagePair>();
    }
    
    public static Message getInstance() {
      synchronized(Message.class) {
        if (INSTANCE == null)
          INSTANCE = new Message();
      }
      return INSTANCE;
   }

    
    public void addMessage(int priority, String message){
        list.add(new messagePair(priority, message));
    }
    
    public String stringMessages(boolean sort){
        String msg = "";
        if(sort){
            messagePair[] listArray = new messagePair[list.size()];
            for(int j = 0; j < listArray.length; j++){
                listArray[j] = list.get(j);
            }
            listArray = sort(listArray);
            for(int i = 0; i < listArray.length; i++){
                msg += (listArray[i]) + "\n\r";
            }
        }
        else{
            for(int i = 0; i < list.size(); i++){
                msg += (list.get(i)) + "\n\r";
            }
        }
        return msg;
    }
    
    public static void clear(){
        INSTANCE = new Message();
    }
    
    public static messagePair[] sort(messagePair[] list){
        messagePair[] left, right, result;
        if(list.length <= 1){
            return list;
        }
        int mid = list.length / 2;
        int i = 0;
        left = new messagePair[mid];
        right = new messagePair[list.length - mid];
        result = new messagePair[list.length];
        for(i = 0; i < mid; i++){
            left[i] = list[i];
        }
        for(int j = 0; i < list.length; i++){
            right[j] = list[i];
            j++;
        }
        left = sort(left);
        right = sort(right);
        result = merge(left, right);
        return result;
    } 
    
    public static messagePair[] merge(messagePair[] left, messagePair[] right){
        messagePair[] result = new messagePair[left.length + right.length];
        int l = 0;
        int r = 0;
        int i = 0;
        while(l < left.length && r < right.length){
            if(left[l].priority < right[r].priority){
                result[i] = left[l];
                l++;
            }
            else{
                result[i] = right[r];
                r++;
            }
            i++;
        }
        while (l < left.length){
            result[i] = left[l];
            l++;
            i++;
        }
        while(r < right.length){
            result[i] = right[r];
            r++;
            i++;
        }
        return result;
    }
    
    private class messagePair{
        public int priority;
        public String message;
        
        public messagePair(int priority, String message){
            this.priority = priority;
            this.message = message;
        }
        
        public String toString(){
            return message;
        }
    }
    
    public static void main(String[] args){
        Message.INSTANCE.addMessage(0, "Test1");
        Message.INSTANCE.addMessage(7, "Test2");
        Message.INSTANCE.addMessage(4, "Test3");
        Message.INSTANCE.addMessage(9, "Test4");
        Message.INSTANCE.addMessage(9, "Test5");
        Message.INSTANCE.addMessage(3, "Test6");
        Message.INSTANCE.addMessage(11, "Test7");
        Message.INSTANCE.addMessage(12, "Test8");
        Message.INSTANCE.addMessage(17, "Test9");
        Message.INSTANCE.addMessage(2, "Test10");
        Message.INSTANCE.addMessage(5, "Test11");
        Message.INSTANCE.addMessage(6, "Test12");
        Message.INSTANCE.addMessage(8, "Test13");
        Message.INSTANCE.addMessage(11, "Test14");
        System.out.println(Message.INSTANCE.stringMessages(true));
        Message.clear();
        System.out.println("TEST2");
        Message.INSTANCE.addMessage(8, "Test13");
        Message.INSTANCE.addMessage(1, "Test14");
        System.out.println(Message.INSTANCE.stringMessages(true));
    }
}
