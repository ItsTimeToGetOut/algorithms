int firstBadVersion(int n) {
    for(int i= n; i>0 ; i--){
        if(isBadVersion(i))continue;
        else return i+1;
    }
    return 1;
    
}