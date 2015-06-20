""" This module contains basic functions to create
    complete graphs as well as computing the in degrees
    and degree distribution of a given graph """

EX_GRAPH0 = {0: set([1,2]), 1: set([]), 2: set([])}

EX_GRAPH1 = {0:set([1,5,4]),
             1:set([2,6]),
             2:set([3]),
             3:set([0]),
             4:set([1]),
             5:set([2]),
             6:set([])}

EX_GRAPH2 = {0:set([1,5,4]),
             1:set([2,6]),
             2:set([3,7]),
             3:set([7]),
             4:set([1]),
             5:set([2]),
             6:set([]),
             7:set([3]),
             8:set([1,2]),
             9:set([0,4,5,6,7,3])}

def make_complete_graph(num_nodes):
    """ Function that takes the number
        of nodes num_nodes and returns 
        a dictionary corresponding to
        a complete directed graph with
        the specified number of nodes. """
    graph = {}
    for key in range(num_nodes):
        values = []
        for value in range(num_nodes):
            if value != key:
                values.append(value)
        graph[key] = set(values)
    return graph

def compute_in_degrees(digraph):
    """ Function that takes a directed
        graph digraph and computes the
        in-degrees for the nodes in the
        graph. """
    in_graph = {}
    for key, values in digraph.items():
        if not in_graph.get(key):
            in_graph[key] = 0
        for value in values:
            if in_graph.get(value):
                in_graph[value] += 1
            else:
                in_graph[value] = 1
    return in_graph

def in_degree_distribution(digraph):
    """ Takes a directed graph digraph
        and computes the unnormalized
        distribution of the in-degrees
        of the graph. """
    deg_graph = {}
    in_graph = compute_in_degrees(digraph)
    for value in in_graph.values():
        if not deg_graph.get(value):
            deg_graph[value] = 1
        else:
            deg_graph[value] += 1
    return deg_graph