/*
 * @Author: your name
 * @Date: 2021-07-06 17:00:49
 * @LastEditTime: 2021-07-09 16:47:51
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /Graph/src/Graph/Graph.java
 */
package Graph;

import java.util.List;

public interface Graph<V,E> {
    int edgeSize();
    int verticesSize();

    void addVertex(V v);
    void addEdge(V from,V to);
    void addEdge(V from,V to,E weight);

    void removeVertex(V v);
    void removeEdge(V from,V to);

    void bfs(V begin,VertexVisitor<V> visitor);
    void dfs(V begin,VertexVisitor<V> visitor);

    //条件是必须是有向无环图
    List<V> topologicalSort();
 
    interface VertexVisitor<V> {
        boolean visit(V v);
    }
}
