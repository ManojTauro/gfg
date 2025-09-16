/*
class Node{
    int data;
    Node next;
    Node(int a){  data = a; next = null; }
}*/

class Solution {
    public int getCount(Node head) {
        int counter = 0;
        
        if (head == null) return 0;
        
        while (head != null) {
            counter++;
            head = head.next;
        }
        
        return counter;
    }
}