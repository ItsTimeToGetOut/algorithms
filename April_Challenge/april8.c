/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* middleNode(struct ListNode* head){
    int a = 0;
    int i = 0;
    struct ListNode* node = head;
    struct ListNode* temp = head;
    while(1){
        if(node->next==NULL){
            int b =a%2!=0?((a/2)+1):(a/2);
            while(i<(b)){
                temp=temp->next;
                ++i;
            }
            return temp;
        }
         node = node->next;
          ++a;
    }
    return NULL;

}