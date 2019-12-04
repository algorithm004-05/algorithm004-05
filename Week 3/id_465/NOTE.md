# NOTE

## DFS通用模板
```Python
visited=set()

def dfs(node,visited):
    # terminator
    if node in visited:
        # node already visited
        return

    visited.add(node)

    # prcess current node here
    

    # drill down
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node,visited)
```

## BFS通用模板
```Python
def bfs(graph,start,end):
    queue=[]
    queue.append([start])
    visited.add(start)

    while queue:
        node=queue.pop()
        visited.add(node)

        process(node)
        nodes=generate_related_node(node)
        queue.push(nodes)
```
```Java
public void BFS(Object start,Object end){
    Queue<Pair<Object,Integer>> q=new LinkedList<Pair<Object,Integer>>();
    q.offer(new Pair<Object,Integer>(start,1));

    HashMap<Object,Boolean> visited=new HashMap<Object,Boolean>();
    visited.put(start,true);

    while(!q.isEmpty()){
        Pair<Object,Integer> node=q.remove();
        Object entity=node.getKey();
        Integer level=node.getValue();
        visited.put(entity,true)

        //process

        node=get_last_node();
        q.offer(node);
    }
}

```