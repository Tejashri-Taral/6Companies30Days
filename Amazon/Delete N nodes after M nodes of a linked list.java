class Solution {
    static void linkdelete(Node head, int n, int m) {
        // your code here
        if(head==null) return;
        Node curr=head;
        int count=0;
        while(curr!=null && curr.next!=null) {
            count++;
            int x=n;
            if(count==m) {
                while(x>0) {
                curr.next=curr.next.next;
                if(curr.next==null) {
                    return;
                  }
                  x--;
                }
                count=0;
                x=n;
            }
            curr=curr.next;
        }
    }
}
