# NOTE

## 双向BFS  
```java
void DBFS(){
    queue<state> Q[2];
    vis[2];
    Q[0].push;Q[1].push();
    vis[0]=vis[1]=1;
    int deep=0;
    while(!Q[0].empty()||!Q[1].empty()){
        int i=0;
        while(i<2){
            state tp=Q[i].front();
            if(tp.step!=deep){i++;continue;}
            Q[i].pop();
            for(.....)
            if(vis[1-i]) {cout<<(deep*2+i+1)<<endl;return;
            if(vis[i]) continue;
            Q[i].push();
            vis[i]=1;
            }
        }
    deep++;
    }
}
```