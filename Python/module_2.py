""" This module contains functions to implement bfs,
    compute the set of connected components and the
    resilience of an undirected graph
"""

from collections import deque
import random


def bfs_visited(ugraph, start_node):
    """ Computes the reachable nodes
        in a graph from a given node
    """
    queue = deque()
    visited = set()
    visited.add(start_node)
    queue.append(start_node)
    while len(queue) != 0:
        aux = queue.popleft()
        for node in ugraph[aux]:
            if node not in visited:
                visited.add(node)
                queue.append(node) 
    return visited


def cc_visited(ugraph):
    """ Takes the undirected graph ugraph 
        and returns a list of sets, where 
        each set consists of all the nodes 
        in a connected component, and there 
        is exactly one set in the list for 
        each connected component in ugraph
    """
    r_nodes = set(ugraph.keys())
    conected_components = []
    while len(r_nodes) > 0:
        node = r_nodes.pop()
        v_nodes = bfs_visited(ugraph, node)
        conected_components.append(v_nodes)
        for v_node in v_nodes:
            if v_node in r_nodes:
                r_nodes.remove(v_node)
    return conected_components


def largest_cc_size(ugraph):
    """ Takes the undirected graph ugraph 
        and returns the size (an integer) 
        of the largest connected component 
        in ugraph
    """
    max_size = 0
    conected_components = cc_visited(ugraph)
    for comp in conected_components:
        if not max_size or max_size < len(comp):
            max_size = len(comp)
    return max_size


def compute_resilience(ugraph, attack_order):
    """ Takes the undirected graph ugraph, a 
        list of nodes attack_order and iterates 
        through the nodes in attack_order. 
        For each node in the list, the function 
        removes the given node and its edges from 
        the graph and then computes the size of 
        the largest connected component for the 
        resulting graph.
    """
    resilience_list = [largest_cc_size(ugraph)]
    for node in attack_order:
        ugraph.pop(node)
        for key in ugraph:
            if node in ugraph[key]:
                ugraph[key].remove(node)
        resilience_list.append(largest_cc_size(ugraph))
    return resilience_list