/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var mergeTwoLists = function(l1, l2) {
    if(l1 === null) return l2;
    if(l2 === null) return l1;
    let new_l1 = l1, new_l2 = l2, l3 = new ListNode('head');
    
    while(!(new_l1 ===null && new_l2 ===null)){
        if(!new_l1 || (new_l2 && new_l1.val >= new_l2.val)){
            l3 = listPush(l3, new ListNode(new_l2.val));
            new_l2 = new_l2.next;
        }else{
            l3 = listPush(l3, new ListNode(new_l1.val));
            new_l1 = new_l1.next;
        }
    }
    
    return l3.next;
};


function listPush(list, item) {
    let cur = list
    while(cur.next !== null) {
        cur = cur.next
    }
    cur.next = item
    
    return list
}