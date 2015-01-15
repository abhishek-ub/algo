'''
Created on 09-Jan-2015

@author: Abhishek
'''

class Node:
    def __init__(self):
        self.left=None
        self.right=None
        self.sum=None
        self.leftNode=None
        self.rightNode=None

class SegmentTree:

    def buildTree(self,arr,l,r):
        
        if(l==r):
            n=Node()
            n.left=l
            n.right=r
            n.sum=arr[l]
            return n
        mid=(l+r)/2
        left=self.buildTree(arr,l,mid)
        right=self.buildTree(arr,mid+1,r)
        
        root=Node()
        root.left=left.left
        root.right=right.right
        root.leftNode=left
        root.rightNode=right
        root.sum=left.sum+right.sum
        return root
    
    def getSum(self,root,l,r):
        if(root.right<l or root.left>r):
            return 0
        if(root.left>=l and root.right<=r):
            return root.sum
        return self.getSum(root.leftNode, l, r)+self.getSum(root.rightNode, l, r)
    
    def swap(self,arr,l,r):
        num=(r-l+1)/2
        while(num>0):
            num-=1
            temp=arr[l+1]
            arr[l+1]=arr[l]
            arr[l]=temp
            l+=2
'''

'''
segtree=SegmentTree()
inp=map(int, str(raw_input()).split( ))
arr=map(int, str(raw_input()).split( ))
root=segtree.buildTree(arr, 0, len(arr)-1)
while(inp[1]>0):
    inp[1]-=1
    qry=map(int, str(raw_input()).split( ))
    if(qry[0]==1):
        segtree.swap(arr,qry[1]-1,qry[2]-1)
        root=segtree.buildTree(arr, 0, len(arr)-1)
    else:
        print(segtree.getSum(root, qry[1]-1, qry[2]-1))
