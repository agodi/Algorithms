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
    r_nodes = ugraph.keys()
    conected_components = []
    while len(r_nodes) > 0:
        node = r_nodes[random.randrange(len(r_nodes))]
        v_nodes = bfs_visited(ugraph, node)
        conected_components.append(v_nodes)
        for node in v_nodes:
            r_nodes.remove(node)
    return conected_components


def largest_cc_size(ugraph):
    max_size = None
    conected_components = cc_visited(ugraph)
    for comp in conected_components:
        if not max_size or max_size < len(comp):
            max_size = len(comp)
    return max_size


def compute_resilience(ugraph, attack_order):
    pass