package DividenConquer;

import LinkedList.ListNode;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null) return new ListNode();
        boolean empty = true;
        for (ListNode list : lists) {
            if(list != null) empty = false;
        }
        if(empty) return new ListNode();

        ListNode merged = new ListNode();
        ListNode head = merged;
        ListNode tail = merged;

        boolean hasNext = true;

        while (hasNext) {
            hasNext = false;
            ListNode minNode = null;
            int idx = 0;
            for (int i = 0 ; i < lists.length ; i++) {
                if(lists[i] != null){
                    hasNext = true;
                    if(minNode == null){
                        minNode = lists[i];
                        idx = i;
                    }else if(minNode.val > lists[i].val){
                        minNode = lists[i];
                        idx = i;
                    }
                }
            }

            if(minNode != null){
                System.out.println(minNode.val);
                merged.val = minNode.val;
                lists[idx] = minNode.next;
            }

            if(hasNext){
                tail = merged;
                merged.next = new ListNode();
                merged = merged.next;
            }
        }

        tail.next = null;
        
        return head;
    }
}
