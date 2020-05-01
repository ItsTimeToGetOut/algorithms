/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2){
    struct ListNode* tmp1=l1;
    struct ListNode* tmp2=l2;
    int ans;
    int a=0;
    int b=0;
    int c = 1;
    while(tmp1!=NULL || tmp2!=NULL){
        if(tmp1){int t = tmp1->val; a=a+(t*c); printf("%d \n",t);tmp1=tmp1->next;}
        if(tmp2){int t = tmp2->val; b=b+(t*c); printf("%d \n",t);tmp2=tmp2->next;}
        c=c*10;
    }
    ans=a+b;
    tmp1=l1;
    while(ans>0){
        struct ListNode* new = (struct ListNode *)malloc(sizeof(struct ListNode));
        new->next=NULL;
        new->val=(ans%10);
        l1->next=new;
        l1=l1->next;
        ans=ans/10;
    }
    return tmp1->next;
}