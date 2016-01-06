package chapter4;

import java.util.LinkedList;
import java.util.Queue;

import util.GraphNode;

public class ConnectedNodes {
	
	public static boolean areConnected(GraphNode<Integer> nodeA, 
			GraphNode<Integer> nodeB) {
		Queue<GraphNode<Integer>> queue = new LinkedList<GraphNode<Integer>>();
		queue.add(nodeA);
		
		while (!queue.isEmpty()) {
			GraphNode<Integer> node = queue.poll();
			if (node.isVisited) continue;
			if (node == nodeB) return true;
			node.isVisited = true;
			for (GraphNode<Integer> n : node.adjacentNodes) {
				queue.add(n);
			}
		}
			
		return false;
	}

	public static void main(String[] args) {
		GraphNode<Integer> nodeA = new GraphNode<Integer>(0);
		GraphNode<Integer> nodeB = new GraphNode<Integer>(1);
		GraphNode<Integer> nodeC = new GraphNode<Integer>(2);
		GraphNode<Integer> nodeF = new GraphNode<Integer>(3);
		GraphNode<Integer> nodeG = new GraphNode<Integer>(4);
		GraphNode<Integer> nodeH = new GraphNode<Integer>(5);
		
		nodeA.add(nodeC);
		nodeB.add(nodeG);
		nodeC.add(nodeB);
		nodeF.add(nodeH);
		nodeG.add(nodeF);
		
		System.out.println(areConnected(nodeA, nodeH));
	}

}
