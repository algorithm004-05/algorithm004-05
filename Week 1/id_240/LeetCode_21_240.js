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
    let arrl1 = listToArray(l1)
    let arrl2 = listToArray(l2)
    let resArr = handleArray(arrl1,arrl2)
    return arrayTolist(resArr)
};

function listToArray(list){
    let res = []
    while(list !== null){
        res.push(list.val)
        list = list.next
    }
    return res;
}
function arrayTolist(arr){
    if(!arr.length){
        return null
    }
    let head = {val:arr[0], next:null}
    let pnode = head;
    let node;
    for(let i = 1; i < arr.length; i++){
        node = {val:arr[i],next:null}
        pnode.next = node
        pnode = pnode.next
    }
    return head;
}
function handleArray(arr1,arr2){
    return arr1.concat(arr2).sort((a,b)=>a-b)
}