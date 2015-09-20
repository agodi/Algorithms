class TreeNode(object):

    def __init__(self, data):
        self.__data = data
        self.left = None
        self.right = None

    def get_data(self):
        return self.__data

    def __str__(self):
        return str(self.__data) + \
        " [ " + str(self.left) + \
        "," + str(self.right) + " ]"

if __name__ == "__main__":
    node = TreeNode(1)
    node.left = TreeNode(0)
    node.right = TreeNode(3)
    print node.get_data()