
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }



 * /*
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted linked list:
 * 1->1->2->3->4->4->5->6
 *
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 *
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 *
 * Constraints:
 *
 *     k == lists.length
 *     0 <= k <= 104
 *
 *
 */


import java.util.PriorityQueue;

public class MergeKlists {

    // ListNode definition
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }



    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );

        // Insert first nodes of each list
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Build merged list
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKlists mk = new MergeKlists();
        ListNode head = mk.mergeKLists(new ListNode[1]);
        System.out.println(head);
    }
}


