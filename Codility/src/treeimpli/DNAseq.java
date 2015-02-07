package treeimpli;
/*
 * Solution to
 * https://codility.com/demo/take-sample-test/genomic_range_query/
 */
public class DNAseq {


public static void main(String[] args) {
    String S="CAGCCTA";
    int[] P={2, 5, 0};
    int[] Q={4, 5, 6};
    int [] results=solution(S,P,Q);
    System.out.println(results[0]);
}

static class segmentNode{
    int l;
    int r;
    int min;
    segmentNode left;
    segmentNode right;
}



public static segmentNode buildTree(int[] arr,int l,int r){
    if(l==r){
        segmentNode n=new segmentNode();
        n.l=l;
        n.r=r;
        n.min=arr[l];
        return n;
    }
    int mid=l+(r-l)/2;
    segmentNode le=buildTree(arr,l,mid);
    segmentNode re=buildTree(arr,mid+1,r);
    segmentNode root=new segmentNode();
    root.left=le;
    root.right=re;
    root.l=le.l;
    root.r=re.r;

    root.min=Math.min(le.min,re.min);

    return root;
}

public static int getMin(segmentNode root,int l,int r){
    if(root.l>r || root.r<l){
        return Integer.MAX_VALUE;
    }
    if(root.l>=l&& root.r<=r) {
        return root.min;
    }
    return Math.min(getMin(root.left,l,r),getMin(root.right,l,r));
}
public static int[] solution(String S, int[] P, int[] Q) {
    int[] arr=new int[S.length()];
    for(int i=0;i<S.length();i++){
        switch (S.charAt(i)) {
        case 'A':
            arr[i]=1;
            break;
        case 'C':
            arr[i]=2;
            break;
        case 'G':
            arr[i]=3;
            break;
        case 'T':
            arr[i]=4;
            break;
        default:
            break;
        }
    }

    segmentNode root=buildTree(arr,0,S.length()-1);
    int[] result=new int[P.length];
    for(int i=0;i<P.length;i++){
        result[i]=getMin(root,P[i],Q[i]);
    }
    return result;
} 

}
