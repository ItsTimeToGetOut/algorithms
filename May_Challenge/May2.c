int numJewelsInStones(char * J, char * S){
    short a=0;
    for(short i=0;S[i]!='\0';++i){
        for(short j=0; J[j]!='\0';++j)if(S[i]==J[j])++a;
    }
    return a;
}