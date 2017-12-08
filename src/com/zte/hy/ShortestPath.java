package com.zte.hy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * 寻找题目要求的最短路径
 * @author hy
 *
 */
public class ShortestPath {

	/**
	 * 寻找题目要求的最短路径
	 * @param g 图
	 * @param road1 必经路径1
	 * @param road2 必经路径2
	 * @param node 必经结点
	 * @param source 源结点
	 * @param finallyDest 最终目的
	 * @param anteater 不能经过的路径
	 */
	public static void findPath(Graph g,int[] road1,int[] road2,int[] node,int source,int finallyDest,int[] anteater){
		
		ArrayList<Integer> arrNode = new ArrayList<Integer>();
		
		//禁止走的路径定义为0
		g.matrix[anteater[0]][anteater[1]] = 0;
		g.matrix[anteater[1]][anteater[0]] = 0;
		
		if(!arrNode.contains(new Integer(road1[0])))
			arrNode.add(road1[0]);
		if(!arrNode.contains(new Integer(road1[1])))
			arrNode.add(road1[1]);
		if(!arrNode.contains(new Integer(road2[0])))
			arrNode.add(road2[0]);
		if(!arrNode.contains(new Integer(road2[1])))
			arrNode.add(road2[1]);
		if(!arrNode.contains(new Integer(node[0])))
			arrNode.add(node[0]);
		if(!arrNode.contains(new Integer(node[1])))
			arrNode.add(node[1]);
		
		//把最终路径放在result中
		ArrayList<Integer> result = new ArrayList<Integer>();
		boolean[] visited = new boolean[g.n];
		int[] dist = new int[g.n];
		HashMap<Integer,Integer> path = new HashMap<Integer,Integer>();
		
		//找出源结点到必经结点的最近结点
		new Dijkstra().doDijkstra(g,dist,path,road1,road2,node,source,visited);
		int index = 0;
		int dest = findShortestNode.findNode(dist, arrNode, road1, road2, visited);index++;index++;
		arrNode.remove(new Integer(dest));
		Stack<Integer> s = new Stack<>();
		new Dijkstra().showPath(path, dest, source,s);
		while(!s.isEmpty()){
			result.add(s.pop());
		}
		 
		//把所有必经结点和必经路径以最短路径优先加入最终路径result
		while(!arrNode.isEmpty()){
			visited = new boolean[g.n];
			path = new HashMap<Integer,Integer>();
			dist = new int[g.n];

			new Dijkstra().doDijkstra(g,dist,path,road1,road2,node,result.get(result.size()-1),visited);
			s = new Stack<>();
			dest = findShortestNode.findNode(dist, arrNode, road1, road2, visited);
			arrNode.remove(new Integer(dest));
		
			new Dijkstra().showPath(path, dest, result.get(result.size()-1),s);
			if(!s.isEmpty())s.pop();
			while(!s.isEmpty()){
				result.add(s.pop());
			}

		}
		
		visited = new boolean[g.n];
		path = new HashMap<Integer,Integer>();
		dist = new int[g.n];
		//计算必经路径和必经结点最后加入路径的结点到最终结点的路劲
		new Dijkstra().doDijkstra(g,dist,path,road1,road2,node,result.get(result.size()-1),visited);
		s = new Stack<>();
		new Dijkstra().showPath(path, finallyDest, result.get(result.size()-1),s);
		if(!s.isEmpty())s.pop();
		while(!s.isEmpty()){
			result.add(s.pop());
		}
		index=0;
		
		//打印最终路径
		if(result.size()<=9){
			System.out.println("最优路径为:");
		}else{
			System.out.println("未找到最优路径，最短路径优先:");
		}
		
		while(index!=result.size()-1)
		{
			System.out.print(result.get(index++)+"-->");
		}
		System.out.println(result.get(index));
		
		//打印最短距离
		System.out.println("最短距离（即最小花费）:");
		int distence =0;
		for(int i=0;i<result.size()-1;i++){
			distence+=g.matrix[result.get(i)][result.get(i+1)];
		}
		System.out.println(distence);
	}
	

}
