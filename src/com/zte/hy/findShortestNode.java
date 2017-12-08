package com.zte.hy;

import java.util.ArrayList;

/**
 * 找到里当前节点最近的必经结点或路径
 * @author hy
 *
 */
public class findShortestNode {
	
	/**
	 * 
	 * @param dist 记录距离
	 * @param arrNode 所有必经路径和必经结点所构成的结点数组
	 * @return 返回距离当前节点最近的必经结点
	 */
	public static int findNode(int[] dist,ArrayList<Integer> arrNode){
		int min = Integer.MAX_VALUE;
		for(Integer item:arrNode){
			if(dist[item]<min){
					min = item;
			}
		}
		return min;
	}
	
	/**
	 * 
	 * @param dist 记录距离
	 * @param arrNode 所有必经路径和必经结点所构成的结点数组
	 * @param road1 必经路径1
	 * @param road2 必经路径2
	 * @param visited
	 * @return 返回距离当前节点最近的必经结点
	 */
	public static int findNode(int[] dist,ArrayList<Integer> arrNode,int[] road1,int[] road2,boolean[] visited){
		int min = arrNode.get(0);
		for(Integer item:arrNode){
			 if(dist[item]<dist[min]){
				 min = item;
			}
		}
		if(min==road1[0]){
			arrNode.remove(new Integer(min));
			min = road1[1];
			
		}
		else if(min==road1[1]){
			arrNode.remove(new Integer(min));
				min = road1[0];
				
		}
		else if(min==road2[0]){
			arrNode.remove(new Integer(min));
				min = road2[1];
		}
		else if(min==road2[1]){
			arrNode.remove(new Integer(min));
				min = road2[0];
		}
		return min;
	}
}
