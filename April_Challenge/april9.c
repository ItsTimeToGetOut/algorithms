bool backspaceCompare(char * S, char * T){
    int sizeS = strlen(S);
    int sizeT = strlen(T);
    char s[sizeS+1];
    char t[sizeT+1];
    int ptr = 0;
    
    for(int i=0;i<sizeS;i++){
        if(S[i]=='#'&&ptr==0) continue;
        else if(S[i]=='#'){s[ptr-1]='\0'; --ptr;}
        else {s[ptr]=S[i]; s[ptr+1]='\0'; ++ptr;}
    }
    ptr=0;
     for(int i=0;i<sizeT;i++){
        if(T[i]=='#'&&ptr==0) continue;
        else if(T[i]=='#'){t[ptr-1]='\0'; --ptr;}
        else {t[ptr]=T[i]; t[ptr+1]='\0'; ++ptr;}
    }
    if(strcmp(s, t)==0) {return true;}
    else {return false;}
    
}