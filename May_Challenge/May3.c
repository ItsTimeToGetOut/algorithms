bool canConstruct(char * ransomNote, char * magazine){
    bool flag = false;
    for(int i=0;ransomNote[i]!='\0';++i){
       for(int j=0;magazine[j]!='\0'; ++j)if(ransomNote[i]==magazine[j]){
           flag=true; magazine[j]=' '; break;}else flag = false;
        if(!flag)break;
    }
    if(ransomNote[0]=='\0')return true; else
    return flag;
}