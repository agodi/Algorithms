class Node:

    def __init__(self, value):
        self.data = value
        self.right = None
        self.left = None
        self.visited = False


def print_post_order(tree):
    stack = [tree]
    node = None
    while len(stack) != 0:
        if stack[-1].visited:
            node = stack.pop()
            print(node.data)
        else:
            stack[-1].visited = True
            node = stack[-1]
            if node.right is not None:
                stack.append(node.right)
            if node.left is not None:
                stack.append(node.left)


node1 = Node(5)
node2 = Node(2)
node3 = Node(-4)
node4 = Node(3)
node5 = Node(18)

node1.left = node2
node1.right = node5
node2.left = node3
node2.right = node4

print_post_order(node1)