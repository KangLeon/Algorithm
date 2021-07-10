/*
 * @Author: your name
 * @Date: 2021-07-06 17:00:49
 * @LastEditTime: 2021-07-10 18:12:48
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /Graph/src/Graph/Graph.java
 */
package Graph;

import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class Graph<V,E> {
    protected WeightManager<E> weightManager;
    public Graph(WeightManager<E> weightManager){
        this.weightManager = weightManager;
    }
    public abstract int edgeSize();
    public abstract int verticesSize();

    public abstract void addVertex(V v);
    public abstract void addEdge(V from,V to);
    public abstract void addEdge(V from,V to,E weight);

    public abstract void removeVertex(V v);
    public abstract void removeEdge(V from,V to);

    public abstract void bfs(V begin,VertexVisitor<V> visitor);
    public abstract void dfs(V begin,VertexVisitor<V> visitor);

    //条件是必须是有向无环图
    public abstract List<V> topologicalSort();

    //最短路径值
    public abstract Map<V,E> shortestPath(V begin);

    public abstract Set<EdgeInfo<V,E>> mst();//最小生成树
 
    public interface WeightManager<E>{
        int compare(E w1,E w2);
        E add(E w1,E w2);
    }
 
    public interface VertexVisitor<V> {
        boolean visit(V v);
    }

    public static class EdgeInfo<V,E> {
        V from;
        V to;
        E weight;
        public EdgeInfo(V from,V to,E weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
