class GraphNode:
    """Class to represent nodes in a graph"""

    def __init__(self, value):
        self.data = value
        self.visited = False


def dfs(graph, node1, node2):
    if node1 == node2:
        return True
    if node1.visited:
        return False
    node1.visited = True
    flag = False
    for x in graph[node1]:
        flag = dfs(graph, x, node2)
        if flag:
            break
    return flag

s = GraphNode("s")
a = GraphNode("a")
b = GraphNode("b")
c = GraphNode("c")
d = GraphNode("d")
e = GraphNode("e")
x = GraphNode("x")

graph = {
    s: [a, b],
    a: [s, c, b],
    b: [a, s, d],
    c: [a, e, d],
    d: [c, e, b],
    e: [c, d]
    }

print dfs(graph, s, x)