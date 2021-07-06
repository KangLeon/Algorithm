/*
 * @Author: your name
 * @Date: 2021-07-06 17:51:53
 * @LastEditTime: 2021-07-06 18:51:41
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /Graph/src/Graph/ListGraph.java
 */
package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@SuppressWarnings("unchecked")
public class ListGraph<V,E> implements Graph<V,E> {
    private Map<V,Vertex<V,E>> vertices = new HashMap<>();

    private static class Vertex<V,E> {
        V value;
        Set<Edge<V,E>> inEdges = new HashSet<>();
        Set<Edge<V,E>> outEdges = new HashSet<>();
        public Vertex(V value){
            this.value = value;
        }
        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return value == null ? 0 : value.hashCode();
        }
    }

    private static class Edge<V,E>{
        Vertex<V,E> from;
        Vertex<V,E> to;
        E weight;

        public Edge(Vertex<V,E> from,Vertex<V,E> to){
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object obj) {
            // TODO Auto-generated method stub
            Edge<V,E> edge = (Edge<V,E>)obj;
            boolean result = Objects.equals(from, edge.from)&&Objects.equals(to, edge.to);
            return result;
        }
        @Override
        public int hashCode() {
            // TODO Auto-generated method stub
            return from.hashCode() + to.hashCode();
        }
        
        
    }

    @Override
    public int edgeSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int verticesSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addVertex(V v) {
        // TODO Auto-generated method stub
        if(vertices.containsKey(v))return;
        vertices.put(v, new Vertex<>(v));
    }

    @Override
    public void addEdge(V from, V to) {
        // TODO Auto-generated method stub
        this.addEdge(from, to, null);
    }

    @Override
    public void addEdge(V from, V to, E weight) {
        // TODO Auto-generated method stub
         Vertex<V,E> fromVertex = vertices.get(from);
         if(fromVertex == null){
             fromVertex = new Vertex<>(from);
             vertices.put(from, fromVertex);
         }

         Vertex<V,E> toVertex = vertices.get(to);
         if(toVertex == null){
            toVertex = new Vertex<>(to);
             vertices.put(to, toVertex);
         }

         Edge<V,E> edge = new Edge<>(fromVertex,toVertex);
         edge.weight = weight;

         fromVertex.outEdges.remove(edge);
         toVertex.inEdges.remove(edge);

         fromVertex.outEdges.add(edge);
         toVertex.inEdges.add(edge);
    }

    @Override
    public void removeVertex(V v) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeEdge(V from, V to) {
        // TODO Auto-generated method stub
        
    }
}
