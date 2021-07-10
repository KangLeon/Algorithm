/*
 * @Author: your name
 * @Date: 2021-07-06 17:51:53
 * @LastEditTime: 2021-07-10 16:27:41
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /Graph/src/Graph/ListGraph.java
 */
package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class ListGraph<V,E> extends Graph<V,E> {
    public ListGraph(WeightManager<E> weightManager) {
        super(weightManager);
        //TODO Auto-generated constructor stub
    }

    private Map<V,Vertex<V,E>> vertices = new HashMap<>();
    private Set<Edge<V,E>> edges = new HashSet<>();
    private Comparator<Edge<V,E>> edgeComparator = (Edge<V,E> e1,Edge<V,E> e2) -> {
        return weightManager.compare(e1.weight, e2.weight);
    };

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
        public Vertex(V value,Set<Edge<V,E>> inEdges,Set<Edge<V,E>> outEdges){
            super();
            this.value = value;
            this.inEdges = inEdges;
            this.outEdges = outEdges; 
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

        EdgeInfo<V, E> info() {
			return new EdgeInfo<>(from.value, to.value, weight);
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

         if(fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
         }

         fromVertex.outEdges.add(edge);
         toVertex.inEdges.add(edge);
         edges.add(edge);
    }

    /**
     * @description: 删除顶点
     * @param {*}
     * @return {*}
     */    
    @Override
    public void removeVertex(V v) {
        // TODO Auto-generated method stub
        Vertex<V,E> vertex = vertices.remove(v);
        if(vertex == null) return;

        for(Iterator<Edge<V,E>> iterator = vertex.outEdges.iterator();iterator.hasNext();){
            Edge<V,E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            //将当前遍历到的元素edge从集合vertex.outEdges中删掉
            iterator.remove();
            edges.remove(edge);
        }

        for(Iterator<Edge<V,E>> iterator = vertex.inEdges.iterator();iterator.hasNext();){
            Edge<V,E> edge = iterator.next();
            edge.to.inEdges.remove(edge);
            //将当前遍历到的元素edge从集合vertex.outEdges中删掉
            iterator.remove();
            edges.remove(edge);
        }
    }

    /**
     * @description: 删除边
     * @param {*}
     * @return {*}
     */    
    @Override
    public void removeEdge(V from, V to) {
        // TODO Auto-generated method stub
        Vertex<V,E> fromVertex = vertices.get(from);
        if(fromVertex == null) return;

        Vertex<V,E> toVertex = vertices.get(to);
        if(toVertex == null) return;

        Edge<V,E> edge = new Edge<>(fromVertex,toVertex);
        if(fromVertex.outEdges.remove(edge)){
            toVertex.inEdges.remove(edge);
            edges.remove(edge);
        }
    }

    /**
     * @description: 广度优先搜索
     * @param {*}
     * @return {*}
     */    
    @Override
    public void bfs(V begin,VertexVisitor<V> visitor) {
        // TODO Auto-generated method stub
        Vertex<V,E> beginVertex = vertices.get(begin);
        if(beginVertex == null) return;

        Set<Vertex<V,E>> visitedVertices = new HashSet<>();
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        queue.offer(beginVertex);
        visitedVertices.add(beginVertex);

        while(!queue.isEmpty()){
            Vertex<V,E> vertex = queue.poll();
            if(visitor.visit(vertex.value)) return;

            for(Edge<V,E> edge : vertex.outEdges){
                if(visitedVertices.contains(edge.to)) continue;
                queue.offer(edge.to);
                visitedVertices.add(edge.to);
            }
        }
    }

    /**
     * @description: 非递归版的深度优先搜索
     * @param {*}
     * @return {*}
     */    
    @Override
    public void dfs(V begin,VertexVisitor<V> visitor) {
        // TODO Auto-generated method stub
        if(visitor == null) return;
        Vertex<V,E> beginVertex = vertices.get(begin);
        if(beginVertex == null) return;

        Set<Vertex<V,E>> visitedVertices = new HashSet<>();
        Stack<Vertex<V,E>> stack = new Stack<>();

        //先访问起点
        stack.push(beginVertex);
        visitedVertices.add(beginVertex);
        if(visitor.visit(begin)) return;

        while(!stack.isEmpty()){
            Vertex<V,E> vertex = stack.pop();

            for(Edge<V,E> edge : vertex.outEdges){
                if(visitedVertices.contains(edge.to)) continue;

                stack.push(edge.from);
                stack.push(edge.to);
                visitedVertices.add(edge.to);
                if(visitor.visit(edge.to.value)) return;

                break;
            }
        }
    }

    // /**
    //  * @description: 递归版的深度优先搜索
    //  * @param {*}
    //  * @return {*}
    //  */    
    // @Override
    // public void dfs(V begin) {
    //     // TODO Auto-generated method stub
    //     Vertex<V,E> beginVertex = vertices.get(begin);
    //     if(beginVertex == null) return;
        
    //     dfs(beginVertex,new HashSet<>());
    // }

    // private void dfs(Vertex<V,E> vertex,Set<Vertex<V,E>> visitedVertices){
    //     System.out.println(vertex.value);
    //     visitedVertices.add(vertex);

    //     for(Edge<V,E> edge : vertex.outEdges) {
    //         if(visitedVertices.contains(edge.to)) continue;
    //         dfs(edge.to,visitedVertices);
    //     }
    // }

    /**
     * @description: 拓扑排序
     * @param {*}
     * @return {*}
     */    
    @Override
    public List<V> topologicalSort() {
        List<V> list = new ArrayList<>(); 
        Queue<Vertex<V,E>> queue = new LinkedList<>();
        Map<Vertex<V,E>,Integer> ins = new HashMap<>(); 
        //初始化（将度为0的节点都放入队列）
        vertices.forEach((V v,Vertex<V,E> vertex)-> {
            int in  = vertex.inEdges.size();
            if(in == 0){
                queue.offer(vertex);
            }else{
                ins.put(vertex, in);
            }
        });

        while(!queue.isEmpty()){
            Vertex<V,E> vertex = queue.poll();
            //放入返回结果中
            list.add(vertex.value);

            for(Edge<V,E> edge : vertex.outEdges){
                int toIn = ins.get(edge.to)-1;
                if(toIn == 0){
                    queue.offer(edge.to);
                }else{
                    ins.put(edge.to, toIn);
                }
            }
        }

        return list;
    }

    @Override
    public Set<EdgeInfo<V, E>> mst() {
        // TODO Auto-generated method stub
        return prim();
    }

    /**
     * @description: prim算法求最小生成树 
     * @param {*}
     * @return {*}
     */    
    private Set<EdgeInfo<V,E>> prim() {
        Iterator<Vertex<V,E>> it = vertices.values().iterator();
        if(!it.hasNext()) return null;  

        Set<EdgeInfo<V,E>> edgeInfos = new HashSet<>();
        Set<Vertex<V,E>> addedVertices = new HashSet<>();

        Vertex<V,E> vertex = it.next();
        addedVertices.add(vertex);
        MinHeap<Edge<V,E>> heap = new MinHeap<>(vertex.outEdges,edgeComparator);

        int edgeSize = vertices.size() - 1;
        while(!heap.isEmpty()&&edgeInfos.size() < edgeSize){
            Edge<V,E> edge = heap.remove();
            if(addedVertices.contains(edge.to)) continue;

            edgeInfos.add(edge.info());
            addedVertices.add(edge.to);
            heap.addAll(edge.to.outEdges);
        }        

        return edgeInfos;
    }

    /**
     * @description: kruskal算法求最小生成树
     * @param {*}
     * @return {*}
     */    
    private Set<EdgeInfo<V,E>> kruskal() {

        int edgeSize = vertices.size() - 1;
        if(edgeSize == -1) return null;

        Set<EdgeInfo<V,E>> edgeInfos = new HashSet<>();

        MinHeap<Edge<V,E>> heap = new MinHeap<>(edges,edgeComparator);
        UnionFind<Vertex<V,E>> uf = new UnionFind<>();

        vertices.forEach((V v,Vertex<V,E> vertex) -> {
            uf.makeSet(vertex);
        });

        while(!heap.isEmpty()&&edgeInfos.size() < edgeSize){
            Edge<V,E> edge = heap.remove();
            if(uf.isSame(edge.from, edge.to)) continue;

            edgeInfos.add(edge.info());
            uf.union(edge.from, edge.to);
        }

        return edgeInfos;
    }
}
