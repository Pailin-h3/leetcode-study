package LinkedList;

public class MergeTwoList {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merged = new ListNode();
        ListNode head = merged;

        while(list1 != null || list2!= null){
            if(list1 != null && list2 != null){
                if(list1.val >= list2.val){
                    System.out.println("Use list1 because it's lower");
                    merged.val = list1.val;
                    list1 = list1.next;
                }else{
                    System.out.println("Use list2 because it's lower");
                    merged.val = list2.val;
                    list2 = list2.next;
                }
            }else if(list1 == null){
                System.out.println("Use list2 because list1 is null");
                merged.val = list2.val;
                list2 = list2.next;
            }else{
                System.out.println("Use list1 because list2 is null");
                merged.val = list1.val;
                list1 = list1.next;
            }

            if(list1 != null || list2!= null){
                merged.next = new ListNode();
                merged = merged.next;
            }
        }

        return head;
    }
}
